package com.yss.server.servlet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author: duhao
 * @date: 2020/6/20 23:06
 */
public class WebContext {
    //获取数据
   private List<Entity> entitys = null;
   private List<Mapping> mappings= null;
   // key: servlet-name value: servlet-class
   private Map<String,String> entityMap= new HashMap<>();
   // key:  url-pattern value: servlet-name
   private Map<String,String> mappingMap= new HashMap<>();


    public WebContext(List<Entity> entitys, List<Mapping> mappings) {
        this.entitys = entitys;
        this.mappings = mappings;
        //将entity 的List 抓换成map
        for (Entity entity : entitys) {
            entityMap.put(entity.getName(),entity.getClz());
        }
        // 将map的List转换成map
        for (Mapping mapping : mappings) {
            for (String pattern : mapping.getPatterns()) {
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }

    /**
     * 通过URL的路径找到对应class
     * @param pattern
     * @return
     */
    public  String getClz(String pattern){
        return mappingMap.get(pattern);
    }
}
