package com.yss.other.yunzhihui;

import lombok.Data;

/**
 * @Author: dhao
 * @Date: 2021/6/8 6:26 下午
 */
@Data
public class User {
   // @SensitiveInfo(type = SensitiveUtils.sensitiveType.str)
    private String name;

    private  Long  accountId;
    private String password;

}
