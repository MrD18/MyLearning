package com.dhao.webservice.service;

import com.dhao.webservice.entry.oa.dmo.CreateSignSaveDO;
import com.dhao.webservice.entry.oa.dto.CreateOASignDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author: duhao
 * @date: 2021/1/8 20:00
 */
@WebService
public interface OAService {
    @WebMethod
    public CreateSignSaveDO restoaInfo(CreateOASignDTO createOASignDTO);

}
