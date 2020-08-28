package com.yss.other.过滤器与拦截器.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Time 时间拦截器（比时间过滤器准））
 * @author: duhao
 * @date: 2020/8/5 17:16
 */
@Slf4j
@Component
public class TimeInterceptor  implements HandlerInterceptor {
    //controller 调用之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("执行preHandle，在调用controller调用前被调用");
       // log.info(((HandlerMethod)handler).getBean().getClass().getName());
        // log.info(((HandlerMethod)handler).getMethod().getName());
          request.setAttribute("startTime",System.currentTimeMillis());
         return true;
    }
    //controller 调用之后被调用，如果有异常则不调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("postHandle,在controller 调用之后被调用，如果有异常则不调用");
        long startTime = (long) request.getAttribute("startTime");
        log.info("时间拦截器耗时:"+(System.currentTimeMillis() -startTime));

    }
    //controller 调用之后被调用，有没有异常都会被调用,Exception 参数里放着异常信息
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       log.info("afterCompletion,在controller 调用之后被调用，有没有异常都会被调用,Exception 参数里放着异常信息");
        long startTime = (long) request.getAttribute("startTime");
       log.info("时间拦截器耗时:"+(System.currentTimeMillis() -startTime));
    }
}
