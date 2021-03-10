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

@WebServlet("/LoginServletFive")
public class LoginServletFive extends HttpServlet {
    ArrayList<UserData> arrayList = new ArrayList<>();
    ServletContext context = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟数据库
        arrayList.add(new UserData("d1", "123", 0, null));
        arrayList.add(new UserData("d2", "123", 0, null));
        arrayList.add(new UserData("d3", "123", 0, null));
        //获取和初始变量
        context = config.getServletContext();
        context.setAttribute("count", 0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData userData = new UserData();
        //通过name名获取到值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=utf-8");
        userData.setUsername(username);
        userData.setPassword(password);
        //获取响应的当中的字符输入流
        Writer writer = response.getWriter();
        //遍历数组包含匹配项目
        if (arrayList.contains(userData)) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).equals(userData)) {
                    //设置登陆位数
                    context.setAttribute("count", (int) context.getAttribute("count") + 1);
                    writer.write("<h1>您是第" + context.getAttribute("count") + "位登陆</h1>");
                    //设置对象登陆次数
                    userData = arrayList.get(i);
                    userData.setLogCount(userData.getLogCount() + 1);
                    writer.write("<h1>这是您是第" + userData.getLogCount() + "次登陆</h1>");
                    if (userData.getLastLogTime() != null) {
                        //设置登陆时间
                        writer.write("<h1>您上次登陆是" + userData.getLastLogTime() + "</h1>");
                    }
                }
                //设置时间格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userData.setLastLogTime(simpleDateFormat.format(new Date()));

            }
        } else {
            //显示错误
            writer.write("<h1>用户名或密码错误</h1>");
        }
    }
}
