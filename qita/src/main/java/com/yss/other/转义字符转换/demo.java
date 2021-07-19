package com.yss.other.转义字符转换;

public class demo {

    public static void main(String[] args) {

        String sql="SELECT \r\n    view_1.id,\r\n    view_1.name,\r\n    view_1.systime,\r\n    view_1.cuurentime \r\nFROM \"stream\".token.aa \r\nAS view_1";
        String replaceSql = sql.replaceAll("\\r\\n", "\\\\r\\\\n").replaceAll("\\\"", "\\\\\"");
       // String s = sql.replaceAll("\\r\\n", "\\\\r\\\\n");
       // String s1 = s.replaceAll("\\\"", "\\\\\"");
        System.out.println(replaceSql);

    }
}
