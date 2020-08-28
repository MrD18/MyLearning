package com.yss.other.过滤器与拦截器.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**过滤器 基于@WebFilter注解方式
 *
 * 使用@WebFilter注解为声明当前类为filter，
 * 第一个参数为该filter起一个名字，
 * 第二个参数为说明要拦截的请求地址，
 * 当前类需要实现Filter接口，里面有三个方法，分别为过滤器初始化、过滤方法和过滤器销毁。
 * @author: duhao
 * @date: 2020/8/5 16:15
 */

@Slf4j
@WebFilter(filterName = "myFilter1",urlPatterns = "/test1") // http://localhost:8080/test1  拦截所有的请求
public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info(filterConfig.getFilterName()+":init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    log.info("myFilter1 begin");

        try {
            log.info("业务方法执行");
            chain.doFilter(request,response);
        } catch (IOException e) {
            log.error("error!",e);
        }
        log.info("myFilter1 end");

    }

    @Override
    public void destroy() {
      log.info("销毁过滤器");
    }
}
