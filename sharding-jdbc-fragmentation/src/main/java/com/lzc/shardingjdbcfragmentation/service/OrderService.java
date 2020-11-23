package com.lzc.shardingjdbcfragmentation.service;

import com.lzc.shardingjdbcfragmentation.entiy.Order;

/**
 * @AUTHOR HG-captain
 * @Data 2020/7/22
 * @Description
 */
public interface OrderService {
    /**
     * 插入新的数据
     * @param order
     */
    void insertOrder(Order order);
}
