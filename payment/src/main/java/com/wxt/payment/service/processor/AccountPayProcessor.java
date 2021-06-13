package com.wxt.payment.service.processor;

import com.wxt.common.api.AccountService;
import com.wxt.common.model.AccountPayReqeust;
import com.wxt.payment.model.PayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:03
 * @Description:账户系统
 */
@Component
public class AccountPayProcessor extends AbstractPayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountPayProcessor.class);

    @Autowired
    private AccountService accountService;

    @Override
    public Boolean doTryPay(PayContext payContext) {
        AccountPayReqeust accountPayReqeust=new AccountPayReqeust();
        accountPayReqeust.setTradeAmount(payContext.getOrderAmount());
        accountPayReqeust.setTradeNo(payContext.getOutTradeNo());
        accountService.tryPay(accountPayReqeust);

        return true;
    }

    @Override
    public Boolean doComfirmPay(PayContext payContext) {
        AccountPayReqeust accountPayReqeust=new AccountPayReqeust();
        accountPayReqeust.setTradeAmount(payContext.getOrderAmount());
        accountPayReqeust.setTradeNo(payContext.getOutTradeNo());
        accountService.comfirmPay(accountPayReqeust);

        return true;
    }

    @Override
    public Boolean doCancelPay(PayContext payContext) {
        AccountPayReqeust accountPayReqeust=new AccountPayReqeust();
        accountPayReqeust.setTradeAmount(payContext.getOrderAmount());
        accountPayReqeust.setTradeNo(payContext.getOutTradeNo());
        accountService.cancelPay(accountPayReqeust);

        return true;
    }
}
