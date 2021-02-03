package com.yss.Spring注解驱动.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2021/1/27 14:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String userName;
    private Integer age;
}
