package com.yss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 基于restful风格的webservice，客户端与服务端之间通讯可以传递xml数据、json数据
 * @XmlRootElement 指定对象序列化为xml或json数据时根节点的名称
 * xml:
 * <User>
 *      <id></id>
 *      <username></username>
 *      <city></city>
 *  </User>
 * json:
 * {"User":  {"id":100,  "username":"jack","city":"广州" }}
 * @author: duhao
 * @date: 2020/6/22 10:12
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@XmlRootElement(name = "Car")
public class Car {
    private Integer id;
    private String carName;
    private Double price;

}