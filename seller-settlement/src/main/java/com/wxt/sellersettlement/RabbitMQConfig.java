package com.wxt.sellersettlement;

import com.rabbitmq.client.Channel;
import com.wxt.common.constant.RabbitMQConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConfig.class);

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMQConstant.PAY_COMPLETE_DIRECT_QUEUE, durable = "true"),
            exchange = @Exchange(value = RabbitMQConstant.PAY_COMPLETE_DIRECT_EXCHANGE)))
    public void receiveDirect(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            String msg = new String(message.getBody());
            LOGGER.info("收到消息：" + msg);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicReject(tag, true);
        }
    }
}
