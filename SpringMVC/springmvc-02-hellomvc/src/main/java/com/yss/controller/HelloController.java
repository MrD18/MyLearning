package com.yss.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: duhao
 * @date: 2020/12/26 17:09
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("获取到请求地址:"+request.getRequestURI());
        System.out.println("获取到请求方式:"+request.getMethod());


        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();
        // 业务代码
        // TODO 业务代码

        //封装对象，放在ModelAndView中。Model
        mv.addObject("msg","HelloSpringMVC!");
        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        System.out.println(response.getWriter());
        return mv;


    }
}
