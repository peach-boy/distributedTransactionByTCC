package com.wxt.payment.service.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:03
 * @Description:账户系统
 */
@Component
public class AccountPayProcessor implements PayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountPayProcessor.class);

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
