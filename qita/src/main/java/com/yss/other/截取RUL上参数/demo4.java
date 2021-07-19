package com.yss.other.截取RUL上参数;

import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/** 截取分号前面的内容
 * @Author: dhao
 * @Date: 2021/7/13 3:22 下午
 */
public class demo4 {
    public static void main(String[] args) {
        String sql="-- 测试;;; \r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\r\nSELECT \r\n    view_1.age,\r\n    view_1.name,\r\n    view_1.number,\r\n    view_1.status \r\nFROM \"stream\".jessica180.jessica7121 \r\nAS view_1;\n";
        String excuteSql = ExcuteSqlUtils.getExcuteSql(sql);

        String[] splitSql = excuteSql.split(";");
        String s = splitSql[0];
        ArrayList<String> sqlList = new ArrayList<>();
        sqlList.add("");
        for (String s1 : splitSql) {
            String s2 = ExcuteSqlUtils.replaceBlank(s1);
            sqlList.add(s2);
        }
        System.out.println("sqlList.size:-->"+sqlList.size());
        System.out.println("sqlList:-->"+sqlList );
        System.out.println("----------------------------------");
        for (String s1 : sqlList) {
            System.out.println(s1);
        }
        // 去除空串
        List<String> newList = sqlList.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
        System.out.println(newList.size());
        System.out.println("newList-->"+newList);

        String  str="\n\n\n";
        str =str.substring(0,str.length()-1);
     //   System.out.println(str);


      /*  String s1 = demo4.replaceBlank(sql);
        System.out.println("s1:"+s1);
        if ("".equals(s1)){
            System.out.println("...");
        }
        else {
            System.out.println("----");
        }*/
    }

}
