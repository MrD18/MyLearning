package com.yss.other.yunzhihui;

/**
 * @Author: dhao
 * @Date: 2021/6/8 6:25 下午
 */
public class SensitiveUtils {
    public enum sensitiveType {
        str;
    }

    public static String str(String ss) {
        if (null == ss) {
            return "";
        }
        String s1 = ss.replaceAll("(.)", "*");
        return s1;
    }
}
