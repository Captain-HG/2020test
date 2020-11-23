package com.lzc.provider;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@NacosConfigurationProperties(dataId = "PROVIDER:2020-07-28", autoRefreshed = true)
@NacosPropertySource(dataId = "PROVIDER:2020-07-30", autoRefreshed = true)
public class ProviderApplication {



    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
