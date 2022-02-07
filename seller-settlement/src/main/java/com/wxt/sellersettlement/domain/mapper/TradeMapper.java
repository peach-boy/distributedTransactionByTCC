package com.wxt.sellersettlement.domain.mapper;


import com.wxt.sellersettlement.domain.entity.TradeDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description: 交易单
 * @Auther: xiantao.wu
 * @Date: 2021/6/13 13:41
 * @Email:1414924381@qq.com
 */
@Mapper
public interface TradeMapper {

    int insert(TradeDO tradeDO);

    TradeDO getByOutTradeNo(String outTradeNo);
}
