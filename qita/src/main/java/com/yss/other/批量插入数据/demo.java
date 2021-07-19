package com.yss.other.批量插入数据;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: dhao
 * @Date: 2021/6/1 10:42 上午
 */
public class demo {


    public static void main(String[] args) {
        // write your code here
        String url = "jdbc:mysql://10.0.7.169:3306/dodb_querymodel_20210603";
        String name = "root";
        String pwd = "root";
        String jdbcName = "com.mysql.cj.jdbc.Driver";
        String sql = "insert into biz_data_query_model_history values(?,?,?,?,?,?,?)";
        String strDate = "2021-05-04 00:00:00";

        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strDate);
            java.sql.Date d2 = new java.sql.Date(date.getTime());
            Class.forName(jdbcName);
            Connection con = DriverManager.getConnection(url,name,pwd);
            PreparedStatement pst = con.prepareStatement(sql);
            Timestamp t = new java.sql.Timestamp(System.currentTimeMillis());
            for(int i=2;i<=10000;i++) {
                pst.setInt(1, i);
                pst.setInt(2, 110);
                pst.setString(3, "SELECT * FROM \"stream\".kathy.kathy AS view_1 where id='"+i);
                pst.setInt(4, 2);
                pst.setString(5, strDate);
                pst.setInt(6,2);
                pst.setString(7,strDate);
                pst.executeUpdate();
                System.out.print(i);
                System.out.print("\n");
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }


    }

}
