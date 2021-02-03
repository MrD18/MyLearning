package com.dhao.webservice.entry.oa.dmo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2021/1/8 20:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSignSaveDO {
    //产品id
    private String productId;
    //产品名称
    private  String productName;
    //申请人工号
    private  String workNum;
    //申请部门code
    private String applyDeptCode;
    //申请人部门
    private String applyDept;
    //OA 签报流程实例ID
    private  String oaSignProcessInstanceId;
    // 访问详细链接
    private String accessLink;
}
