package com.yss.differentdatasource.servcie;

import com.yss.differentdatasource.dto.Payment;

import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 10:47
 */
public interface PaymentService {

    public List<Payment> getPaymentList();
    public List<Payment> getPaymentListDB2();
}
