package com.wxt.payment.api;

import com.wxt.common.api.AccountService;
import com.wxt.common.api.LimitService;
import com.wxt.common.api.MarketService;
import feign.Contract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/12 16:38
 * @Email:1414924381@qq.com
 */
@Configuration
public class FeignConfig {

    private <T> T newInstance(Class<T> clazz, String url) {
        return Feign.builder()
                //添加解码器
                .decoder(new JacksonDecoder())
                //添加编码器
                .encoder(new JacksonEncoder())
                .target(clazz, url);
    }


    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }


    @Bean
    public AccountService accountService() {
        return newInstance(AccountService.class, "http://127.0.0.1:8081");
    }


    @Bean
    public LimitService limitService() {
        return newInstance(LimitService.class, "http://127.0.0.1:8082");
    }

    @Bean
    public MarketService marketService() {
        return newInstance(MarketService.class, "http://127.0.0.1:8083");
    }

}
