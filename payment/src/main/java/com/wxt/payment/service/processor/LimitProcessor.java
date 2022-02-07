package com.wxt.payment.service.processor;

import com.wxt.common.api.LimitService;
import com.wxt.common.model.LimitPayRequest;
import com.wxt.payment.manager.tcc.AbstractTCCProcessor;
import com.wxt.payment.manager.tcc.TCCContext;
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
public class LimitProcessor extends AbstractPayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LimitProcessor.class);

    @Autowired
    private LimitService limitService;

    @Override
    public Boolean doTryPay(PayContext context) {
        LimitPayRequest request = new LimitPayRequest();
        request.setTradeNo(context.getOutTradeNo());
        request.setTradeAmount(context.getOrderAmount());
        limitService.tryPay(request);
        return true;
    }

    @Override
    public Boolean doComfirmPay(PayContext context) {
        LimitPayRequest request = new LimitPayRequest();
        request.setTradeNo(context.getOutTradeNo());
        request.setTradeAmount(context.getOrderAmount());
        limitService.comfirmPay(request);
        return true;
    }

    @Override
    public Boolean doCancelPay(PayContext context) {
        LimitPayRequest request = new LimitPayRequest();
        request.setTradeNo(context.getOutTradeNo());
        request.setTradeAmount(context.getOrderAmount());
        limitService.cancelPay(request);
        return true;
    }
}
