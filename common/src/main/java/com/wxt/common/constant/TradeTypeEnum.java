package com.wxt.common.constant;

public enum TradeTypeEnum {
    PAY(1, "支付"),
    REFUND(2, "退款");

    private Integer type;

    private String desc;

    TradeTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
