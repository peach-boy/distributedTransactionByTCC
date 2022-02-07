package com.wxt.common.constant;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 14:50
 * @Email:1414924381@qq.com
 */
public enum BizOrderStatusEnum {
    order_success(1, "下单成功"),
    PAY_SUCCESS(2, "支付成功"),
    ORDER_CLOSED(3, "订单关闭"),
    ;

    private Integer status;

    private String desc;

    BizOrderStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
