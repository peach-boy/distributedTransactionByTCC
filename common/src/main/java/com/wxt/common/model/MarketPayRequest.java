package com.wxt.common.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/12 21:37
 * @Email:xiantao.wu@guanaitong.com
 */
public class MarketPayRequest extends BasePayRequest {
    @NotNull
    private String tradeNo;
    @NotNull
    private BigDecimal tradeAmount;

    @NotNull
    private String redEnvelopeId;

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

    public String getRedEnvelopeId() {
        return redEnvelopeId;
    }

    public void setRedEnvelopeId(String redEnvelopeId) {
        this.redEnvelopeId = redEnvelopeId;
    }
}
