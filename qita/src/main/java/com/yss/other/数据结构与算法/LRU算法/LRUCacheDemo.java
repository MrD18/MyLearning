package com.yss.other.数据结构与算法.LRU算法;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: duhao
 * @date: 2021/4/6 16:23
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {
      private int capacity;// 缓存坑位

    public LRUCacheDemo(int capacity){
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

//当put进新的值方法返回true时，便移除该map中最老的键和值。
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }


    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1,"a");
        lruCacheDemo.put(2,"b");
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"x");
        System.out.println(lruCacheDemo.keySet());



    }
}
