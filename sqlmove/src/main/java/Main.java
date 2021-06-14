import com.alibaba.druid.pool.DruidDataSourceFactory;
import utils.SqlUtil;
import utils.ThreadUtil;
import utils.TxtUtil;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

/**
 * @AUTHOR HG-captain
 * @Data 2021/6/13
 * @Description
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Queue resultList = TxtUtil.readTxt("D:/sql.txt");

        ThreadUtil.fileWrite(resultList);

    }




}
