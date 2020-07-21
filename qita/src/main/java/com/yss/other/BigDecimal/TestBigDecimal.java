package com.yss.other.BigDecimal;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**测试BigDecimal的精度
 *
 * @author: duhao
 * @date: 2020/7/20 10:15
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        /**
         * BigDecimal 转换取Double 数据
         */
           Double num= 123456789.98;
        BigDecimal bg1 = new BigDecimal(num);
        BigDecimal bg2 = new BigDecimal(num + "");
        System.out.println(num); //1.2345678998E8
        System.out.println(bg1); //123456789.98000000417232513427734375
        System.out.println(bg2); // 123456789.98
        /**
         * 所以呢，取Double数据的方法是：
         * Double num = 123456789.98;
         *     BigDecimal bg2=new BigDecimal(num + "");
         */


        /**
         * BigDecimal去掉科学计数法
         */
        NumberFormat NF = NumberFormat.getInstance();
        NF.setGroupingUsed(false);//去掉科学计数法显示
        System.out.println("d:="+NF.format(num)); // d:=123456789.98

        /**
         * BigDecimal 的+ - * /
         * +:b1.add(b2).doubleValue()
         * -:b1.subtract(b2).doubleValue()
         * *:b1.multiply(b2).doubleValue()
         * /:b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue()
         */
        // 测试的加法
        BigDecimal b1 = new BigDecimal(Double.toString(num));
        BigDecimal b2 = new BigDecimal(Double.toString(num));
        System.out.println(b1.add(b2).doubleValue());  //2.4691357996E8
        BigDecimal c = new BigDecimal(b1.add(b2).doubleValue()); //246913579.9600000083446502685546875
        System.out.println(c);
      // 测试乘法
           Double ys=6789.98;
        BigDecimal b3 = new BigDecimal(Double.toString(ys));
        BigDecimal b4 = new BigDecimal(Double.toString(ys));
        System.out.println(b3.multiply(b4).doubleValue()); //4.61038284004E7
        BigDecimal cc= new BigDecimal(b3.multiply(b4).doubleValue());
        System.out.println(cc); //46103828.40039999783039093017578125
/**
 * 看来涉及小数的计算，还是需要留意的。
 * 其实笔者总结：取Double的值，转化一下。计算的时候就按照常规的方法来计算，只是取值的时候转一下。
 */


    }
}
