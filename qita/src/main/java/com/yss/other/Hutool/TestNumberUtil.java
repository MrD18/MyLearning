package com.yss.other.Hutool;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

/**数字处理工具类，可用于各种类型数字的加减乘除操作及判断类型
 * @author: duhao
 * @date: 2020/7/13 17:26
 */
public class TestNumberUtil {
    public static void main(String[] args) {
        double n1 = 1.234;
        double n2 = 1.234;
      //  double result;
        //对float、double、BigDecimal做加减乘除操作
        double    result1 = NumberUtil.add(n1, n2);
        double   result2 = NumberUtil.sub(n1, n2);
        double result3 = NumberUtil.mul(n1, n2);
        double    result4 = NumberUtil.div(n1, n2);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        //保留两位小数
        BigDecimal roundNum = NumberUtil.round(n1, 2);
        System.out.println(roundNum);//1.23
        String n3 = "1.234";
        //判断是否为数字、整数、浮点数
        System.out.println( NumberUtil.isNumber(n3));//true
        System.out.println(NumberUtil.isInteger(n3));//false
        System.out.println(NumberUtil.isDouble(n3));//true

    }
}
