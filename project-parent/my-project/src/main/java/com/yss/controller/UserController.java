package com.yss.controller;

import com.yss.entity.User;
import com.yss.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/6 17:12
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserSerice userSerice;

    @GetMapping("/lsitAll")
    public List<User> listAll(){
        return userSerice.listAll();
    }
}
