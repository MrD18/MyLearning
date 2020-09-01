package com.yss.java8.项目中使用Lambda进行重构.controller;

import com.alibaba.excel.EasyExcel;
import com.yss.java8.项目中使用Lambda进行重构.pojo.Department;
import com.yss.java8.项目中使用Lambda进行重构.pojo.DepartmentData;
import com.yss.java8.项目中使用Lambda进行重构.service.DeptService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/** 测试数据导出
 * @author: duhao
 * @date: 2020/8/31 13:38
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private DeptService deptService;

    @SneakyThrows
    @GetMapping("/download")
    public void Download(HttpServletResponse response) {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DepartmentData.class).sheet("用户信息").doWrite(data());

    }

    private List<DepartmentData> data() {
        //创建的是UserData 对象,是要往excel中写的对象,这个很重要,就是你要写入的对象
        List<DepartmentData> list = new ArrayList<>();
        // 从库中查的数据
        List<Department> departmentList = deptService.getAllDepartment();
        for (Department department : departmentList) {
            DepartmentData departmentData = new DepartmentData();
            departmentData.setDeptName(department.getDeptName());
            departmentData.setDeptNo(department.getDeptNo());
            list.add(departmentData);
        }
     return list;
    }

}
