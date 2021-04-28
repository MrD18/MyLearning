package com.yss.differentdatasource.controller;

import com.yss.differentdatasource.dto.Payment;
import com.yss.differentdatasource.servcie.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 10:45
 */
@RestController
public class PaymentController {
    @Autowired
  private PaymentService paymentService;

     @GetMapping("/getPaymentList")
    public List<Payment> getPaymentList(){
        List<Payment> paymentList = paymentService.getPaymentList();
    //     List<Payment> paymentListDB2 = paymentService.getPaymentListDB2();

         return paymentList;
    }
}
