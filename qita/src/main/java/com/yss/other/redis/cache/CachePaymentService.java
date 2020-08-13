//package com.yss.other.redis.cache;
//
//import com.yss.other.redis.entity.Payment;
//import com.yss.other.redis.service.PaymentService;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author: duhao
// * @date: 2020/8/13 16:00
// */
//
//@Service
//@AllArgsConstructor
//@Log4j
//public class CachePaymentService {
//
//    private static final String CACHE_PREFIX = "other-service-qita:";
//    private static final String CACHE_PRODUCTS = "payment";
//    private PaymentService paymentService;
//
//
//
//    /**
//     * 获取全部信息
//     */
//    @Cacheable(key = "#root.method.name", value = CACHE_PREFIX + CACHE_PRODUCTS)
//    public List<Payment> cachePaymentSave(){
//    log.info("##### Cache not obtained, Init Payment Cache #####");
//        return  paymentService.findList();
//    }
//}
