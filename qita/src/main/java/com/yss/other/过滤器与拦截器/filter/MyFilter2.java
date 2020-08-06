package com.yss.other.过滤器与拦截器.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**@Bean注解方式
 * 不要加注解@WebFilter
 * @author: duhao
 * @date: 2020/8/5 16:49
 */

// 这种模式下，需要写一个配置文件类，注入到spring容器中
@Slf4j
public class MyFilter2 implements Filter {
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
