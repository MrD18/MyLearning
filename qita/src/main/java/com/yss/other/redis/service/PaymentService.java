package com.yss.other.redis.service;

import com.yss.other.redis.entity.Payment;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/13 14:51
 */

public interface PaymentService {

    List<Payment> findList();
}
