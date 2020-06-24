package com.yss.server.servlet;

/**
 *     <servlet>
 *         <servlet-name>reg</servlet-name>
 *         <servlet-class>com.shsxt.RegisterServlet</servlet-class>
 *     </servlet>
 * @author: duhao
 * @date: 2020/6/20 22:32
 */
public class Entity {
    private String name;
    private  String clz;

    public Entity() {
        this.name = name;
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return "Entity{" + "name='" + name + '\'' + ", clz='" + clz + '\'' + '}';
    }
}
