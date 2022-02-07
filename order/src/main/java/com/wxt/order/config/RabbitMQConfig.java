package com.wxt.order.config;

import com.wxt.common.constant.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.username}")
    private String userName;

    @Value("${spring.rabbitmq.password}")
    private String password;


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        return template;
    }

    //延迟Exchange
    @Bean("delayExchange")
    public DirectExchange DelayExchange() {
        return new DirectExchange(RabbitMQConstant.DELAY_EXCHANGE);
    }

    // 声明死信Exchange
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(RabbitMQConstant.DEAD_LETTER_EXCHANGE);
    }

    //延迟队列，并绑定对应的死信交换机
    @Bean
    public Queue delayQueue() {
        Map<String, Object> args = new HashMap<>(2);
        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitMQConstant.DEAD_LETTER_EXCHANGE);
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", RabbitMQConstant.DEAD_LETTER_ROUTE_KEY);
        // x-message-ttl  声明队列的TTL
        args.put("x-message-ttl", 15*1000);
        return QueueBuilder.durable(RabbitMQConstant.DELAY_QUEUE).withArguments(args).build();
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(RabbitMQConstant.DEAD_LETTER_QUEUE);
    }

    // 声明延时队列A绑定关系
    @Bean
    public Binding delayBinding(@Qualifier("delayQueue") Queue queue,
                                @Qualifier("delayExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.DELAY_ROUTEKEY);
    }

    // 声明死信队列A绑定关系
    @Bean
    public Binding deadLetterBinding(@Qualifier("deadLetterQueue") Queue queue,
                                     @Qualifier("deadLetterExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConstant.DEAD_LETTER_ROUTE_KEY);
    }

}
