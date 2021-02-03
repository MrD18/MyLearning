package com.yss.study.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: duhao
 * @date: 2020/12/18 15:00
 */
@RestController
public class GoodController {
 // 定义锁的名字
     public static final String REDIS_LOCK="redisLock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buy_Goods() throws Exception {
         // 线程名称
        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();

        RLock redissonLock = redisson.getLock(REDIS_LOCK);
        try {
            /*使用Redisson*/
             redissonLock.lock();
            /**************************************************/
            /*具有原子性的操作*/
            /*Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);
            if (!flag){
                return "抢锁失败";
            }*/

        /************************************************/
            /*setNX +key过期时间,但是是分开的,不具有原子性*/
            /*Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value);//setNX命令
            stringRedisTemplate.expire(REDIS_LOCK,10L, TimeUnit.SECONDS);// 设置过期时间,保证程序死了之后,也能删除key*/


            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);

            if (goodsNumber > 0){
                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001",realNumber + "");
                System.out.println("你已经成功秒杀商品，此时还剩余：" + realNumber + "件"+"\t 服务器端口: "+serverPort);
                return "你已经成功秒杀商品，此时还剩余：" + realNumber + "件"+"\t 服务器端口: "+serverPort;
            }else {
                System.out.println("商品已经售罄/活动结束/调用超时，欢迎下次光临"+"\t 服务器端口: "+serverPort);
            }
            return "商品已经售罄/活动结束/调用超时，欢迎下次光临"+"\t 服务器端口: "+serverPort;
        } finally {
        /*使用redisson*/
            /*isLocked()如果还是在锁定状态*, isHeldByCurrentThread() 那个线程持有 */
            if (redissonLock.isLocked()&&redissonLock.isHeldByCurrentThread()){
                redissonLock.unlock();
            }

            // 方法1:具有原子性的删除命令 使用Lua脚本
        /*    Jedis jedis = RedisUtils.getJedis();

            String script = "if redis.call('get', KEYS[1]) == ARGV[1]"+
                    "then "+
                    "return redis.call('del', KEYS[1])"+
                    "else "+
                    "  return 0 " +
                    "end";
            try{
                Object result = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if ("1".equals(result.toString())){
                    System.out.println("------del REDIS_LOCK_KEY success");
                }else {
                    System.out.println("------del REDIS_LOCK_KEY error");
                }
             }finally {
                if (null != jedis){
                    jedis.close();
                }
            }*/



            // 方法2: 使用redis事务
        /*    while (true){
                stringRedisTemplate.watch(REDIS_LOCK);//哨兵先监视
                if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)){
                      stringRedisTemplate.setEnableTransactionSupport(true);
                      stringRedisTemplate.multi();
                      stringRedisTemplate.delete(REDIS_LOCK);
                    List<Object> list = stringRedisTemplate.exec();
                     if (list==null){
                         continue;
                     }
                }
                stringRedisTemplate.unwatch();
                break;
            }*/

        /*******************************************************************************************/

           /*    *//*如果出现业务的执行时间>锁到期时间,会出现线程A 误删的情况
               * 但是这2个命令不具有原子性
               * *//*
            if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)){
                stringRedisTemplate.delete(REDIS_LOCK);// 程序正常执行,或者异常都要释放锁
            }*/
        }
    }

}

