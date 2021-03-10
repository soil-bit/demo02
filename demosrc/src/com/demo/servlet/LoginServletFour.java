package com.demo.servlet;

import com.demo.bean.UserData;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/LoginServletFour")
public class LoginServletFour extends HttpServlet {
    ArrayList<UserData> arrayList = new ArrayList<>();
    ServletContext context = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟数据库
        arrayList.add(new UserData("c1", "123", 0, null));
        arrayList.add(new UserData("c2", "123", 0, null));
        arrayList.add(new UserData("c3", "123", 0, null));
       //初始化context域变量
        context = config.getServletContext();
        context.setAttribute("count", 0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData userData = new UserData();
        ////通过name名获取到值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userData.setUsername(username);
        userData.setPassword(password);

        response.setContentType("text/html;charset=utf-8");
        //获取响应的当中的字符输入流
        Writer writer = response.getWriter();
        //变量数据库，寻找匹配项
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(userData)) {
                //域变量+！
                context.setAttribute("count", (int) context.getAttribute("count") + 1);
                writer.write("<h1>这是第" + context.getAttribute("count") + "位登陆站点</h1>");
                userData = arrayList.get(i);
                //对象登陆+1
                userData.setLogCount(userData.getLogCount() + 1);
                writer.write("<h1>这是你第" + userData.getLogCount() + "次登陆站点</h1>");
                if (userData.getLastLogTime() != null) {
                    //显示上次登陆时间
                    writer.write("<h1>上次登陆:" + userData.getLastLogTime() + "</h1>");
                }
                //设置登陆时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userData.setLastLogTime(simpleDateFormat.format(new Date()));
                return;
            }
        }
        writer.write("用户名或密码错误");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
