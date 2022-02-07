package com.wxt.common.helper;


import java.util.UUID;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 14:55
 * @Email:1414924381@qq.com
 */

public class OrderNoGenerateHelper {

    public static String markePayOrderNo() {
        UUID uuid = UUID.randomUUID();
        return "P" + System.currentTimeMillis() + uuid.toString();
    }

    public static String markeTradeNo() {
        UUID uuid = UUID.randomUUID();
        return "S" + System.currentTimeMillis() + uuid.toString();
    }
}
