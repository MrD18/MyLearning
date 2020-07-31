package com.yss.other.Hutool;

import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**BeanUtil-- 这个很牛逼
 * JavaBean的工具类，可用于Map与JavaBean对象的互相转换以及对象属性的拷贝。
 * @author: duhao
 * @date: 2020/7/13 17:30
 */
public class TestBeanUtil {
    private final static Logger logger = LoggerFactory.getLogger(TestBeanUtil.class);
    public static void main(String[] args) {
        PmsBrand brand = new PmsBrand();
        brand.setId(1L);
        brand.setName("小米");
        brand.setShowStatus(0);
        // Bean 转Map
        Map<String, Object> map = BeanUtil.beanToMap(brand);
        logger.info("beanUtil bean to map:{}", map);
        //Map转Bean
        PmsBrand mapToBean = BeanUtil.mapToBean(map, PmsBrand.class,false);
        logger.info("beanUtil map to bean:{}", mapToBean); // 转换成一个对象了

        //Bean属性拷贝
        PmsBrand copyBrand = new PmsBrand();
        BeanUtil.copyProperties(brand, copyBrand); // 这个新new 的copyBrand 就具有brand的所有属性
        logger.info("beanUtil copy properties:{}", copyBrand);
    }
}

class PmsBrand{
    private  Long id;
    private  String name;
    private  Integer showStatus;

    public PmsBrand() {
    }

    public PmsBrand(Long id, String name, Integer showStatus) {
        this.id = id;
        this.name = name;
        this.showStatus = showStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }
}