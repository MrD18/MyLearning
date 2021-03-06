package com.yss.java8.项目中使用Lambda进行重构.controller;


import com.yss.java8.项目中使用Lambda进行重构.pojo.Department;
import com.yss.java8.项目中使用Lambda进行重构.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/hello")
    public String hello() {
        return "hello imooc!";
    }

    @GetMapping("/list")
    public List<Department> getAllDepartment() {
        return deptService.getAllDepartment();
    }

    @GetMapping("/list/deptname/{dname}")
    public List<Department> getDepartmentByName(@PathVariable String dname) {
        return deptService.getDepartmentByName(dname);
    }

    @GetMapping("/list/location/{location}")
    public List<Department> getDepartmentByLocation(@PathVariable String location) {
        return deptService.getDepartmentByLocation(location);
    }
}
