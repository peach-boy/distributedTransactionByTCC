package com.wxt.payment.domain.entity;


/**
 * @Description: 支付成功消息
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 13:41
 * @Email:1414924381@qq.com
 */
public class PaySuccessMsgDO extends BaseDO {
    private String payOrderNo;

    private Integer status;

    private Integer retryTimes;

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }
}
