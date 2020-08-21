package com.yss.rocketmq.controller;

import com.yss.rocketmq.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/8/14 15:51
 */
@RestController
@Slf4j
public class RocketmqController {
    @Autowired
    private ProductService producer;

    @RequestMapping("/myFirstProducer")
    public String pushMsg(String msg) {
        try {
            return producer.send("firstPushTopic", "push", msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}