package com.yss.other.数据脱敏;

import jodd.util.StringUtil;

/**
 * @author: duhao
 * @date: 2021/1/27 16:31
 */
public class utils {
    public static String test(String s){
        if(StringUtil.isNotEmpty(s)){
            s = s.replaceAll("(\\w{3})\\w*(\\w{4})", "$1****$2");
        }
        return s;
    }


    public static void main(String[] args) {
        String s = test("610426199109080017");
        System.out.println(s);

    }
}
