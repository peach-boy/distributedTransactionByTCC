package com.wxt.payment.manager.tcc;

/**
 * 事务执行上下文
 */
public class TCCContext {
    //事务ID
    private String trxId;

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }
}
