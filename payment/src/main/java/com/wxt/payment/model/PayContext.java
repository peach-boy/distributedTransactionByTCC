package com.wxt.payment.model;

import java.math.BigDecimal;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:53
 * @Description:
 */
public class PayContext extends BaseContext {
    private BigDecimal amount;

    private String orderNo;

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

}
