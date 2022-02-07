package com.wxt.order.domain.entity;


import com.wxt.common.domain.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BizOrderDO extends BaseDO {
    private String outTradeNo;

    private BigDecimal orderAmount;

    private String remark;

    private Integer status;
}
