package com.yss.other.截取RUL上参数;

/**
 * @author: duhao
 * @date: 2021/3/16 14:19
 */
public class Demo2 {
    public static void main(String[] args) {
        String Url = "http://10.18.125.4:18080/servlet/com.zotn.llTouz.screens.LlTouzServlet?values=OTk3NzExNQ&userNum=cd9746ee3ccd8acb557bee52e61d6d55";
    /*    String substring = Url.substring(Url.lastIndexOf(":") + 1);
        String substring1 = substring.substring(substring.indexOf("/"));
        System.out.println(substring1);*/
    // 获取第一个"/"的位置
        int index = Url.indexOf("/");
        String substring2 = Url.substring(Url.indexOf("/", index + 3));


    }


}
