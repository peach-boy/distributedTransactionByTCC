package com.wxt.common.api;

import com.wxt.common.model.MarketPayRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


/**
 * @Description: 营销服务
 * @Auther: xiantao.wu
 * @Date: 2021/6/8 21:51
 * @Email:xiantao.wu@guanaitong.com
 */
public interface MarketService {

    @RequestLine("POST /market/tryPay")
    @Headers("Content-Type: application/json")
    Boolean tryPay(MarketPayRequest request);

    @RequestLine("POST /market/comfirmPay")
    Boolean comfirmPay(@Param("tradeNo") String tradeNo);

    @RequestLine("POST /market/cancelPay")
    Boolean cancelPay(@Param("tradeNo") String tradeNo);
}
