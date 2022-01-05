package com.wxt.payment.service;

import com.wxt.payment.model.PayContext;
import com.wxt.payment.model.response.QueryPayStatusResponse;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:52
 * @Description:
 */
public interface PayService {

    void checkPay(PayContext context);

    Boolean prePay(PayContext context);

    Boolean doPay(PayContext context);

    Boolean postPay(PayContext context);

    QueryPayStatusResponse queryPayStatus(String outerTradeNo);
}
