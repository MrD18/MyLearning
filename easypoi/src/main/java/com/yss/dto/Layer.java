package com.yss.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 16:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget("Layer")
public class Layer {
    private String layerId;

    @Excel(name = "法规名称")
    private String layerName;

    @Excel(name = "法规描述" )
    private String description;

    @Excel(name = "法规发布日期",width = 15.0,format = "yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;

    @Excel(name = "法规上传日期",width = 15.0,format = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;

    @ExcelEntity  // 标识一对一关系
    private Card card;

    @ExcelCollection(name="订单列表")  // 一对多导出
    private List<Order> orders;

    private String fileName;


}
