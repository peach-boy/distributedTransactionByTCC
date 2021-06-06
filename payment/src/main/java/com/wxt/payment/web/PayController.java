package com.wxt.payment.web;

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
    private PayService payService;

    @ApiOperation(value = "支付", notes = "支付")
    @PostMapping(value = "/pay")
    public Boolean pay(PayRequest payRequest) {
        return payService.pay(payRequest.convertToPayContext());
    }
}
