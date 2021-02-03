package com.dhao.service;

import cn.hutool.http.webservice.SoapClient;
import cn.hutool.http.webservice.SoapProtocol;
import com.dhao.bo.OAServiceImpl;
import com.dhao.entiy.Attachment;
import com.dhao.entiy.Attachments;
import com.dhao.entiy.CreateOASignVO;
import com.dhao.entiy.CreateSignSaveDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2021/1/21 9:27
 */
@Slf4j
public class OAService {


    public static void jaxWsDynamicTest() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
     /*   Client client = dcf.createClient("http://localhost:8088/UserWebService?wsdl");
        Object[] objects;
        try {
            objects = client.invoke("getUserById", 1);
            System.out.println("返回数据:" + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public static void jaxWsDynamicTest2(){

        try {
            // 接口地址
            String address = "http://localhost:8088/OAService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(OAServiceImpl.class);
            // 创建一个代理接口实现
            OAServiceImpl oa = (OAServiceImpl) jaxWsProxyFactoryBean.create();
            // 数据准备
            // 给attachment中添加属性
            Attachment attachment = new Attachment();
            attachment.setFileType("法律附件");
            attachment.setDownloadLink("http:/{ip}/{port}/xxxxx");

            List<Attachment> attachmentList = new ArrayList<>();
            attachmentList.add(attachment);
            // 将List放入到 attachments中
            Attachments attachments = new Attachments();
            attachments.setAttachment(attachmentList);

            CreateOASignVO createOASignVO = new CreateOASignVO();
            createOASignVO.setProductName("产品名称");
            createOASignVO.setProductId("产品id");
            createOASignVO.setApplyDept("申请部门");
            createOASignVO.setWorkName("申请人");
            createOASignVO.setAttachments( attachments);
            // 调用代理接口的方法调用并返回结果
            CreateSignSaveDO createSignSaveDO = oa.restoaInfo(createOASignVO);
            System.out.println(createOASignVO);
            System.out.println("-----------------");
            String productName = createSignSaveDO.getProductName();
            String accessLink = createSignSaveDO.getAccessLink();
            System.out.println("OA返回参数--productName:"+productName);
            System.out.println("OA返回参数--accessLink:"+accessLink);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // 方法二
    public static void hutoolsTest() {
        SoapClient soapClient = SoapClient.create("http://localhost:8088/UserWebService?wsdl", SoapProtocol.SOAP_1_1, "http://impl.service.webservice.dhao.com/");

// 这里说一下为什么方法名称要加一个 web: ,这个请用 SoapUI 客户端解析一下wsdl，可创建一个request
// 这时可查看 request请求内容里面的xml具体内容,可看到有web: 这个命名空间的前缀
/**
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.mytest.middol.com">
 <soapenv:Header/>
 <soapenv:Body>
 <web:sayHello>
 <web:yourName>?</web:yourName>
 </web:sayHello>
 </soapenv:Body>
 </soapenv:Envelope>
 **/
        String soapMessage = soapClient.
                setMethod("getUserById").setParam("id", 1).send(true);
        System.out.println(soapMessage);
    }




    public static void main(String[] args) {

        // 采用cxf方式
   //    jaxWsDynamicTest();
    //    hutoolsTest();

        jaxWsDynamicTest2();


    }

}
