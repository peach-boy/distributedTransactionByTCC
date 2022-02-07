package com.wxt.payment.service.impl;

import com.alibaba.fastjson.JSON;
import com.wxt.common.constant.ErrorCode;
import com.wxt.common.constant.PayStatusEnum;
import com.wxt.common.constant.PaySuccessMsgStatus;
import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.common.helper.OrderNoGenerateHelper;
import com.wxt.payment.domain.entity.PayOrderDO;
import com.wxt.payment.domain.entity.PaySuccessMsgDO;
import com.wxt.payment.domain.mapper.PayOrderMapper;
import com.wxt.payment.domain.mapper.PaySuccessMsgMapper;
import com.wxt.payment.manager.RabbitMQManager;
import com.wxt.payment.manager.ThreadPoolManager;
import com.wxt.payment.model.PayContext;
import com.wxt.payment.model.response.QueryPayStatusResponse;
import com.wxt.payment.service.PayService;
import com.wxt.payment.service.scene.SceneRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:52
 * @Description:
 */
@Service
public class PayServiceImpl implements PayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayService.class);

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private PaySuccessMsgMapper paySuccessMsgMapper;

    @Autowired
    private RabbitMQManager rabbitMQManager;

    @Autowired
    private ThreadPoolManager threadPoolManager;

    @Override
    public void checkPay(PayContext context) {
        PayOrderDO payOrder = payOrderMapper.getByOutTradeNo(context.getOutTradeNo());
        if (payOrder != null) {
            throw new BusinessRuntimeException(ErrorCode.ALREADY_PAY);
        }
    }

    @Override
    public Boolean prePay(PayContext context) {
        PayOrderDO payOrderDO = new PayOrderDO();
        payOrderDO.setAppId(context.getAppId());
        payOrderDO.setUserId(context.getUserId());
        payOrderDO.setAssetCode(context.getAssetCode());
        payOrderDO.setAssetContent(context.getAssetContent());
        payOrderDO.setOutTradeNo(context.getOutTradeNo());
        payOrderDO.setRemark(context.getRemark());
        payOrderDO.setPayStatus(PayStatusEnum.WAIT_PAY.getStatus());
        payOrderDO.setPayOrderNo(OrderNoGenerateHelper.markePayOrderNo());
        payOrderDO.setTradeAmount(context.getOrderAmount());
        payOrderMapper.insert(payOrderDO);

        context.setPayOrderNo(payOrderDO.getPayOrderNo());
        return Boolean.TRUE;
    }

    @Override
    public Boolean doPay(PayContext context) {
        payOrderMapper.updateStatus(context.getOutTradeNo(), PayStatusEnum.PAYING.getStatus(), PayStatusEnum.WAIT_PAY.getStatus());
        try {
            SceneRouter.getBySceneCode(context.getAssetCode()).execute(context);
        } catch (Exception e) {
            payOrderMapper.updateStatus(context.getOutTradeNo(), PayStatusEnum.PAY_FAIL.getStatus(), PayStatusEnum.PAYING.getStatus());
            throw new BusinessRuntimeException(ErrorCode.PAY_FAIL);
        }

        return Boolean.TRUE;
    }

    @Override
    @Transactional
    public Boolean postPay(PayContext context) {
        payOrderMapper.updateStatus(context.getOutTradeNo(), PayStatusEnum.PAY_SUCCESS.getStatus(), PayStatusEnum.PAYING.getStatus());

        PaySuccessMsgDO paySuccessMsgDO = new PaySuccessMsgDO();
        paySuccessMsgDO.setPayOrderNo(context.getPayOrderNo());
        paySuccessMsgDO.setStatus(PaySuccessMsgStatus.WAIT_SEND.getStatus());
        paySuccessMsgDO.setRetryTimes(0);
        paySuccessMsgMapper.insert(paySuccessMsgDO);

        threadPoolManager.submit(() -> {
            LOGGER.info("send_payment_success_mq_payOrder:{}", context.getPayOrderNo());
            rabbitMQManager.send(JSON.toJSONString(context));
        });

        threadPoolManager.submit(() -> {
            // 异步线程通知外部应用
        });
        return Boolean.TRUE;
    }

    @Override
    public QueryPayStatusResponse queryPayStatus(String outerTradeNo) {
        PayOrderDO payOrderDO = payOrderMapper.getByOutTradeNo(outerTradeNo);
        if (payOrderDO == null) {
            throw new BusinessRuntimeException(ErrorCode.PAY_ORDER_NOT_EXSIT);
        }

        QueryPayStatusResponse response = new QueryPayStatusResponse();
        response.setOuterTradeNo(outerTradeNo);
        response.setPayOrderNo(payOrderDO.getPayOrderNo());
        response.setTradeAmount(payOrderDO.getTradeAmount());
        response.setPayStatus(payOrderDO.getPayStatus());
        return response;
    }
}
