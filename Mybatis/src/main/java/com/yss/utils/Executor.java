package com.yss.utils;

import com.yss.domain.Configuration;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**工具类,解析sql
 * @author: duhao
 * @date: 2020/12/10 11:02
 */
public class Executor {
       private Configuration cfg;

    public Executor(Configuration cfg) {
        this.cfg = cfg;
    }
    private Connection conn;
    private Statement stm;
    private ResultSet rs;

 @SneakyThrows
 public List executeQuery(String resultType, String sql){
   // 创建一个返回值集合对象
     List list = new ArrayList();

        // 1. 注册驱动
     Class.forName(cfg.getDriver());
      // 2.获取连接
     String url = cfg.getUrl();
     String username = cfg.getUsername();
     String password = cfg.getPassword();
      conn = DriverManager.getConnection(url, username, password);
     //3.创建statement对象
      stm = conn.createStatement();
     //4.执行sql
      rs = stm.executeQuery(sql);


     //获取结果集的元数据： 修饰数据的数据， 注解也是元数据（修饰代码的代码）
     ResultSetMetaData metaData = rs.getMetaData();
     //获取列的个数
     int columnCount = metaData.getColumnCount();
     //创建列名集合
     List<String> columnNames = new ArrayList<>();
     //通过rs结果集获取所有的列名
// 通过rs结果集获取所有的列名
     for (int i = 1; i <= columnCount; i++) {
         //根据索引获取列名
         String columnName = metaData.getColumnName(i);
         columnNames.add(columnName);
     }
     // 获取返回值类型的字节码文件
     Class<?> clazz = Class.forName(resultType);
     // 获取所有的方法
     Method[] methods = clazz.getMethods();
     //5. 封装结果集
     while (rs.next()){
         //有一条数据就需要创建一个对象： 通过反射创建对象
         Object obj = clazz.newInstance();
         for (String columnName : columnNames) {
             for (Method method : methods) {
                 if (("set"+columnName).equalsIgnoreCase(method.getName())){
                             //根据列名获取数据
                     Object value = rs.getObject(columnName);
                     //反射执行set方法
                     /**
                      * 参数1：对象
                      * 参数2：方法的参数
                      */
                     method.invoke(obj,value );
                 }
             }

         }

         //添加到集合中
         list.add(obj);
     }
   return list;
 }

 public  void  close(){



 }

}
