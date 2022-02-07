package com.wxt.order.web;

import com.wxt.common.model.ApiResponse;
import com.wxt.order.model.CreateOrderRequest;
import com.wxt.order.service.BizOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("订单")
@RestController
@RequestMapping("/order")
public class BizOrderController {

    @Resource
    private BizOrderService bizOrderService;

    @ApiOperation(value = "创建订单", notes = "创建订单")
    @PostMapping("/create")
    public ApiResponse<Boolean> createOrder(@RequestBody CreateOrderRequest request) {
        return ApiResponse.success(bizOrderService.createOrder(request));
    }
}
