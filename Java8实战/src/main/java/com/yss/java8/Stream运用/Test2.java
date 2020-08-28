package com.yss.java8.Stream运用;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream运用
 *
 * @author: duhao
 * @date: 2020/8/24 15:50
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("tom");
        list.add("jerry");
        list.add("shuke");
        list.add("beita");
        list.add("damu");

        //1. 筛选长度>5的数据, 增强for循环,底层使用的还是迭代器
        List<String> list1 = new ArrayList<String>();
        for (String s : list) {
            if (s.length() > 3) {
                list1.add(s);
            }
        }
        System.out.println(list1);
        // 2. 使用迭代器 底层实现
        List<String> list2 = new ArrayList<String>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() > 3) {
                list2.add(s);
            }
        }
        System.out.println(list2);
        // 3. 使用lambda表达式转换->过滤->收集(转换成list)
        List<String> list3 = list.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
        System.out.println(list3);



    }
}
