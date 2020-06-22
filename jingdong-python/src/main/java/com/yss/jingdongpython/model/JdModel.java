package com.yss.jingdongpython.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2020/6/17 16:38
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JdModel {
    private String bookID;
    private String bookName;
    private String bookPrice;
}
