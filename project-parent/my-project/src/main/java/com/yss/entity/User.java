package com.yss.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: duhao
 * @date: 2020/8/6 17:14
 */
@Setter
@Getter
@ToString
public class User {
    private  Long id;
    private  String name;
    private  Integer age;
}
