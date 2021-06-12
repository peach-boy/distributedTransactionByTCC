package com.wxt.common.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/12 18:28
 * @Email:xiantao.wu@guanaitong.com
 */
public class AccountPayReqeust {
    @NotNull
    private String tradeNo;
    @NotNull
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
