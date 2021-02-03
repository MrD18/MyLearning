package com.yss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/12/29 16:19
 */
@RestController
public class InterceptorController {

    @GetMapping("/test/interceptor")
    public String testInterceptor(){
        System.out.println("控制器中的方法");
        return "hello";
    }
}
