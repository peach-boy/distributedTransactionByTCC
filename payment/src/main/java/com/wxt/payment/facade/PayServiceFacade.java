package com.wxt.payment.facade;

import com.wxt.payment.manager.lock.DLockBaseInfo;
import com.wxt.payment.manager.lock.DLockManager;
import com.wxt.payment.model.PayContext;
import com.wxt.payment.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 支付相关
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
        DLockBaseInfo dLockBaseInfo = DLockBaseInfo.newInstance("pay_order", 10, TimeUnit.SECONDS);
        dLockManager.lockBizAround(context, dLockBaseInfo, (data) -> {
            payService.checkPay(context);

            payService.prePay(context);

            payService.doPay(context);
        });

        payService.postPay(context);
        return context.getPayOrderNo();
    }

}
