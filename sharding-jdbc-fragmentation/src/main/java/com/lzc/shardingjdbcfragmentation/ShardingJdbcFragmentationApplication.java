package com.lzc.shardingjdbcfragmentation;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzc.shardingjdbcfragmentation.mapper")
public class ShardingJdbcFragmentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcFragmentationApplication.class, args);
    }



}
