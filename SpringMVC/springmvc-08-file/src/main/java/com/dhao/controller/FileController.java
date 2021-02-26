package com.dhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: duhao
 * @date: 2020/12/29 22:06
 */
@Controller
public class FileController {
    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可
    @PostMapping ("/upload")
    public String fileUpload( CommonsMultipartFile uploadFile , HttpServletRequest request) throws IOException, IOException {

        //1. 获取唯一的文件名（uuid）
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //2. 获取后缀名
        //获取原始文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //截取后缀名: 从最后点开始截取到最后就是后缀名
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //最终上传到服务器的文件名
        String fileName = uuid + extendName;
        System.out.println(fileName);
        //3. 获取服务器的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //判断是否存在该路径，如果没有，则创建
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //开始上传
        try {
            uploadFile.transferTo(new File(realPath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/upload2")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile uploadFile, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        uploadFile.transferTo(new File(realPath +"/"+ uploadFile.getOriginalFilename()));

        return "redirect:/index.jsp";
    }


}


