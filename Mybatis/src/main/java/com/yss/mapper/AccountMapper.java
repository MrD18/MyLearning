package com.yss.mapper;

import com.yss.entity.bo.AccountBO;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/12/11 13:37
 */
public interface AccountMapper {
    List<AccountBO> findAll();

}
