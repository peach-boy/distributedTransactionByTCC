package com.wxt.common.api;

import com.wxt.common.model.AccountPayReqeust;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


/**
 * @Description: 账户服务
 * @Auther: xiantao.wu
 * @Date: 2021/6/8 21:51
 * @Email:xiantao.wu@guanaitong.com
 */
@Headers("Content-Type: application/json")
public interface AccountService {

    @RequestLine("POST /account/tryPay")
    Boolean tryPay(AccountPayReqeust reqeust);

    @RequestLine("POST /account/comfirmPay")
    Boolean comfirmPay(@Param("tradeNo") String tradeNo);

    @RequestLine("POST /account/cancelPay")
    Boolean cancelPay(@Param("tradeNo") String tradeNo);
}
