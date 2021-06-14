package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @AUTHOR HG-captain
 * @Data 2021/6/14
 * @Description
 */
public class ThreadUtil {

    public static void fileWrite(Queue<String> queue) throws Exception {
        final int count = 10;
        ExecutorService executor = Executors.newFixedThreadPool(30);//线程池定义
        CountDownLatch latch = new CountDownLatch(count);//计数器10个，倒数到0以后停止
        Properties properties=new Properties();
        File file = new File("");
        String filePath = file.getCanonicalPath();
        properties.load(new FileInputStream(filePath+"/sqlmove/src/main/resources/application.properties"));
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        Connection conn=dataSource.getConnection();
        PreparedStatement prep =null;
        ResultSet rs =null ;
        for(int i=0;i<count;i++){
           executor.submit(()->{
                //在这里执行业务代码
               SqlUtil.queryById(queue.poll(),conn,prep,rs);
                latch.countDown();//计数器减一，相当于一个线程正在工作？
            });
        }
        SqlUtil.release(rs,prep,conn);

    }

}
