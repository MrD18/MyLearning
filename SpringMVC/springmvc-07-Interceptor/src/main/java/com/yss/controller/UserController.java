package com.yss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: duhao
 * @date: 2020/12/29 16:58
 */
@Controller
@RequestMapping("/user")
public class UserController {
    // 跳转到main页面

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    //跳转到登录页面
    @RequestMapping("/gologin")
    public String gologin(){
        return "login";
    }


    // 登录提交
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String pwd, ModelMap modelMap){
       // 向session记录用户信息
        System.out.println("session username is :"+username);
        session.setAttribute("user",username);
        modelMap.addAttribute("user",username);
        return "main";
    }

    //注销登录
    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        session.removeAttribute("user");
        return  "login";
    }

}
