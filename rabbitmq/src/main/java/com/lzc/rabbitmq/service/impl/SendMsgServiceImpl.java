package com.lzc.rabbitmq.service.impl;

import com.lzc.rabbitmq.service.SendMsgService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/10
 * @Description
 */
@Service
public class SendMsgServiceImpl implements SendMsgService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void send() {

            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("hello", context);

    }

    @Override
    public void oneToMany() throws Exception {

            for (int i=0;i<10;i++){
                send();
            }

    }

    @Override
    public void fanoutSend() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
