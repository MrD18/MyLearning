package com.yss.other.redis.test;


import redis.clients.jedis.Jedis;

/**redis 测试
 * @author: duhao
 * @date: 2020/7/9 9:08
 */

public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.232.111",6379);
        // 测试连接成功
        System.out.println(jedis.ping());


    }
}