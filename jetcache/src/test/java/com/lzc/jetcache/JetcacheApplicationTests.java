package com.lzc.jetcache;

import com.lzc.jetcache.dao.UserDao;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JetcacheApplicationTests {
   @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.selectUserByUId("1"));
    }

}
