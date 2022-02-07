package com.wxt.order.manager;

import com.wxt.common.constant.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ 生产者
 */
@Component
public class RabbitMQProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String jsonStr) {
        try {
            rabbitTemplate.convertAndSend(RabbitMQConstant.DELAY_EXCHANGE, RabbitMQConstant.DELAY_ROUTEKEY, jsonStr);
            LOGGER.info("sended_mq_info:{}", jsonStr);
        } catch (Exception e) {
            LOGGER.error("MQ发送异常：{}", jsonStr);
        }
    }

}
