package com.lzc.spikeordermq.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzc.spikeordermq.service.UserOrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/15
 * @Description
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;
    @Override
    public void seckill(Map map) {
        //设置交换机
        rabbitTemplate.setExchange(env.getProperty("order.mq.exchange.name"));
        //设置routingkey
        rabbitTemplate.setRoutingKey(env.getProperty("order.mq.routing.key"));
        //创建消息体
        Message msg = MessageBuilder.withBody(JSON.toJSONString(map).getBytes()).build();
        //发送消息
        rabbitTemplate.convertAndSend(msg);
    }

    @Override
    public void payMsg(Map map) {
        //设置交换机
        rabbitTemplate.setExchange(env.getProperty("pay.mq.exchange.name="));
        //设置routingkey
        rabbitTemplate.setRoutingKey(env.getProperty("pay.mq.queue.name"));
        //创建消息体
        Message msg = MessageBuilder.withBody(JSON.toJSONString(map).getBytes()).build();
        //发送消息
        rabbitTemplate.convertAndSend(msg);
    }
}
