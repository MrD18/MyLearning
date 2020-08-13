package com.yss.other.redis.dao;

import com.yss.other.redis.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/13 14:53
 */
@Mapper
public interface PaymentDao  {
    List<Payment> findAll();
}
