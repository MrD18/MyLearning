package com.yss.service;

import javax.jws.WebService;

/** 对外发布服务接口
 * @author: duhao
 * @date: 2020/6/22 9:24
 */
@WebService
public interface HelloService {
    /**
     * 对外发布服务接口的方法
     */
    public  String sayHello(String name);
}
