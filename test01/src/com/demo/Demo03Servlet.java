package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Demo03Servlet", urlPatterns = "/demo03.do")
public class Demo03Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(302);

        response.setHeader("Location","demo.do");
        response.sendRedirect("http://www.bing.com");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //302表示重定向
        response.setStatus(302);

        //设置标签头
        response.setHeader("Location","/demo03.do");

        response.sendRedirect("http://www.baidu.com");
    }
}
