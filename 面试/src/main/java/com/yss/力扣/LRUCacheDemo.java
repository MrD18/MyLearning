package com.yss.力扣;

import java.util.LinkedHashMap;
import java.util.Map;

/**实现LRU算法(最近最少使用)
 * @author: duhao
 * @date: 2020/12/20 15:36
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {

    private int capacity;// 缓存坑位

    /** accessOrder     the ordering mode -
     * <tt>true</tt> for access-order,  true 访问顺序
     * <tt>false</tt> for insertion-order  false 插入顺序
     *
     * @param capacity
     */
    public LRUCacheDemo(int capacity) {
        super(capacity,0.75F,false);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }


    public static void main(String[] args) {
        LRUCacheDemo<Object, Object> cacheDemo = new LRUCacheDemo<>(3);
        cacheDemo.put(1,"a");
        cacheDemo.put(2,"b");
        cacheDemo.put(3,"c");
        System.out.println(cacheDemo.keySet());
        cacheDemo.put(4,"d");
        System.out.println(cacheDemo.keySet());
        cacheDemo.put(3,"c");
        System.out.println(cacheDemo.keySet());
        cacheDemo.put(3,"c");
        System.out.println(cacheDemo.keySet());
        cacheDemo.put(3,"c");
        System.out.println(cacheDemo.keySet());
        cacheDemo.put(5,"c");
        System.out.println(cacheDemo.keySet());
    }
}
/**true  访问顺序
 * [1, 2, 3]  3个坑位 1,2,3
 * [2, 3, 4]  4进来 1出去
 *
 * [2, 4, 3] 3目前是最经常使用的
 * [2, 4, 3]
 * [2, 4, 3]
 *
 * [4, 3, 5] 5进来将2寄出去
 *
 */
/**false  插入顺序
 * [1, 2, 3]
 * [2, 3, 4]
 *
 * [2, 3, 4] 顺序不变?
 * [2, 3, 4]
 * [2, 3, 4]
 *
 * [3, 4, 5]
 */