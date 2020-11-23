package com.lzc.provider;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderApplicationTests {

    @NacosValue(value = "${provider-name}")
    private String proiderName;

    @Test
    void contextLoads() {
        System.out.println(proiderName);
    }

}
