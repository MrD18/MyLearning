package com.yss;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.yss.entity.User;

import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**客户端,远程访问服务端
 * WebClient
 * .create() 指定服务端地址
 * .type() 指定请求数据格式（xml、json）
 * .accept() 指定响应数据格式
 * .post()/put()/delete()/get() 指定请求类型
 * @author: duhao
 * @date: 2020/6/22 11:14
 */
public class Client {
    @Test
    public  void testSave(){
        // 基于restful风格的webservice开发的客户端调用,直接通过一个类:WebClient类完成
        WebClient.create("http://localhost:8002/dh/userService/user")//地址
                 .type(MediaType.APPLICATION_JSON_TYPE)
                 .post(new User(100,"Kobe","gz",null));//请求类型

    }

    @Test
    public void testOne(){
        // 查询一个
        User user =
                WebClient
                        .create("http://localhost:8002/dh/userService/user/1")
                        .accept(MediaType.APPLICATION_JSON)
                      // .accept(MediaType.APPLICATION_XML_TYPE)
                        .get(User.class);
        System.out.println(user);
    }
    @Test
    public void testfindAll(){
        Collection<? extends User> collection =
                WebClient
                        .create("http://localhost:8002/dh/userService/user")
                        .accept(MediaType.APPLICATION_JSON)
                        .getCollection(User.class);
        System.out.println(collection);
    }

}
