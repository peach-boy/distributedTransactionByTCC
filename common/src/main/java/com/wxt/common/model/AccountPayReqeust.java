package com.wxt.common.model;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/12 18:28
 * @Email:1414924381@qq.com
 */
public class AccountPayReqeust extends BasePayRequest {
    private String tradeNo;
    private BigDecimal tradeAmount;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }
}
