package com.lzc.spikeordermq.controller;

import com.lzc.spikeordermq.common.CommonValue;
import com.lzc.spikeordermq.common.Dict;
import com.lzc.spikeordermq.config.JedisConfig;
import com.lzc.spikeordermq.config.JedisLock;
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

    @Value("${redis.top.key}")
    String redisTopLey;

    @RequestMapping("/test01/{userId}/{requestId}")
    public boolean test01(@PathVariable(name = "userId") String userId,@PathVariable(name = "requestId") String requestId){
        Map map = new HashMap();
        map.put(Dict.STATUS, CommonValue.REDIS_SAVE_STATUS_1);
        map.put(Dict.REQUESTID, requestId);
        return JedisLock.setnx(redisTopLey+userId+requestId,map.toString(),20000);
    }

    @RequestMapping("/test02/{userId}/{requestId}")
    public int test02(@PathVariable(name = "userId") String userId,@PathVariable(name = "requestId") String requestId){
        Map map = new HashMap();
        map.put(Dict.STATUS, CommonValue.REDIS_SAVE_STATUS_1);
        map.put(Dict.REQUESTID, requestId);
        return JedisLock.delnx(redisTopLey+userId+requestId,map.toString());
    }
}
