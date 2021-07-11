package com.wxt.payment.web;

import com.wxt.common.constant.ErrorCode;
import com.wxt.common.constant.RedisLock;
import com.wxt.common.model.ApiResponse;
import com.wxt.payment.facade.PayServiceFacade;
import com.wxt.payment.model.request.PayRequest;
import com.wxt.payment.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:44
 * @Description:
 */
@Api("支付")
@RestController
public class PayController {

    @Autowired
    private PayServiceFacade payServiceFacade;

    @ApiOperation(value = "支付", notes = "支付")
    @PostMapping(value = "/pay")
    @RedisLock(keyPrefix = "pay_",expire = 15,unLockrroCode = ErrorCode.ORDER_IS_PENDDING)
    public ApiResponse<String> pay(PayRequest payRequest) {
        String payOrderNo = payServiceFacade.pay(payRequest.convertToPayContext());
        return ApiResponse.success(payOrderNo);
    }
}
