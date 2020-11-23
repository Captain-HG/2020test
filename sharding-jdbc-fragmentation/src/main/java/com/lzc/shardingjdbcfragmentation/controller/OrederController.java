package com.lzc.shardingjdbcfragmentation.controller;

import com.lzc.shardingjdbcfragmentation.entiy.Order;
import com.lzc.shardingjdbcfragmentation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @AUTHOR HG-captain
 * @Data 2020/7/23
 * @Description
 */
@RestController
public class OrederController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/test01")
    public String  test(){
        for(int i=0;i<100;i++){
            Order order = new Order();
            order.setName("i"+i);
            order.setType("0");
            order.setGmtCreate(new Date());
            orderService.insertOrder(order);
        }
        return  "ok";
    }
}
