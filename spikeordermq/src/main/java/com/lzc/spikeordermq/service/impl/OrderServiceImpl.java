package com.lzc.spikeordermq.service.impl;

import com.lzc.spikeordermq.common.Dict;
import com.lzc.spikeordermq.dao.OrderDao;
import com.lzc.spikeordermq.service.OrderService;
import com.lzc.spikeordermq.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public void order(String userId, String goodsId) {
        Map map = new HashMap();
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0,0);
        map.put("id",Long.toString(idWorker.nextId()));
        map.put("userId",userId);
        map.put("goodsId",goodsId);
        orderDao.insertOrderRecord(map);
    }
}
