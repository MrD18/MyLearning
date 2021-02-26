package com.dhao.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**服务端创建一个接口
 * @author: duhao
 * @date: 2021/1/7 12:18
 */
@WebService
public interface UserWebService {
    @WebMethod
    String getUserById(@WebParam(name = "id") Integer id);
}
