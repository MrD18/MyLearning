package com.yss.other.redis.service.Impl;

import com.yss.other.redis.dao.PaymentDao;
import com.yss.other.redis.entity.Payment;
import com.yss.other.redis.service.PaymentService;
import lombok.extern.log4j.Log4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/13 14:52
 */
@Service
@Log4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    @Cacheable(key = "#root.method.name", value = "test")
    public List<Payment> findList() {

        return paymentDao.findAll();
    }
}
