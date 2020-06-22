package com.yss.other.雪花算法;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

import javax.annotation.PostConstruct;

/**
 * 雪花算法,借助糊涂工具
 * 优点:
 * 生成纯数字id, 可读性好
 * 数字是按照时间顺序生成的, 所以可以排序
 * 全局唯一, 不重复
 * 不依赖其他服务器, 不会额外增加磁盘io和网络io
 * 缺点:
 * 生成唯一id依赖于当前服务器系统的时钟, 如果当前系统时钟不准
 * 则生成的id无法按照生成的时间顺序排序
 *
 * @author: duhao
 * @date: 2020/6/18 18:00
 */
public class SnowFlakeDemo {
    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowFlake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init() {
        try {
            // 将网络ip转换成long
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取雪花ID
     */
    public synchronized long snowflakeId() {
        return this.snowFlake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        final SnowFlakeDemo snowFlakeDemo = new SnowFlakeDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(snowFlakeDemo.snowflakeId());
            },String.valueOf(i)).start();
        }
    }
}