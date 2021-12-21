package com.wxt.payment.web;

import com.wxt.common.model.ApiResponse;
import com.wxt.payment.service.helper.DeadLockHelpler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:44
 * @Description:
 */
@Api("测试接口")
@RestController
public class TestController {
    @Autowired
    private DeadLockHelpler deadLockHelpler;

    @ApiOperation(value = "测试死锁", notes = "测试死锁")
    @PostMapping(value = "/test_lock")
    public ApiResponse<String> test_lock(@RequestParam String outerTradeNo1, @RequestParam String outerTradeNo2, @RequestParam Integer sleepNum) {
        deadLockHelpler.test(outerTradeNo1, outerTradeNo2, sleepNum);
        return ApiResponse.success(null);
    }

}
