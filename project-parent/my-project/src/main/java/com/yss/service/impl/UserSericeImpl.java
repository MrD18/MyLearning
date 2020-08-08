package com.yss.service.impl;

import com.yss.dao.UserMapper;
import com.yss.entity.User;
import com.yss.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/6 17:20
 */
@Service
public class UserSericeImpl implements UserSerice {

   @Autowired
   private UserMapper userMapper;
    @Override
    public List<User> listAll() {
        return  userMapper.listAll();

    }
}
