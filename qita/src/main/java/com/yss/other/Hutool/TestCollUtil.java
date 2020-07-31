package com.yss.other.Hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**CollUtil
 * 集合操作的工具类，定义了一些常用的集合操作。
 * @author: duhao
 * @date: 2020/7/13 17:41
 */
public class TestCollUtil {
    public static void main(String[] args) {
        //数组转换为列表
       String[] arrays = {"a", "b", "c", "d", "e"};
        ArrayList<String> list = CollUtil.newArrayList(arrays);
        System.out.println(list);
        //join：数组转字符串时添加连接符号
        String joinStr = CollUtil.join(list, "-");
        System.out.println(joinStr);//a-b-c-d-e

        //将以连接符号分隔的字符串再转换为列表
        List<String> split = StrUtil.split(joinStr, '-'); // 注意是单引号
        System.out.println(split); //[a, b, c, d, e]
        //创建新的Map、Set、List
        HashMap<Object, Object> newMap = CollUtil.newHashMap();
        HashSet<Object> newHashSet = CollUtil.newHashSet();
        ArrayList<Object> newList = CollUtil.newArrayList();
         //判断列表是否为空
        boolean empty = CollUtil.isEmpty(list);
        System.out.println(empty); // false
    }
}
