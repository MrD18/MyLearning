package com.dhao.webservice;

import com.dhao.webservice.service.impl.OAServiceImpl;
import com.dhao.webservice.service.impl.UserWebServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

/**
 * @author: duhao
 * @date: 2021/1/7 12:23
 */
@SpringBootApplication
public class WebserviceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebserviceServerApplication.class, args);

        //这里的接口不能和application.properties中的port一样，不然会报错
        String url = "http://localhost:8088/UserWebService";
        Endpoint.publish(url, new UserWebServiceImpl());
        System.out.println("服务发布成功");

          String url2="http://localhost:8088/OAService";
          Endpoint.publish(url2,new OAServiceImpl());
        System.out.println("发布OA服务成功");

    }
}
