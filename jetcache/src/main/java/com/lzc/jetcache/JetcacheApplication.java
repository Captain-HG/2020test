package com.lzc.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages = "com.com.lzc.jetcache.service")
@EnableCreateCacheAnnotation
@MapperScan(value = "com.com.lzc.jetcache.dao")
public class JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcacheApplication.class, args);
    }

}
