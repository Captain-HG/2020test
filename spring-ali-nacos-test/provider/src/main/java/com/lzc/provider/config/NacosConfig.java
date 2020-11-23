package com.lzc.provider.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR HG-captain
 * @Data 2020/7/28
 * @Description
 */
@RestController
public class NacosConfig {
    @NacosValue(value = "${provider-name:123}", autoRefreshed = true)
    private String proiderName;

        @RequestMapping("/test01")
    public String test(){
        return proiderName;
    }
}
