package com.yss.differentdatasource.servcie;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.yss.differentdatasource.dto.Payment;
import com.yss.differentdatasource.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 通过一个注解来实现数据源切换
 * @author: duhao
 * @date: 2021/4/27 10:15
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public List<Payment> getPaymentList(){
        return paymentMapper.getgetPaymentList();
    }

  @Override
  @DS("slave")
    public List<Payment> getPaymentListDB2() {
      return paymentMapper.getgetPaymentListDB2();
  }
}
