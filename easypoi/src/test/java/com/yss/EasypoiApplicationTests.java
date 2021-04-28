package com.yss;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yss.dto.Card;
import com.yss.dto.Layer;
import com.yss.dto.Layer2;
import com.yss.dto.Order;
import com.yss.service.LayerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EasypoiApplicationTests {


    @Autowired
    private LayerService layerService;

    @Test
    void contextLoads() {
    }

    // 导出测试
    @Test
        public void getList () throws IOException {
            List<Layer> layerList = layerService.getList();
            List<Order> orders = new ArrayList<>();
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
            FileOutputStream outputStream = new FileOutputStream(new File("E:/导出文件测试/employee导出.xlsx"));
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();

        }
/**
 * 导入测试
 */
  @Test
   public  void test3() throws Exception {
      //参数1: 导入excel文件流, 参数2:导入类型   参数3: 导入的配置对象
      ImportParams params = new ImportParams();
      params.setTitleRows(1); //标题列站用几行
      params.setHeadRows(1); // header 列占用几行
     // params.setStartSheetIndex(2);// 从第二个sheet页开始, 默认是1
     // params.setSheetNum(3); 读到第3个sheet结束, 默认是1
      params.setImportFields(new String[]{"法规名称","状态"}); // 必须有这些字段才是合法的excel,没有 状态 这个会报 不是合法的Excel模板
      List<Layer2> layer2List = ExcelImportUtil.importExcel(new FileInputStream("C:\\Users\\yss\\Desktop\\layer.xlsx"), Layer2.class, params);
      for (Layer2 layer2 : layer2List) {
         layerService.InsertLayer2(layer2); // 读取excel 并写入到数据库
      }
      layer2List.forEach(System.out::println);
  }



        // 根据模板导出
  /*  @Test
   public void test2(){
        List<Layer> layerList = layerService.getList();

        TemplateExportParams params = new TemplateExportParams();
        params.setHeadingRows(2);
        params.setHeadingStartRow(2);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("year", "2013");
        map.put("sunCourses", list.size());
        Map<String,Object> obj = new HashMap<String, Object>();
        map.put("obj", obj);
        obj.put("name", list.size());
        params.setTemplateUrl("org/jeecgframework/poi/excel/doc/exportTemp.xls");
        Workbook book = ExcelExportUtil.exportExcel(params, CourseEntity.class, list,
                map);

    }*/
    }
