package com.yss.study.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author: duhao
 * @date: 2020/12/18 14:59
 */
@Configuration
public class RedisConfig {
   @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
         // 设置k-v 的形式, 目的是让存入的是什么格式,拿出来还是什么格式
         redisTemplate.setKeySerializer(new StringRedisSerializer());
         redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
         redisTemplate.setConnectionFactory(connectionFactory);
  return  redisTemplate;
    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+"127.0.0.1"+":6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }


}
