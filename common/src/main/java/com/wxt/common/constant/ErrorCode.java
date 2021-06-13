package com.wxt.common.constant;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 15:20
 * @Email:xiantao.wu@guanaitong.com
 */
public enum ErrorCode {
    SYSTEM_ERROR(1000100001, "系统异常"),
    PAY_FAIL(1000100002, "支付失败"),

    ALREADY_PAY(1000100003, "订单已支付");

    private int errorCode;

    private String errorMsg;


    ErrorCode(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
