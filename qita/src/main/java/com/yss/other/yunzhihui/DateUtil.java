package com.yss.other.yunzhihui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: dhao
 * @Date: 2021/5/27 7:24 下午
 */
public class DateUtil {
    private static DateTimeFormatter sf = null;

    // 将时间戳转成字符串
    public static String getDateToString(long longtime) {
        String time="";
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(longtime/1000, 0, ZoneOffset.ofHours(8));
        time = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return time;
    }




   /* //获取当前时间
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(d);
    }*/



    /**
     *将字符串转换为时间戳
     */
    public static Long getDateToStamp(String s) {
        long time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(s,formatter);
        time=localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        return time;
    }

    public static void main(String[] args) {

        String dateToString = DateUtil.getDateToString(1623209001288L);
        System.out.println(dateToString);
        Long dateToStamp = DateUtil.getDateToStamp("2021-06-09 11:23:21");
        System.out.println(dateToStamp);
    }
    //直接获取当前时间戳
/*    public static Long getTimeStamp() {
        String currentDate = getCurrentDate();
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sf.parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Long.valueOf(date.getTime());
    }*/

}
