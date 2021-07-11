package com.wxt.payment.service.helper;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 14:55
 * @Email:1414924381@qq.com
 */
@Component
public class OrderNoGenerateHelper {

    public String markePayOrderNo() {
        UUID uuid = UUID.randomUUID();
        return "P" + System.currentTimeMillis() + uuid.toString();
    }
}
