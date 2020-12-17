package com.yss.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: duhao
 * @date: 2020/12/10 10:42
 */
@Data
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    /**
     * Map ：String(namespace + id),Mapper(返回值类型和sql语句)
     *
     */
    private Map<String,Mapper> xmMap = new HashMap<>();


}
