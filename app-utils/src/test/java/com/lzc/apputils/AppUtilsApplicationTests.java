package com.lzc.apputils;

import com.lzc.apputils.utils.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class AppUtilsApplicationTests {

    @Test
    void contextLoads() {
        File inputFile = new File("D:/xls/密码记录.xlsx");
        File outputFile = new File("D:/xls/密码记录.csv");
        ExcelUtil.XlsxtoCSV(inputFile, outputFile);
    }

}
