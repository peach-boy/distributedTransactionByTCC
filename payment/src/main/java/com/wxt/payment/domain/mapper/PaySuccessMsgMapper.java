package com.wxt.payment.domain.mapper;


import com.wxt.payment.domain.entity.PaySuccessMsgDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @Description: 支付成功通知消息
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 13:41
 * @Email:1414924381@qq.com
 */
@Mapper
public interface PaySuccessMsgMapper {

    int insert(PaySuccessMsgDO paySuccessMsgDO);

    int updateStatus(@Param("payOrderNo") String payOrderNo, @Param("newStatus") Integer newStatus, @Param("oldStatus") Integer oldStatus);

    int increaseRetryTimes(@Param("payOrderNo") String payOrderNo);


}
