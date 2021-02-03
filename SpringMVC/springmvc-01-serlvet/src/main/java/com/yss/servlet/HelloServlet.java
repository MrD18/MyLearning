package com.yss.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: duhao
 * @date: 2020/12/26 15:28
 */
public class HelloServlet extends HttpServlet {
   /*接受前端的请求*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1. 获取前端参数
        //取得参数
        String method = req.getParameter("method");
        if (method.equals("add")){
            req.getSession().setAttribute("msg","执行了add方法");
        }
        if (method.equals("delete")){
            req.getSession().setAttribute("msg","执行了delete方法");
        }

    //2. 调用业务层
    //3. 视图转发或者重定向
         //转发
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);// .forward(req,resp)转发携带参数
   /*    //重定向
        resp.sendRedirect();*/


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*doPost调doGet 实现复用*/
         doGet(req,resp);
    }
}
