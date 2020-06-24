package com.yss.jingdongpython.db;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 * @author: duhao
 * @date: 2020/6/17 16:49
 */
public class MyDataSource {
    public static DataSource getDataSource(String connectURI){
        BasicDataSource ds = new BasicDataSource();
        //MySQL的jdbc驱动
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");              //所要连接的数据库名
        ds.setPassword("root");                //MySQL的登陆密码
        ds.setUrl(connectURI);
        return ds;
    }
}
