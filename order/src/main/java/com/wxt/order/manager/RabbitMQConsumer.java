package com.wxt.order.manager;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.wxt.common.constant.RabbitMQConstant;
import com.wxt.order.model.CreateOrderRequest;
import com.wxt.order.service.BizOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * rabbitmq 消费者
 */
@Component
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Resource
    private BizOrderService bizOrderService;

    @RabbitListener(queues = RabbitMQConstant.DEAD_LETTER_QUEUE)
    public void receiveA(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());

        CreateOrderRequest request = JSON.parseObject(msg, CreateOrderRequest.class);
        bizOrderService.closeOrder(request.getOutTradeNo());

        LOGGER.info("当前时间：{},死信队列收到消息：{}", new Date().toString(), msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
