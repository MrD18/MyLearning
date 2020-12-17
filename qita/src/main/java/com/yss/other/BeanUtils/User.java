package com.yss.other.BeanUtils;

import lombok.Data;

/**
 * @author: duhao
 * @date: 2020/12/12 11:18
 */
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String role;
    private Integer limitTimes;
    private Integer number;
    private String questions;
    private Long startTime;
    private Long endTime;
    private String testUrl;
    private Long createTime;


}
