package com.wxt.common.constant;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 14:50
 * @Email:xiantao.wu@guanaitong.com
 */
public enum PayStatusEnum {
    WAIT_PAY(1, "待支付"),
    PAYING(2, "支付中"),
    PAY_SUCCESS(3, "支付成功"),
    PAY_FAIL(4, "支付失败");

    private Integer status;

    private String desc;

    PayStatusEnum(Integer status, String desc) {
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
