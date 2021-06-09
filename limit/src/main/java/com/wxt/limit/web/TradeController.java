package com.wxt.limit.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/9 15:54
 * @Description:额度交易相关
 */
@RestController
@RequestMapping(value = "/limit")
public class TradeController {

    @PostMapping(value = "/pay")
    public boolean consume() {

        return Boolean.TRUE;
    }
}
