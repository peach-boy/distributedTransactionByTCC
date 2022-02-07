package com.wxt.sellersettlement.service;

import com.wxt.common.constant.TradeTypeEnum;
import com.wxt.common.helper.OrderNoGenerateHelper;
import com.wxt.sellersettlement.domain.entity.TradeDO;
import com.wxt.sellersettlement.domain.mapper.TradeMapper;
import com.wxt.sellersettlement.domain.model.CreateTradeDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 交易相关
 */
@Service
public class TradeService {

    @Resource
    private TradeMapper tradeMapper;


    public void saveTrade(CreateTradeDTO createTradeDTO) {
        TradeDO tradeDO = new TradeDO();
        tradeDO.setOutTradeNo(createTradeDTO.getOutTradeNo());
        tradeDO.setTradeAmount(createTradeDTO.getOrderAmount());
        tradeDO.setTradeType(TradeTypeEnum.PAY.getType());
        tradeDO.setTradeNo(OrderNoGenerateHelper.markeTradeNo());
        tradeMapper.insert(tradeDO);
    }
}
