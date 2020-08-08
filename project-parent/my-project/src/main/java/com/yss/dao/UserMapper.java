package com.yss.dao;

import com.yss.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/6 17:21
 */
@Mapper
public interface UserMapper {
    List<User> listAll();
}
