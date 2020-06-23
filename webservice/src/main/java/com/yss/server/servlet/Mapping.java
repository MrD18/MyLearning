package com.yss.server.servlet;

import java.util.HashSet;
import java.util.Set;

/**
 *    <servlet-mapping>
 *         <servlet-name>reg</servlet-name>
 *         <url-pattern>/reg</url-pattern>
 *         <url-pattern>/r</url-pattern>
 *     </servlet-mapping>
 * @author: duhao
 * @date: 2020/6/20 22:34
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns =new HashSet<String>();
    }

    public Mapping(String name, Set<String> patterns) {
        this.name = name;
        this.patterns = patterns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }
public  void addPattern(String pattren){
        this.patterns.add(pattren);
}

    @Override
    public String toString() {
        return "Mapping{" + "name='" + name + '\'' + ", patterns=" + patterns + '}';
    }
}
