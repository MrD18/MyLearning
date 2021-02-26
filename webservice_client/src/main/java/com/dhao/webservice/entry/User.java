package com.dhao.webservice.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: duhao
 * @date: 2021/1/7 12:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    private int id;
    private String name;
    private int age;

}
