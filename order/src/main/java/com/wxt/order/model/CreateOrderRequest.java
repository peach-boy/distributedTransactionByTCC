package com.wxt.order.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CreateOrderRequest {
    private String outTradeNo;

    private BigDecimal orderAmount;

    private String remark;
}
