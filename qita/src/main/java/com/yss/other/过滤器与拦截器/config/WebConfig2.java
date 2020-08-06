package com.yss.other.过滤器与拦截器.config;

import com.yss.other.过滤器与拦截器.Interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**集成WebMvcConfigurer这个接口，里面有很多方法可以重写
 *
 * 拦截器的配置类
 * @author: duhao
 * @date: 2020/8/5 17:28
 */
@Configuration
public class WebConfig2 implements WebMvcConfigurer {



//注入拦截器
//    @Bean
//   public TimeInterceptor getTimeInterceptor(){
//       return new TimeInterceptor();
//   }
    @Autowired
    private TimeInterceptor timeInterceptor;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

     //   https://blog.csdn.net/zhangpower1993/article/details/89016503  详解
        //往拦截器中添加拦截器,目的是将该拦截器注入到spring容器中
        InterceptorRegistration registration = registry.addInterceptor(timeInterceptor);
        registration.addPathPatterns("/test");   // 路径上有test时 进行拦截
        registration.excludePathPatterns("/emp/login"); // 路径为这个时,进行放行
    }
   // 添加controller
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//  registry.addViewController("/index").setViewName("index");
//    }
}

/**
 *
 解决跨域问题
 public void addCorsMappings(CorsRegistry registry);
 添加拦截器
 void addInterceptors(InterceptorRegistry registry);
 这里配置视图解析器
 void configureViewResolvers(ViewResolverRegistry registry);
 配置内容裁决的一些选项
 void configureContentNegotiation(ContentNegotiationConfigurer configurer);
 视图跳转控制器
 void addViewControllers(ViewControllerRegistry registry);
 静态资源处理
 void addResourceHandlers(ResourceHandlerRegistry registry);
 默认静态资源处理器
 void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
 */
