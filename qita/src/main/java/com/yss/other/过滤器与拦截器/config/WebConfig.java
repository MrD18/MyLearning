package com.yss.other.过滤器与拦截器.config;

import com.yss.other.过滤器与拦截器.filter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**过滤器配置类
 * 基于 @Bean注解方式方式开发
 *
 * 写这个配置类， 加上注解 启动后spring会自动扫描这个配置类，并将其注入spring容器中
 * @author: duhao
 * @date: 2020/8/5 16:52
 */
//@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean<MyFilter2> registration = new FilterRegistrationBean<>(new MyFilter2());
          registration.addUrlPatterns("/test2");
          registration.setName("myFilter2");
          return registration;

    }
}
