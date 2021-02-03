package com.dhao.webservice.controller;

import com.dhao.webservice.service.UserWebServiceImpl;
import com.dhao.webservice.service.impl.UserWebServiceImplService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2021/1/7 12:45
 */
@RestController
public class UserController {


   @GetMapping("/getUserById/{id}")
    public String getUserById(@PathVariable("id") Integer id){

       UserWebServiceImplService userWebServiceImplService = new UserWebServiceImplService();
       //获取服务实现类
       UserWebServiceImpl port = userWebServiceImplService.getPort(UserWebServiceImpl.class);
       //获取服务的方法
       String result  = port.getUserById(id);

     return result;

   }


}
