package com.yss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**SessionAttributes注解可以把登录信息存储在session域中
 * @author: duhao
 * @date: 2020/12/28 9:31
 */
@Controller
@SessionAttributes(names = {"username","role"})
public class SessionAttributesController {

    // 存储信息到session
    @GetMapping("testPut")
    public  void testPut(ModelMap modelMap){
       modelMap.addAttribute("username","zhangsan");
       modelMap.addAttribute("role","管理员");
    }
    // 从session中获取到信息
    @GetMapping("testGet")
  public void testGet(ModelMap modelMap){
        System.out.println( modelMap.get("username"));
        System.out.println( modelMap.get("role"));

  }
    //清除session信息
    @GetMapping("/testClear")
    public void testClear(SessionStatus sessionStatus){
       sessionStatus.setComplete();
    }

}
