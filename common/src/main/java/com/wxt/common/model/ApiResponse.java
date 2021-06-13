package com.wxt.common.model;

import com.wxt.common.constant.ErrorCode;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 15:10
 * @Email:xiantao.wu@guanaitong.com
 */
public class ApiResponse<T> {
    private final static String succesMsg = "success";

    private final static int successCode = 0;

    private Integer code;

    private String msg;

    private T data;


    public static <T> ApiResponse<T> success(T data) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(successCode);
        apiResponse.setData(data);
        apiResponse.setMsg(succesMsg);
        return apiResponse;
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        ApiResponse<T> apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getErrorCode());
        apiResponse.setMsg(errorCode.getErrorMsg());
        return apiResponse;
    }

    public static <T> ApiResponse<T> fail(int code, String msg) {
        ApiResponse<T> apiResponse = new ApiResponse();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
