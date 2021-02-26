package com.yss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: duhao
 * @date: 2020/12/26 20:30
 */
@Controller
@RequestMapping("/test")
public class HelloController {

     @GetMapping("/hello")
    public  String  sayHello(Model model){

        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}
