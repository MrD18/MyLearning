package com.yss.service.Impl;

import com.yss.service.HelloService;

/**
 * @author: duhao
 * @date: 2020/6/22 9:26
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name+",这是对外发布服务的接口";
    }
}
