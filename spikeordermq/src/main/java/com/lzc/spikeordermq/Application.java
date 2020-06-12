package com.lzc.spikeordermq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
@SpringBootApplication
@MapperScan(value = "com.lzc.spikeordermq.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
