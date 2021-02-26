package com.yss.other.截取RUL上参数;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: duhao
 * @date: 2021/1/20 13:39
 */
public class Demo {
    public static void main(String[] args) {

        String Url = "http://localhost:8180/guozhi/login.jsp?preappid=guozhi&preownerid=1234";
              System.out.println("参数preappid的值是："+getUrl(Url,"preappid"));
              System.out.println("参数preownerid的值是："+getUrl(Url,"preownerid"));
        String preappid = getUrl(Url, "preappid");


    }

    public static String getUrl(String url, String name) {
        url += "&";
        String pattern = "(\\?|&){1}#{0,1}" + name + "=[a-zA-Z0-9]*(&{1})";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(url);
        if (matcher.find()) {
            //   System.out.println(matcher.group(0));
            return matcher.group(0).split("=")[1].replace("&", "");
        } else {
            return null;
        }
    }
}