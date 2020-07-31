package com.yss.other.Hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**DateUtil
 * 日期时间工具类，定义了一些常用的日期时间操作方法。
 *
 * @author: duhao
 * @date: 2020/7/13 16:24
 */
public class TestDateUtil {
    public static void main(String[] args) {
        //Date、long、Calendar之间的相互转换
       //当前时间
        Date date = DateUtil.date();
        System.out.println(date); // 2020-07-13 16:25:19
        //Calendar转Date
        date = DateUtil.date(Calendar.getInstance());
        System.out.println(date);// 2020-07-13 16:27:00
        //时间戳转Date
       date= DateUtil.date(System.currentTimeMillis());
        System.out.println(date);//  2020-07-13 16:27:00
        // 自动识别格式转换
        String dateStr = "2017-03-01";
         date = DateUtil.parse(dateStr);
        System.out.println(date); //2017-03-01 00:00:00
        // 自定义格式换换
        Date parse = DateUtil.parse(dateStr, "yyyy-MM-dd");
        System.out.println(parse); //2017-03-01 00:00:00
        // 格式化输出日期
        String format = DateUtil.format(date, "yyyy-MM-dd");
        System.out.println(format);// 2017-03-01
           // 获取年的部分
        int year = DateUtil.year(date);
        System.out.println(year); // 2017
        //获取月份,从0开始计数
        int month = DateUtil.month(date);
        System.out.println(month);// 2
        //获取某天的开始、结束时间
        Date beginOfDay = DateUtil.beginOfDay(date);
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println(beginOfDay+"---"+endOfDay);//2017-03-01 00:00:00---2017-03-01 23:59:59
        //计算偏移后的日期时间
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println(newDate); //2017-03-03 00:00:00
        //计算日期时间之间的偏移量
        long betweenDay = DateUtil.between(date, newDate, DateUnit.DAY);
        System.out.println(betweenDay);// 2    date当时的时间  与    newDate   现在的时间的差距
    }
}
