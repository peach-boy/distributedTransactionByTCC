package com.wxt.sellersettlement.domain.model;

import lombok.Data;

import java.math.BigDecimal;

public class CreateTradeDTO {
    private String outTradeNo;

    private BigDecimal orderAmount;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
