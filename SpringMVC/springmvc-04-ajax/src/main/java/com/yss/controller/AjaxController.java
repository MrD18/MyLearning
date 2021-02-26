package com.yss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/12/29 15:32
 */
@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public  String test(){
        return "hello";
    }
}
