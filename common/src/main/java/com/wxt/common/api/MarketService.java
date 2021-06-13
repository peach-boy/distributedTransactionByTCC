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
@Headers("Content-Type: application/json")
public interface MarketService {

    @RequestLine("POST /market/tryPay")
    Boolean tryPay(MarketPayRequest request);

    @RequestLine("POST /market/comfirmPay")
    Boolean comfirmPay(MarketPayRequest request);

    @RequestLine("POST /market/cancelPay")
    Boolean cancelPay(MarketPayRequest request);
}
