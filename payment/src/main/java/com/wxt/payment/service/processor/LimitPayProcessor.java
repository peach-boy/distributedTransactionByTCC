package com.wxt.payment.service.processor;

import com.wxt.common.api.LimitService;
import com.wxt.common.model.LimitPayRequest;
import com.wxt.payment.model.PayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:04
 * @Description:额度系统
 */
@Component
public class LimitPayProcessor extends AbstractPayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LimitPayProcessor.class);

    @Autowired
    private LimitService limitService;

    @Override
    public Boolean doTryPay(PayContext payContext) {
        LimitPayRequest request = new LimitPayRequest();
        request.setTradeNo(payContext.getOrderNo());
        request.setTradeAmount(payContext.getAmount());
        limitService.tryPay(request);
        return true;
    }

    @Override
    public Boolean doComfirmPay(PayContext payContext) {
        limitService.comfirmPay(payContext.getOrderNo());
        return true;
    }

    @Override
    public Boolean doCancelPay(PayContext payContext) {
        limitService.cancelPay(payContext.getOrderNo());
        return true;
    }
}
