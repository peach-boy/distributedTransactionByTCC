package com.wxt.payment.facade;

import com.wxt.payment.model.PayContext;
import com.wxt.payment.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 13:33
 * @Email:1414924381@qq.com
 */
@Service
public class PayServiceFacade {

    @Autowired
    private PayService payService;

    public String pay(PayContext context) {

        payService.checkPay(context);

        String payOrderNo = payService.prePay(context);

        payService.pay(context);

        payService.postPay(context);

        return payOrderNo;
    }
}
