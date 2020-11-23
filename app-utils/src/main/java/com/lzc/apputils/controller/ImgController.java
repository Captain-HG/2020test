package com.lzc.apputils.controller;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.lzc.apputils.dict.Dict;
import com.lzc.apputils.utils.QRCodeGenerator;
import com.lzc.apputils.utils.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @AUTHOR HG-captain
 * @Data 2020/11/23
 * @Description  图片工具类
 */
@Controller
@RequestMapping("/img")
public class ImgController {

    private static Logger log = LoggerFactory.getLogger(ImgController.class);

    @RequestMapping("/qrcode")
    @ResponseBody
    public void  getQrcode(@RequestBody Map params, HttpServletRequest request, HttpServletResponse response){
        String url  = (String) params.get(Dict.URL);
        try {
        String sortUrl = UrlUtil.generateShortUrl(url);
        BitMatrix bitMatrix = QRCodeGenerator.generateQRCodeStream(sortUrl, response);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", response.getOutputStream());
        } catch (IOException e) {
            log.error("getQrcode is error this url is:"+url+"，and this error：",e);
            e.printStackTrace();
        }
}

}
