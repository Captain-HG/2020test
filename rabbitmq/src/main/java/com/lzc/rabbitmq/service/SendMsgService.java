package com.lzc.rabbitmq.service;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/10
 * @Description
 */
public interface SendMsgService {

    public void send() ;

    public void oneToMany() throws Exception ;

    public void fanoutSend();
}
