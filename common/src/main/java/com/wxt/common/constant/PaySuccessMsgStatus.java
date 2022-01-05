package com.wxt.common.constant;

public enum PaySuccessMsgStatus {
    WAIT_SEND(1, "待发送"),
    SENDED(2, "已发送"),
    SEND_SUCCESS(3, "通知成功");

    private Integer status;

    private String desc;

    PaySuccessMsgStatus(Integer status, String desc) {
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
