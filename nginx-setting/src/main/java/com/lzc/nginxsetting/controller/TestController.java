package com.lzc.nginxsetting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR HG-captain
 * @Data 2020/9/3
 * @Description
 */
@RestController
public class TestController {

    @RequestMapping("/test01")
    public String test01(){
        return "mmp";
    }

    @RequestMapping("/test02")
    public String test02(){
        System.out.println("test02");
        return "cnn";
    }

}
