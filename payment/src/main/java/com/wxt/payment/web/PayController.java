package com.wxt.payment.web;

import com.wxt.common.model.ApiResponse;
import com.wxt.payment.facade.PayServiceFacade;
import com.wxt.payment.model.request.PayRequest;
import com.wxt.payment.model.response.QueryPayStatusResponse;
import com.wxt.payment.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:44
 * @Description:支付相关
 */
@Api("支付")
@RestController
public class PayController {

    @Autowired
    private PayServiceFacade payServiceFacade;

    @Autowired
    private PayService payService;


    @ApiOperation(value = "支付", notes = "支付")
    @PostMapping(value = "/pay")
    public ApiResponse<String> pay(@RequestBody @Valid PayRequest payRequest) {
        return ApiResponse.success(payServiceFacade.pay(payRequest.convertToPayContext()));
    }

    @ApiOperation(value = "支付状态查询", notes = "支付")
    @PostMapping(value = "/query_pay_status")
    public ApiResponse<QueryPayStatusResponse> queryPayStatus(@RequestParam String outerTradeNo) {
        return ApiResponse.success(payService.queryPayStatus(outerTradeNo));
    }

}
