package com.yss.other.Hutool;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/** Convert
 * 类型转换工具类, 用于各种类型数据转换
 *
 * @author: duhao
 * @date: 2020/7/13 16:05
 */
public class TestConvert {
    public static void main(String[] args) {
        // 转换为字符串
        int a=1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);
        // 转换为指定类型数组
        String[] b={"1","2","3","4"};
        Integer[] bArr  = Convert.toIntArray(b);
        // 转换为日期对象
        String dateStr= "2017-05-06";
        Date date = Convert.toDate(dateStr);
          // 转换为列表
        String[] strArr= {"a","b","c","d"};
        List<String> stringList = Convert.toList(String.class, strArr);


    }

}
