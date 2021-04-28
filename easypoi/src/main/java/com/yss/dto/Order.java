package com.yss.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: duhao
 * @date: 2021/4/28 13:16
 */
@Data
@ExcelTarget("orders")
@Accessors(chain = true)
public class Order  implements Serializable {

@Excel(name="订单信息",orderNum = "7",width = 20.0)
private String no;
@Excel(name = "订单名称",orderNum = "8",width = 15.0)
private String name;

}
