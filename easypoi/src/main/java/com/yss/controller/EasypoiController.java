package com.yss.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yss.dto.Card;
import com.yss.dto.Layer;
import com.yss.dto.Layer2;
import com.yss.dto.Order;
import com.yss.service.LayerService;
import com.yss.utils.ExcelUtils;
import com.yss.utils.Result;
import com.yss.utils.StatusCode;
import com.yss.utils.Upload;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author: duhao
 * @date: 2021/4/27 16:06
 */
@RestController
@Slf4j
public class EasypoiController {

    @Autowired
    private LayerService layerService;

    /**
     * 写一个前端上传文件到后端, 并存入到数据库
     */

    @PostMapping("/import")
    public Result importExcel(@RequestParam("file") MultipartFile file){
         log.info("文件名:{}",file.getOriginalFilename()); // 获取文件名
        ImportParams params = new ImportParams();
        params.setTitleRows(1); //标题列站用几行
        params.setHeadRows(1); // header 列占用几行
        List<Layer2> layer2List=null;
        try {
            layer2List = ExcelImportUtil.importExcel(file.getInputStream(), Layer2.class, params);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, StatusCode.ERROR,"解析失败",layer2List);
        }
        log.info("解析的数据为:{}",layer2List);
          // 存入数据库
        // 解析完后会是一个list,我们做对这个list进行存储
        layerService.saveAll(layer2List);
        return new Result(true, StatusCode.OK,"解析成功",layer2List);
    }

    /**
     * 导出excel文件, 从数据查出来 在导出
     */
    @GetMapping("/export")
    public Result getAllList(HttpServletResponse response) throws IOException {
        List<Layer2> layerList=layerService.getList2();
      log.info("导出excel,导出数据总数为:{}",layerList.size());
         // 生成excel
      /*  Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("导出文件信息", "sheet信息"), Layer2.class, layerList);
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("导出数据列表.xls","UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();*/
      // 使用工具类导出
        ExcelUtils.exportExcel(layerList,"导出文件信息","sheet信息",Layer2.class,"导出数据列表.xls",response);
        return new Result(true, StatusCode.OK,"导出成功",layerList);
    }

    /**
     * 导出数据到本地的demo
     */
    @GetMapping (value = "/getList")
    public Result getList() throws IOException {
          List<Layer> layerList=layerService.getList();
          List<Order> orders= new ArrayList<>();
               orders.add(new Order().setNo("12").setName("订单编号1"));
               orders.add(new Order().setNo("13").setName("订单编号2"));
               orders.add(new Order().setNo("15").setName("订单编号3"));

        for (Layer layer : layerList) {
            layer.setCard(new Card().setNo("11111").setAddr("北京国寿广场"));
            layer.setOrders(orders);
        }
         //导出excel
        // 参数1:exportParams 导出配置对象  参数2:导出类型 参数3:导出数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("导出的是标题", "sheet名字"), Layer.class, layerList);
        //将excel 写入指定位置: 目前是写在了本地磁盘上
        FileOutputStream outputStream = new FileOutputStream("E:/导出文件测试/cc.xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return new Result(true,StatusCode.OK,"导出数据到本地成功",layerList);
    }





    /**
     * 方法有问题!!!!!
     * 处理Excel解析的方法
     * @param file 前台上传的文件对象
     * @return
     */
    @PostMapping(value = "/Index/layer/excelparser")
    public Result Excel(HttpServletRequest request, @RequestParam("file") MultipartFile file)throws Exception {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        String fileName1 = request.getParameter("template");// 设置文件名，根据业务需要替换成要下载的文件名
        String fileName;
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";

            uploadDir=uploadDir.substring(0,uploadDir.length()-1);
            uploadDir=uploadDir+"\\";//下载目录
            String realPath=uploadDir+fileName1;//
            File dir = new File(realPath);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //调用上传方法
            fileName= Upload.executeUpload1(uploadDir, file,fileName1);
            uploadDir=uploadDir.substring(0,uploadDir.length()-1);
            dataMap.put("fileName",fileName);
            dataMap.put("dir",uploadDir);
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return new Result(false, StatusCode.ERROR,"解析失败",dataMap);
          //  return api.returnJson(2,"解析失败",dataMap);
        }
        ExcelParser(fileName);
        return new Result(true, StatusCode.OK,"解析成功",dataMap);
    }
    public void ExcelParser(String fileName)throws Exception{
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = System.currentTimeMillis();
        List<Layer> list=new ArrayList<>();
        list = Upload.importExcel("C:/Users/sl/Desktop/layer/layer/src/main/webapp/upload/"+fileName, 1, 1, Layer.class);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());
        System.out.println(list);
        int testId=1;
        int isInsert=0;
        for (int i = 0; i <list.size() ; i++) {
            Layer layer=new Layer();
            UUID uuid=UUID.randomUUID();
            String layerId=uuid.toString();
            layer.setLayerId(layerId);
            layer.setLayerName(list.get(i).getLayerName());
            layer.setDescription(list.get(i).getDescription());
            layer.setRecordTime(list.get(i).getRecordTime());
            layer.setReleaseTime(list.get(i).getReleaseTime());
            int is_add=layerService.InsertLayer(layer);
            System.out.println(is_add);
        }
    }

}
