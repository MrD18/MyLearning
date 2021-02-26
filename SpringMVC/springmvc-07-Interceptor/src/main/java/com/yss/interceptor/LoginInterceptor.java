package com.yss.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: duhao
 * @date: 2020/12/29 19:17
 */
public class LoginInterceptor implements HandlerInterceptor {
    // 拦截所有请求,判断是否登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //1. session中有就是登录的状态
     if (session.getAttribute("user")!=null){
            return true;
     }
        //2.如果在登录页面就放行
        System.out.println("uri:"+request.getRequestURI());
      if (request.getRequestURI().contains("login")){
          return true;
      }
        //3. 没有登录就跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
