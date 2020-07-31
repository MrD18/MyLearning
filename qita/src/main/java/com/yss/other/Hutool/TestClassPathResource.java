package com.yss.other.Hutool;

import cn.hutool.core.io.resource.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/** ClassPathResource
 * 获取classPath下的文件，在Tomcat等容器下，classPath一般是WEB-INF/classes。
 * @author: duhao
 * @date: 2020/7/13 17:03
 */

public class TestClassPathResource {
    private final static Logger logger = LoggerFactory.getLogger(TestClassPathResource.class);
    public static void main(String[] args) throws IOException {
        //获取定义在src/main/resources文件夹中的配置文件
        ClassPathResource resource = new ClassPathResource("application.properties");

        Properties properties = new Properties();
        properties.load(resource.getStream());
        logger.info("/classPath:{}", properties);
    }
}
