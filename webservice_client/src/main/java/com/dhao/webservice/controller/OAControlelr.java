package com.dhao.webservice.controller;

import com.dhao.webservice.entry.oa.dmo.CreateSignSaveDO;
import com.dhao.webservice.entry.oa.dto.Attachment;
import com.dhao.webservice.entry.oa.dto.Attachments;
import com.dhao.webservice.entry.oa.dto.CreateOASignVO;
import com.dhao.webservice.service.OAServiceImpl;
import com.dhao.webservice.service.impl.OAServiceImplService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2021/1/8 20:39
 */
@RestController
public class OAControlelr {


    /* @Autowired
    private OAServiceImplService oaServiceImplService;*/
    @PostMapping("/send")
    public CreateSignSaveDO send(@RequestBody CreateOASignVO createOASignVO){
        System.out.println(createOASignVO);
     /*   //获取服务实现类
        OAServiceImpl port = oaServiceImplService.getPort(OAServiceImpl.class);
        // 获取服务方法
      CreateSignSaveDO createSignSaveDO = port.restoaInfo(createOASignVO);

        return createSignSaveDO;

*/

        OAServiceImplService oaServiceImplService = new OAServiceImplService();
         // 获取服务实现类
        OAServiceImpl port = oaServiceImplService.getPort(OAServiceImpl.class);
        CreateSignSaveDO createSignSaveDO = port.restoaInfo(createOASignVO);
        return createSignSaveDO;
    }


    @GetMapping("/testsend")
    public CreateOASignVO send() {

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

            return createOASignVO;

     }
}
