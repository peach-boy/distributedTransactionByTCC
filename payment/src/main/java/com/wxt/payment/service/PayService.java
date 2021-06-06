package com.wxt.payment.service;

import com.wxt.payment.model.PayContext;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:52
 * @Description:
 */
public interface PayService {

    Boolean pay(PayContext context);
}
