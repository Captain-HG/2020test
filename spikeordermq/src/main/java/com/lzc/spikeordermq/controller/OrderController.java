package com.lzc.spikeordermq.controller;

import com.lzc.spikeordermq.common.CommonValue;
import com.lzc.spikeordermq.common.Dict;
import com.lzc.spikeordermq.config.JedisConfig;
import com.lzc.spikeordermq.config.JedisLock;
import com.lzc.spikeordermq.service.OrderService;
import com.lzc.spikeordermq.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
@RestController
public class OrderController {

    @Autowired
    JedisLock JedisLock;
    @Autowired
    UserOrderService userOrderService;
    @Autowired
    OrderService orderService;

    @Value("${redis.top.key}")
    String redisTopLey;

    /**
     * 下单
     * @param userId
     * @param requestId
     * @param goodsId
     * @return
     */
    @RequestMapping("/test01/{userId}/{requestId}/{goodsId}")
    public boolean test01(@PathVariable(name = "userId") String userId,@PathVariable(name = "requestId") String requestId,@PathVariable(name = "goodsId") String goodsId){
        Map map = new HashMap();
        map.put(Dict.STATUS, CommonValue.REDIS_SAVE_STATUS_1);
        map.put(Dict.REQUESTID, requestId);
        boolean b = JedisLock.setnx(redisTopLey + userId + requestId, map.toString(), 20000);
        if(b){
            map.put("userid",userId);
            map.put("goodsId",goodsId);
            userOrderService.seckill(map);
        }
        return  b;
    }

    @RequestMapping("/test02/{userId}/{requestId}")
    public int test02(@PathVariable(name = "userId") String userId,@PathVariable(name = "requestId") String requestId){
        Map map = new HashMap();
        map.put(Dict.STATUS, CommonValue.REDIS_SAVE_STATUS_1);
        map.put(Dict.REQUESTID, requestId);
        return JedisLock.delnx(redisTopLey+userId+requestId,map.toString());
    }

    @RequestMapping("/test03/{userId}/{requestId}/{goodsId}")
    public String test03(@PathVariable(name = "userId") String userId,@PathVariable(name = "requestId") String requestId,@PathVariable(name = "goodsId") String goodsId){
        orderService.order(userId,goodsId);
        return "ok";
    }

    /**
     * 去支付，增加死信队列交换机，设置支付时间，
     * @param orderId 订单号
     * @return
     */
    @RequestMapping("/test04/{orderId}")
    public String test04(@PathVariable(name = "orderId") String orderId){
        //发送支付消息队列信息
        Map map = new HashMap();
        map.put(Dict.ORDERID,orderId);
        userOrderService.payMsg(map);
        return "ok";
    }


}
