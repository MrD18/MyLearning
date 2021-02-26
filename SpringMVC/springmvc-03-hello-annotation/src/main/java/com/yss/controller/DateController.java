package com.yss.controller;

import com.yss.entity.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/12/27 11:14
 */

@RestController
public class DateController {

    @PostMapping("/date/test")
    public  String dateTest( @RequestBody UserVO userVO){
        System.out.println("接受到前端传过来的数据username:"+userVO.getUsername());
        System.out.println("接受到前端传过来的数据password:"+userVO.getPassword());
    return "接受数据成功:username:"+userVO;
    }

    @PostMapping("/date/test2")
    public  String dateTest2( @RequestParam(value = "username",required = true,defaultValue = "张三") UserVO userVO){
        System.out.println("接受到前端传过来的数据username:"+userVO.getUsername());
        System.out.println("接受到前端传过来的数据password:"+userVO.getPassword());
        return "接受数据成功:username:"+userVO;
    }

}
