package com.lzc.rabbitmq.controller;

import com.lzc.rabbitmq.service.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/10
 * @Description
 */
@RestController
public class TestController {
    @Autowired
    SendMsgService sendMsgService;
    @RequestMapping("/test01")
    public String test01(){
        sendMsgService.send();
        return "ok";
    }

    @RequestMapping("/test02")
    public String test02() throws Exception {
        sendMsgService.oneToMany();
        return "ok";
    }

    @RequestMapping("/test03")
    public String test03() throws Exception {
        sendMsgService.fanoutSend();
        return "ok";
    }
}
