package com.yss.entity.bo;

import com.yss.domain.User;
import lombok.Data;

/**
 * @author: duhao
 * @date: 2020/12/11 13:19
 */
@Data
public class AccountBO {
    private Integer id;
    private String name;
    private Integer userId;
    //对应用户信息
    private User user;

}
