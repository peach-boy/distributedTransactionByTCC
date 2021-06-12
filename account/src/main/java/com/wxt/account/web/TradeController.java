package com.wxt.account.web;

import com.alibaba.fastjson.JSON;
import com.wxt.common.model.AccountPayReqeust;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/9 15:54
 * @Description:账户交易相关
 */
@Api("账户扣减")
@RestController
@RequestMapping(value = "/account")
public class TradeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);

    @ApiOperation(value = "预支付", notes = "支付")
    @PostMapping(value = "/tryPay")
    public boolean tryPay(@RequestBody AccountPayReqeust reqeust) {
        LOGGER.info("account_tryPay:param:{}", JSON.toJSONString(reqeust));
        return Boolean.TRUE;
    }

    @PostMapping(value = "/comfirmPay")
    public boolean comfirmPay(@RequestParam String tradeNo) {
        LOGGER.info("account_comfirmPay:{}", tradeNo);
        return Boolean.TRUE;
    }

    @PostMapping(value = "/cancelPay")
    public boolean cancelPay(@RequestParam String tradeNo) {
        LOGGER.info("account_cancelPay:{}", tradeNo);
        return Boolean.TRUE;
    }
}
