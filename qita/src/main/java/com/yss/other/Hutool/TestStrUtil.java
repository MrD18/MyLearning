package com.yss.other.Hutool;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**字符串工具类，定义了一些常用的字符串操作方法。
 *
 * @author: duhao
 * @date: 2020/7/13 16:41
 */
public class TestStrUtil {
    private final static Logger logger = LoggerFactory.getLogger(TestStrUtil.class);
    public static void main(String[] args) {
        //判断是否为空字符串
        String str= "test";
        boolean empty = StrUtil.isEmpty(str);
        System.out.println(empty);//false --判断是否是空
        boolean notEmpty = StrUtil.isNotEmpty(str);
        System.out.println(notEmpty);//true  --判断是否不为空
        //去除字符串的前后缀
        String s = StrUtil.removeSuffix("a.jpg", ".jpg");
        System.out.println(s); // a
        String s1 = StrUtil.removePrefix("a.jpg", "a.");
        System.out.println(s1);// jpg
        //格式化字符串
        String template = "这只是个占位符:{}";
        String s2 = StrUtil.format(template, "我是占位符");
        System.out.println(s2);//这只是个占位符:我是占位符
        logger.info("/strUtil format:{}", s2); // /strUtil format:这只是个占位符:我是占位符



    }
}
