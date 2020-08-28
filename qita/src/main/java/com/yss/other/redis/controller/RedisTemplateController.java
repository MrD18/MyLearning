package com.yss.other.redis.controller;

import com.yss.other.redis.entity.Payment;
import com.yss.other.redis.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: duhao
 * @date: 2020/8/21 10:32
 */
@RestController
@Slf4j
public class RedisTemplateController {
    //  @ApiOperation(value = "根据key(id)查询")
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private PaymentService paymentService;

    private static  final String CACHE_PAYMENT="payment";

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Object getById(@PathVariable("key") String key) {
        log.info("根据key {} 进行查询", key);
        return  redisTemplate.opsForValue().get(key);
    }

  //  @ApiOperation("用id做key，保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Payment payment){

        List<Payment> paymentList = paymentService.findList();

        log.info("调用保存接口");
        //不存在就保存 存在就更新
        redisTemplate.opsForValue().set(CACHE_PAYMENT, paymentList);
        log.info("保存成功");
    }

  //  @ApiOperation("删除")
  //  @ApiImplicitParam(name = "key", value = "用户id")
    @RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("key") String key){
        log.info("调用删除接口");
        // 不存在就返回false
        return  redisTemplate.delete(key);
    }

  //  @ApiOperation("更新")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object update(@ModelAttribute Payment payment){
        //得到旧值   不存在就保存 存在就更新
        Object andSet = redisTemplate.opsForValue().getAndSet(CACHE_PAYMENT, payment);
        return andSet;
    }

    /**最初分布式锁借助于setnx和expire命令，但是这两个命令不是原子操作，如果执行 setnx之后获取锁但是此时客户端挂掉，
     *这样无法执行expire设置过期时间就导致锁 一直无法被释放，因此在2.8版本中Antirez为setnx增加了参数扩展，
     *使得setnx和expire具备原子操作性。
     方法Boolean setIfAbsent(K key, V value, long timeout, TimeUnit unit);
     是在Spring Data Redis2.1版本中新增的；
     加锁和续期：加锁使用测试2；续期使用测试3
     *
     * @param payment
     * @return
     */

    //@ApiOperation("测试1")
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public boolean test3(@ModelAttribute Payment payment){
        // 设置过期时间 10秒/ 不存在返回false
        return redisTemplate.expire(CACHE_PAYMENT, 10, TimeUnit.SECONDS);
    }

   // @ApiOperation("测试2，不存在key就新建并设置过期时间")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Boolean test(@ModelAttribute Payment payment){
        //test:张三  文件夹
        return redisTemplate.opsForValue().setIfAbsent(CACHE_PAYMENT, payment, 10, TimeUnit.SECONDS);
    }

   // @ApiOperation("测试3,存在就更新并设置过期时间,存在返回true，不存在返回false")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public Boolean test2(@ModelAttribute Payment payment){
        return redisTemplate.opsForValue().setIfPresent("a", payment, 10, TimeUnit.SECONDS);
    }


}
