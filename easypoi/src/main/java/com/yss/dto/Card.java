package com.yss.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: duhao
 * @date: 2021/4/28 11:20
 */
@ExcelTarget("car")
@Data
@Accessors(chain = true)
public class Card implements Serializable {
    @Excel(name = "身份证",width = 20.0,orderNum = "6")
    private  String no;
    @Excel(name = "籍贯",width = 40.0,orderNum = "5")
    private String addr;
}
