package com.lzc.spikeordermq.service;

import java.util.Map;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/15
 * @Description
 */
public interface UserOrderService {

    /**
     * 生成订单发送信息
     * @param map
     */
    void seckill(Map map);


    void payMsg(Map map);
}
