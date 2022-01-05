package com.wxt.payment.manager;

import com.wxt.common.constant.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ manager
 */
@Component
public class RabbitMQManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQManager.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String jsonStr) {
        try {
            rabbitTemplate.convertAndSend(RabbitMQConstant.PAY_COMPLETE_DIRECT_EXCHANGE, RabbitMQConstant.PAY_COMPLETE_DIRECT_ROUTEKEY, jsonStr);
            LOGGER.info("sended_mq_info:{}", jsonStr);
        } catch (Exception e) {
            LOGGER.error("MQ发送异常：{}", jsonStr);
        }
    }
}
