package com.wxt.common.api;

import com.wxt.common.model.LimitPayRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


/**
 * @Description: 额度服务
 * @Auther: xiantao.wu
 * @Date: 2021/6/8 21:51
 * @Email:xiantao.wu@guanaitong.com
 */
public interface LimitService {

    @RequestLine("POST /limit/tryPay")
    @Headers("Content-Type: application/json")
    Boolean tryPay(LimitPayRequest request);

    @RequestLine("POST /limit/comfirmPay")
    Boolean comfirmPay(@Param("tradeNo") String tradeNo);

    @RequestLine("POST /limit/cancelPay")
    Boolean cancelPay(@Param("tradeNo") String tradeNo);
}
