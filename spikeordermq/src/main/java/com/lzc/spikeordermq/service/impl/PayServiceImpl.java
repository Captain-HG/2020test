package com.lzc.spikeordermq.service.impl;

import com.lzc.spikeordermq.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public void confirmPay(String orderId) throws Exception {

      throw new Exception("13213");
    }
}
