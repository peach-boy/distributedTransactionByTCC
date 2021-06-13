package com.wxt.payment.service.impl;

import com.wxt.common.constant.ErrorCode;
import com.wxt.common.constant.PayStatusEnum;
import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.payment.domain.entity.PayOrderDO;
import com.wxt.payment.domain.mapper.PayOrderMapper;
import com.wxt.payment.model.PayContext;
import com.wxt.payment.service.PayService;
import com.wxt.payment.service.helper.OrderNoGenerateHelper;
import com.wxt.payment.service.scene.AbstractScene;
import com.wxt.payment.service.scene.SceneRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:52
 * @Description:
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private OrderNoGenerateHelper orderNoGenerateHelper;

    @Override
    public void checkPay(PayContext context) {
        //分布式锁，防重复支付 TODO

        PayOrderDO payOrder = payOrderMapper.getByOutTradeNo(context.getOutTradeNo());
        if (payOrder != null) {
            throw new BusinessRuntimeException(ErrorCode.ALREADY_PAY);
        }

        //验签 TODO

    }

    @Override
    public String prePay(PayContext context) {

        PayOrderDO payOrderDO = new PayOrderDO();
        payOrderDO.setAppId(context.getAppId());
        payOrderDO.setUserId(context.getUserId());
        payOrderDO.setAssetCode(context.getAssetCode());
        payOrderDO.setAssetContent(context.getAssetContent());
        payOrderDO.setOutTradeNo(context.getOutTradeNo());
        payOrderDO.setRemark(context.getRemark());
        payOrderDO.setPayStatus(PayStatusEnum.WAIT_PAY.getStatus());
        payOrderDO.setPayOrderNo(orderNoGenerateHelper.markePayOrderNo());
        payOrderDO.setTradeAmount(context.getOrderAmount());
        payOrderMapper.insert(payOrderDO);

        return payOrderDO.getPayOrderNo();
    }

    @Override
    public Boolean pay(PayContext context) {
        payOrderMapper.updateStatus(context.getOutTradeNo(), PayStatusEnum.PAYING.getStatus(), PayStatusEnum.WAIT_PAY.getStatus());
        try {
            SceneRouter.getBySceneCode(context.getAssetCode()).doPay(context);
        } catch (Exception e) {
            payOrderMapper.updateStatus(context.getOutTradeNo(), PayStatusEnum.PAY_FAIL.getStatus(), PayStatusEnum.PAYING.getStatus());
            throw new BusinessRuntimeException(ErrorCode.PAY_FAIL);
        }


        return Boolean.TRUE;
    }

    @Override
    public Boolean postPay(PayContext context) {
        payOrderMapper.updateStatus(context.getOutTradeNo(), PayStatusEnum.PAY_SUCCESS.getStatus(), PayStatusEnum.PAYING.getStatus());
        return null;
    }
}
