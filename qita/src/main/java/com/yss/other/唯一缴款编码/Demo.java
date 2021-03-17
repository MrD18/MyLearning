package com.yss.other.唯一缴款编码;

import java.time.LocalDate;
import java.util.Random;

/**
 * @author: duhao
 * @date: 2021/3/12 15:57
 */
public class Demo {
    public static void main(String[] args) {
        String s = handleSubscriptionPaymnetCode();
        System.out.println(s); // 202103126801

    }

    private static String handleSubscriptionPaymnetCode(){
       /**
         * 获取字符串后四位
         */
        Random random = new Random();
       int lastNum = random.nextInt(9000)+1000;
        String nowDateStr = LocalDateUtil.localDateToString(LocalDate.now());
          return nowDateStr+lastNum;
    }
}
