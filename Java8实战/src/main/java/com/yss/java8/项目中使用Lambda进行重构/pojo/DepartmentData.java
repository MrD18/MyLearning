package com.yss.java8.项目中使用Lambda进行重构.pojo;

/** 自定义部, 就是往外要导出的数据
 * 部门类

 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Accessors(chain = true)
public class DepartmentData<AllArgsConstructor> {
    private Long        deptNo;     //  部门编号
    private String      deptName;   //  部门名称
 //   private String      location;   //  部门所在地区

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
/*
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }*/
}