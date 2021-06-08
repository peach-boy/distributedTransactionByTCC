package com.wxt.payment.service.processor;

import com.wxt.payment.model.PayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:03
 * @Description:账户系统
 */
@Component
public class AccountPayProcessor extends AbstractPayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountPayProcessor.class);

    @Override
    public Boolean doTryPay(PayContext payContext) {

        return true;
    }

    @Override
    public Boolean doComfirmPay(PayContext payContext) {

        throw new RuntimeException();
    }

    @Override
    public Boolean doCancelPay(PayContext payContext) {

        return true;
    }
}
