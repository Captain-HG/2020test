package com.lzc.rabbitmq.config;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/10
 * @Description 接收消息
 */
@Component

public class ReceiverConfig {
    @RabbitListener(queues = "hello")
    public void process(String msg) {
        System.out.println("Receiver1  : " + msg);
    }

    @RabbitListener(queues = "hello")
    public void process2(String msg) {
        System.out.println("Receiver2  : " + msg);
    }



    @RabbitListener(queues = "fanout.A")
    public void process3(String msg) {
        System.out.println("ReceiverA  : " + msg);
    }


    @RabbitListener(queues = "fanout.B")
    public void process4(String msg) {
        System.out.println("ReceiverB  : " + msg);
    }

    @RabbitListener(queues = "fanout.C")
    public void process5(String msg) {
        System.out.println("ReceiverC  : " + msg);
    }
}
