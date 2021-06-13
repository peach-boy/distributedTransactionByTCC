package com.wxt.payment.model;

import java.math.BigDecimal;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:53
 * @Description:
 */
public class PayContext {
    private String userId;

    private String appId;

    private BigDecimal orderAmount;

    private String outTradeNo;

    private String assetCode;

    private String assetContent;

    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetContent() {
        return assetContent;
    }

    public void setAssetContent(String assetContent) {
        this.assetContent = assetContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
