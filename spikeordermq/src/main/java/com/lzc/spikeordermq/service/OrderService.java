package com.lzc.spikeordermq.service;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
public interface OrderService {
    /**
     * 下订单
     * @param userId
     * @param goodsId
     */
    void order(String userId, String goodsId);
}
