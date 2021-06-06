package com.wxt.payment.model.request;

import com.wxt.payment.model.PayContext;

import java.math.BigDecimal;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:44
 * @Description:
 */
public class PayRequest {
    private BigDecimal amount;

    private String orderNo;

    private String sceneCode;


    public PayContext convertToPayContext() {
        PayContext payContext = new PayContext();
        payContext.setAmount(this.amount);
        payContext.setOrderNo(this.orderNo);
        payContext.setSceneCode(this.sceneCode);
        return payContext;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }
}
