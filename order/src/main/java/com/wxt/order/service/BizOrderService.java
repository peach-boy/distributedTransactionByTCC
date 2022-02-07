package com.wxt.order.service;

import com.alibaba.fastjson.JSON;
import com.wxt.common.constant.BizOrderStatusEnum;
import com.wxt.order.domain.entity.BizOrderDO;
import com.wxt.order.domain.mapper.BizOrderMapper;
import com.wxt.order.manager.RabbitMQProducer;
import com.wxt.order.model.CreateOrderRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单
 */
@Service
public class BizOrderService {

    @Resource
    private BizOrderMapper bizOrderMapper;

    @Resource
    private RabbitMQProducer rabbitMQProducer;

    public boolean createOrder(CreateOrderRequest request) {
        BizOrderDO bizOrderDO = new BizOrderDO();
        bizOrderDO.setOrderAmount(request.getOrderAmount());
        bizOrderDO.setOutTradeNo(request.getOutTradeNo());
        bizOrderDO.setRemark(request.getRemark());
        bizOrderDO.setStatus(BizOrderStatusEnum.order_success.getStatus());
        bizOrderMapper.insert(bizOrderDO);

        rabbitMQProducer.send(JSON.toJSONString(request));
        return true;
    }

    public boolean closeOrder(String outTradeNo) {
        bizOrderMapper.updateStatus(outTradeNo, BizOrderStatusEnum.ORDER_CLOSED.getStatus(), BizOrderStatusEnum.order_success.getStatus());
        return true;
    }
}
