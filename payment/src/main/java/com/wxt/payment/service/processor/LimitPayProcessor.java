package com.wxt.payment.service.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:04
 * @Description:额度系统
 */
@Component
public class LimitPayProcessor implements PayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LimitPayProcessor.class);

    @Override
    public void tryPay() {
        LOGGER.info("tryPay------{}",this.getClass().getName());
    }

    @Override
    public void comfirmPay() {
        LOGGER.info("comfirmPay------{}",this.getClass().getName());
    }

    @Override
    public void cancelPay() {
        LOGGER.info("cancelPay------{}",this.getClass().getName());
    }
}
