package org.yss.entity;

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
@XmlRootElement(name = "Car")
public class Car {
    private Integer id;
    private  String carName;
    private  Double price;

    public Car() {
    }

    public Car(Integer id, String carName, Double price) {
        this.id = id;
        this.carName = carName;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", carName='" + carName + '\'' + ", price=" + price + '}';
    }
}
