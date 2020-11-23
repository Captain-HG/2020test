package com.lzc.shardingjdbcfragmentation.service.impl;

import com.lzc.shardingjdbcfragmentation.entiy.Order;
import com.lzc.shardingjdbcfragmentation.mapper.OrderMapper;
import com.lzc.shardingjdbcfragmentation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @AUTHOR HG-captain
 * @Data 2020/7/22
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void insertOrder(Order order) {
        orderMapper.insert(order);
    }
}
