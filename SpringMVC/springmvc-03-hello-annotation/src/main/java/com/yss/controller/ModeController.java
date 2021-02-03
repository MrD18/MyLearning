package com.yss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: duhao
 * @date: 2020/12/27 10:20
 */
@Controller
@RequestMapping("/test2")
public class ModeController {
    // 转发:
    @GetMapping("/hello2")
    public  String  sayHello(Model model) {

        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        //  return "forward:/hello.jsp"; //不使用配置文件的话,转发需要将hello.jsp文件放到web目录下
         return "redirect:/index.jsp";//不使用配置文件的话,会重定向到web目录下的index.jsp文件, 会将数据带过去
        // return "redirect:/hello.do"; //hello.do为另一个请求/
    }
}
