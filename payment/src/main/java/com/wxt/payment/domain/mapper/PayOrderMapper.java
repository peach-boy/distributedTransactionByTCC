package com.wxt.payment.domain.mapper;


import com.wxt.payment.domain.entity.PayOrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @Description: 支付单
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 13:41
 * @Email:1414924381@qq.com
 */
@Mapper
public interface PayOrderMapper {

    int insert(PayOrderDO payOrderDO);

    int updateStatus(@Param("outTradeNo") String outTradeNo, @Param("newStatus") Integer newStatus, @Param("oldStatus") Integer oldStatus);

    PayOrderDO getByOutTradeNo(String outTradeNo);


}
