package com.yss.differentdatasource.mapper;

import com.yss.differentdatasource.dto.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 10:23
 */
@Mapper
public interface PaymentMapper {

    List<Payment> getgetPaymentList();

    List<Payment> getgetPaymentListDB2();
}
