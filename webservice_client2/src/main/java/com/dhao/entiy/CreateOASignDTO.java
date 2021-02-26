package com.dhao.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: duhao
 * @date: 2021/1/8 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOASignDTO implements Serializable {
    // 标题
    private String productId;
    //
    private  String productName;
    private  String workName;
    private String applyDept;
    private  Attachments  attachments;
}
