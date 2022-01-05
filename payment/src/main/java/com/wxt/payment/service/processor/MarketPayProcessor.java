package com.wxt.payment.service.processor;

import com.wxt.common.api.MarketService;
import com.wxt.common.model.MarketPayRequest;
import com.wxt.payment.model.PayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:03
 * @Description:营销系统
 */
@Component
public class MarketPayProcessor extends AbstractPayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketPayProcessor.class);

    @Autowired
    private MarketService marketService;

    @Override
    public Boolean doTryPay(PayContext payContext) {
        MarketPayRequest request = new MarketPayRequest();
        request.setTradeNo(payContext.getOutTradeNo());
        request.setTradeAmount(payContext.getOrderAmount());
        marketService.tryPay(request);
        return true;
    }

    @Override
    public Boolean doComfirmPay(PayContext payContext) {
        MarketPayRequest request = new MarketPayRequest();
        request.setTradeNo(payContext.getOutTradeNo());
        request.setTradeAmount(payContext.getOrderAmount());
        marketService.comfirmPay(request);
        return true;
    }

    @Override
    public Boolean doCancelPay(PayContext payContext) {
        MarketPayRequest request = new MarketPayRequest();
        request.setTradeNo(payContext.getOutTradeNo());
        request.setTradeAmount(payContext.getOrderAmount());
        marketService.cancelPay(request);
        return true;
    }
}
