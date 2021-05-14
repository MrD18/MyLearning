package com.yss.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

/**
 * @author: duhao
 * @date: 2021/4/28 14:39
 */
@Data
@ExcelTarget("layer2")
public class Layer2 {

    @Excel(name = "编号")
    private String layerId;

    @Excel(name = "法规名称")
    private String layerName;

    @Excel(name = "法规描述" )
    private String description;

    @Excel(name = "法规发布日期",format = "yyyy年MM月dd日")
    private Date releaseTime;

    @Excel(name = "法规上传日期",format = "yyyy年MM月dd日")
    private Date recordTime;
}
