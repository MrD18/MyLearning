package com.yss.other.缓存;


import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 简单缓存，无超时实现，使用{@link WeakHashMap}实现缓存自动清理
 *
 * @param <K> 键类型
 * @param <V> 值类型
 * @author duhao
 */
public class SimpleCache<K, V> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 缓存池 */
    private final Map<K, V> cache = new WeakHashMap<>();

    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private final ReadLock readLock = cacheLock.readLock();
    private final WriteLock writeLock = cacheLock.writeLock();

    /**
     * 从缓存池中查找值
     *
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        // 尝试读取缓存
        readLock.lock();
        V value;
        try {
            value = cache.get(key);
        } finally {
            readLock.unlock();
        }
        return value;
    }

    /**
     * 从缓存中获得对象，当对象不在缓存中或已经过期返回Func0回调产生的对象
     *
     * @param key      键
     * @param supplier 如果不存在回调方法，用于生产值对象
     * @return 值对象
     */
    public V get(K key, V supplier) {
        V v = get(key);
        if (Objects.isNull(v) && Objects.nonNull(supplier)) {
            writeLock.lock();
            try {
                // 双重检查锁
                v = cache.get(key);
                if (Objects.isNull(v)) {
                    cache.putIfAbsent(key, supplier);
                }
            } finally {
                writeLock.unlock();
            }
        }
        return v;
    }

    /**
     * 放入缓存
     *
     * @param key   键
     * @param value 值
     * @return 值
     */
    public V put(K key, V value) {
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
        return value;
    }

    /**
     * 移除缓存
     *
     * @param key 键
     * @return 移除的值
     */
    public V remove(K key) {
        writeLock.lock();
        try {
            return cache.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 清空缓存池
     */
    public void clear() {
        writeLock.lock();
        try {
            this.cache.clear();
        } finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        SimpleCache simpleCache = new SimpleCache();

        System.out.println("----"+simpleCache.get("start"));

         simpleCache.put("start","000");

        System.out.println(simpleCache.get("start"));

    }
}
