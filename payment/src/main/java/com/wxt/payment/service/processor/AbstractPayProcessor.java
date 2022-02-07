package com.wxt.payment.service.processor;

import com.wxt.payment.manager.tcc.AbstractTCCProcessor;
import com.wxt.payment.manager.tcc.TCCContext;
import com.wxt.payment.model.PayContext;

public abstract class AbstractPayProcessor extends AbstractTCCProcessor {

    @Override
    public Boolean doTry(TCCContext context) {
        return this.doTryPay((PayContext) context);
    }

    @Override
    public Boolean doComfirm(TCCContext context) {
        return this.doComfirmPay((PayContext) context);
    }

    @Override
    public Boolean doCancel(TCCContext context) {
        return this.doCancelPay((PayContext) context);
    }

    public abstract Boolean doTryPay(PayContext context);

    public abstract Boolean doComfirmPay(PayContext context);

    public abstract Boolean doCancelPay(PayContext context);

}
