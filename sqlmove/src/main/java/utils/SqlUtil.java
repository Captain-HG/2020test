package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @AUTHOR HG-captain
 * @Data 2021/6/14
 * @Description
 */
public class SqlUtil {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    static {
        Properties properties=new Properties();
        try {
            File file = new File("");
            String filePath = file.getCanonicalPath();
            properties.load(new FileInputStream(filePath+"/sqlmove/src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClassName=properties.getProperty("driverClassName");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }
    public static void loadDriver(){
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn=null;
        loadDriver();
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void release(PreparedStatement prep, Connection conn) throws SQLException {
        prep.close();
        conn.close();
    }

    public static void release(ResultSet rs, PreparedStatement prep, Connection conn) throws SQLException {
        rs.close();
        prep.close();
        conn.close();
    }

    public static void release(Statement statement,Connection conn) throws SQLException {
        statement.close();
        conn.close();
    }




    public static void queryById(String phone,Connection conn ,PreparedStatement prep ,   ResultSet rs)  {
        //从druid.properties中读取数据
//        Properties properties=new Properties();
//        File file = new File("");
//        String filePath = file.getCanonicalPath();
//        properties.load(new FileInputStream(filePath+"/src/main/resources/application.properties"));
//        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
//        conn=dataSource.getConnection();
//        prep=conn.prepareStatement("select * from phone");

        try {
            prep = conn.prepareStatement("select * from phone where phone ="+phone);
            rs = prep.executeQuery();
            if(rs!=null) {
                while (rs.next()) {
//                    System.out.println(rs.getString("phone"));
//                    System.out.println(rs.getString("name"));
//                    System.out.println(rs.getString("age"));
                  logger.info(rs.getString("phone"));
                }
            }
//            SqlUtil.release(rs,prep,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
