package com.wxt.sellersettlement.domain.entity;

import com.wxt.common.domain.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradeDO extends BaseDO {
    private String tradeNo;

    private String outTradeNo;

    private BigDecimal tradeAmount;

    private Integer tradeType;
}
