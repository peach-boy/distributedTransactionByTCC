package com.wxt.common.constant;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 15:20
 * @Email:1414924381@qq.com
 */
public enum ErrorCode {
    SYSTEM_ERROR(1000100001, "系统异常"),
    PAY_FAIL(1000100002, "支付失败"),

    DISTRIBUTE_LOCKING(1000100003, "资源锁定中"),
    ALREADY_PAY(1000100004, "订单已支付"),
    LOCKING(1000100003, "锁定中"),
    PAY_ORDER_NOT_EXSIT(1000100004, "订单不存在"),

    ;


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
