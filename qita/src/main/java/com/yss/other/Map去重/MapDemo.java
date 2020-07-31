package com.yss.other.Map去重;

import java.util.*;

/**
 * 利用hashMap去重
 * 1. 利用hashmap中的键不重复进行去重
 *
 * @author: duhao
 * @date: 2020/7/21 10:29
 */
public class MapDemo {
    public static void main(String[] args) {
      //  ArrayListDemo();

        //1. map中有相同的value
        Map<String, String> map = new HashMap<>();
        map.put("1", "123");
        map.put("2", "djw");
        map.put("3", "djw");
        map.put("4", "123");
        map.put("5", "djw");

      // 1. 利用set去重
         Set<String> set = new HashSet<>();
        for ( Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator(); iterator.hasNext();){
             Map.Entry<String, String> entry = iterator.next();
             if (set.contains(entry.getValue())){
                 iterator.remove();
                 continue;
             }else {
                 set.add(entry.getValue());
             }
         }
       map.forEach((key,value)->{
           System.out.println("key:"+key+", value:"+value);
       });
        // deleteDuplicate1(map);

    }

    private static void deleteDuplicate1(Map<String, String> map) {
        // 方法1 通过containsValue 去重后定义新map
        Map<String, String> map2 = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
           // String key = entry.getKey();
           // String value = entry.getValue();
            if (map2.containsValue(entry.getValue())){
                continue;
            }else {
                map2.put(entry.getKey(),entry.getValue());
            }

        }
        map2.forEach((key,value)->{
            System.out.println("key:"+key+", value:"+value);
        });
    }

    private static void ArrayListDemo() {
        //1. 取出的list中有重复的元素
        List<String> list = new ArrayList<>();
        list.add("牛魔王");
        list.add("牛魔王");
        list.add("孙悟空");
        list.add("铁扇公主");
        list.forEach(System.out::println);
//  2.利用map的key不重复的特性,对list去重
        Map<String, String> map = new HashMap<>();
        for (String s : list) {
            map.put(s, "");
        }
        //3.将map中的key取出到list,即完成了list的去重
        list.clear();// 先清空

        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        list.forEach(System.out::println);
    }
}
