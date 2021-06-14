package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @AUTHOR HG-captain
 * @Data 2021/6/13
 * @Description
 */
public class TxtUtil {


    /**
     * 读取txt文件
     * @param filePath
     * @return
     */
    public static Queue readTxt(String filePath){

        File file = new File(filePath);
//        List  resultList = new ArrayList();
        Queue<String> queue = new LinkedList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                queue.add(s.substring(0,s.indexOf(",")).trim());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return queue;
    }
}
