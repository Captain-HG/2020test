package com.lzc.apputils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AUTHOR HG-captain
 * @Data 2020/11/23
 * @Description  图片工具类
 */
@Controller
@RequestMapping("/img")
public class ImgController {


    @RequestMapping("/qrcode")
    public String getQrcode(){
        return "imgQrocde";
    }

}
