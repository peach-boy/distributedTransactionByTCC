package com.wxt.payment.model.request;

import com.wxt.payment.model.PayContext;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:44
 * @Description:
 */
public class PayRequest {
    @ApiModelProperty(value = "用户ID")
    @NotBlank
    private String userId;

    @ApiModelProperty(value = "应用ID")
    @NotBlank
    private String appId;

    @ApiModelProperty(value = "订单金额")
    @NotNull
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "外部订单号")
    @NotBlank
    private String outTradeNo;

    @ApiModelProperty(value = "资产类型")
    @NotBlank
    private String assetCode;

    @ApiModelProperty(value = "资产编号")
    @NotBlank
    private String assetContent;

    @NotBlank
    private String remark;


    public PayContext convertToPayContext() {
        PayContext payContext = new PayContext();
        payContext.setAppId(this.appId);
        payContext.setUserId(this.userId);
        payContext.setAssetCode(this.assetCode);
        payContext.setAssetContent(this.getAssetContent());
        payContext.setOrderAmount(this.orderAmount);
        payContext.setOutTradeNo(this.outTradeNo);
        payContext.setRemark(this.remark);
        payContext.setLockKey(this.outTradeNo);
        return payContext;
    }

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
