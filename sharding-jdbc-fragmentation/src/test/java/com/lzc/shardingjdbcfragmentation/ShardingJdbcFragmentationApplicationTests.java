package com.lzc.shardingjdbcfragmentation;

import com.lzc.shardingjdbcfragmentation.entiy.Order;
import com.lzc.shardingjdbcfragmentation.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ShardingJdbcFragmentationApplicationTests {

    @Autowired
    OrderService orderService;

//    @Test
//    void contextLoads() {
//    }

    @Test
    public void insert(){
        Order order = new Order();
            order.setName("i"+5);
            order.setType("0");
            order.setGmtCreate(new Date());
            orderService.insertOrder(order);

//        for(int i=0;i<100;i++){
//            Order order = new Order();
//            order.setName("i"+i);
//            order.setType("0");
//            order.setGmtCreate(new Date());
//            orderService.insertOrder(order);
//        }
    }

    @Test
    public void test02(){
        Date date = new Date();
        System.out.println((date.getTime()));
        System.out.println(date.toInstant());
    }

}
