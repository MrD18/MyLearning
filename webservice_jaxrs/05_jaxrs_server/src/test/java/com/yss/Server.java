package com.yss;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.yss.service.IUserServiceImpl;

/** 发布服务 在test,
 * @author: duhao
 * @date: 2020/6/22 10:55
 */
public class Server {
    public static void main(String[] args) {
        //创建发布服务的工厂
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        // 设置服务地址
        factory.setAddress("http://localhost:8002/dh/");
        //设置服务类型
        factory.setServiceBean(new IUserServiceImpl());
        // 添加日志输入输出拦截器
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        // 发布服务
        factory.create();
        System.out.println("发布服务成功,端口8002");
    }
}
