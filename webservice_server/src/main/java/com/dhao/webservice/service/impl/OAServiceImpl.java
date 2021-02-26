package com.dhao.webservice.service.impl;

import com.dhao.webservice.entry.oa.dmo.CreateSignSaveDO;
import com.dhao.webservice.entry.oa.dto.CreateOASignDTO;
import com.dhao.webservice.service.OAService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author: duhao
 * @date: 2021/1/8 20:14
 */
@WebService
public class OAServiceImpl implements OAService {
    @WebMethod
    @Override
    public CreateSignSaveDO restoaInfo(CreateOASignDTO createOASignDTO) {

        System.out.println("接受传递过来的参数:"+createOASignDTO);
        CreateSignSaveDO createSignSaveDO = new CreateSignSaveDO();
          createSignSaveDO.setProductName("测试产品");
          createSignSaveDO.setProductId("20200108");
          createSignSaveDO.setApplyDept("申请部门");
          createSignSaveDO.setApplyDeptCode("申请部门id");
          createSignSaveDO.setOaSignProcessInstanceId("流程id");
          createSignSaveDO.setAccessLink("http://{ip}:{port}/download?filename=xxxxx"+"<法律文件>.txt");
          createSignSaveDO.setWorkNum("101010101001");
        return createSignSaveDO;
    }
}
