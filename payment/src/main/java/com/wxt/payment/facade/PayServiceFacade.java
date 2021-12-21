package com.wxt.payment.facade;

import com.wxt.payment.manager.DLockManager;
import com.wxt.payment.model.PayContext;
import com.wxt.payment.model.response.QueryPayStatusResponse;
import com.wxt.payment.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 支付接口
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 13:33
 * @Email:1414924381@qq.com
 */
@Service
public class PayServiceFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayServiceFacade.class);

    @Autowired
    private PayService payService;

    @Autowired
    private DLockManager dLockManager;

    public String pay(PayContext context) {

        dLockManager.lockAround(context, (data) -> {
            payService.checkPay(context);

            payService.prePay(context);

            payService.pay(context);
        });

        payService.postPay(context);
        return context.getPayOrderNo();
    }




}
