package com.wxt.order.domain.mapper;

import com.wxt.order.domain.entity.BizOrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BizOrderMapper {
    int insert(BizOrderDO bizOrderDO);

    int updateStatus(@Param("outTradeNo") String outTradeNo, @Param("newStatus") Integer newStatus, @Param("oldStatus") Integer oldStatus);

    BizOrderDO getByOutTradeNo(String outTradeNo);
}
