package com.yss.other.redis.controller;

import com.yss.other.redis.entity.Payment;
import com.yss.other.redis.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/13 14:48
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/findAll")
    public List<Payment> findList(){

       return   paymentService.findList();
    }


}
