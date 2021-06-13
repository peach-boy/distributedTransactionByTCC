package com.wxt.common.exception;

import com.wxt.common.constant.ErrorCode;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 15:26
 * @Email:xiantao.wu@guanaitong.com
 */
public class BusinessRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int errorCode;

    private String errorMsg;

    public BusinessRuntimeException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessRuntimeException(ErrorCode errorCode) {
        this(errorCode.getErrorCode(), errorCode.getErrorMsg());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
