package com.yss.other.截取RUL上参数;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: dhao
 * @Date: 2021/7/16 1:57 下午
 */
public class ExcuteSqlUtils {

    public static final String getExcuteSql(String sql){
        Pattern p = Pattern.compile("(?ms)('(?:''|[^'])*')|--.*?$|/\\*.*?\\*/|#.*?$|");
        String presultSql = p.matcher(sql).replaceAll("$1");
        return presultSql;
    }

    public static String replaceBlank(String sql) {
        String dest = "";
        if (sql!=null) {
            Pattern p = Pattern.compile("\r|\n");
            Matcher m = p.matcher(sql);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
