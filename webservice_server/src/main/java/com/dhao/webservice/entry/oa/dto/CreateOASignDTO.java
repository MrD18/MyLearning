package com.dhao.webservice.entry.oa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2021/1/8 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOASignDTO {
    // 标题
    private String productId;
    //
    private  String productName;
    private  String workName;
    private String applyDept;
    private  Attachments  attachments;
}
