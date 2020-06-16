package com.lzc.spikeordermq.service;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
public interface PayService {
    void confirmPay(String orderId) throws Exception;
}
