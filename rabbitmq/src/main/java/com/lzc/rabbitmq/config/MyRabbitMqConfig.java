package com.lzc.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/10
 * @Description 简单模式
 */
@Configuration
public class MyRabbitMqConfig {


    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }


}
