package com.wxt.payment.web;

import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.common.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 15:24
 * @Email:xiantao.wu@guanaitong.com
 */
@ControllerAdvice
public class ExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessRuntimeException.class)
    @ResponseBody
    public ApiResponse handleBusinessException(BusinessRuntimeException e) {
        LOGGER.error(e.toString());
        String message = e.getErrorMsg();
        return ApiResponse.fail(e.getErrorCode(), message);
    }
}
