package com.yss.other.截取RUL上参数;

/**
 * @Author: dhao
 * @Date: 2021/6/30 9:32 上午
 */
public class Demo3 {
    public static void main(String[] args) {
        String str="/dataquerymodels/query" ;

        if ("/dataquerymodels/longquery".equals(str)){

        }
        boolean longquery = str.contains("long");

        if (longquery){
            System.out.println("包含："+longquery);
        } else {
            System.out.println("不包含"+longquery);
        }


    }
}
