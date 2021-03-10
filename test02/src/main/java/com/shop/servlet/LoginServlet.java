package com.shop.servlet;

import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(302);
        response.setContentType("text/html;charset");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDaoImpl();


        if (userDao.queryCheckUser(username, password) != null) {
            response.setHeader("location", "/shop/pages/user/login_success.html");
        }else {
            response.setHeader("location", "http://www.baidu.com");
        }

//        if (userDao.queryUserByUsername(username).getUsername().equals(username) && userDao.queryUserByPassword(password).getPassword().equals(password)) {
//            response.setHeader("location", "/shop/pages/user/login_success.html");
//        } {
//            response.setHeader("location", "http://www.baidu.com");
//        }


    }
}
