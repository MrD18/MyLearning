package com.dhao.entiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** 传过去的数据
 * @author: duhao
 * @date: 2021/1/8 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOASignVO implements Serializable {
    // 标题
    private String productId;
    //
    private  String productName;
    private  String workName;
    private String applyDept;
    private Attachments attachments;
}
