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

@WebServlet("/LoginServletTwo")
public class LoginServletTwo extends HttpServlet {
    ArrayList<UserData> arrayList = null;
    ServletContext context = null;


    @Override
    public void init(ServletConfig config) throws ServletException {
        arrayList = new ArrayList();
        //模拟数据库
        arrayList.add(new UserData("a1", "123", 0, null));
        arrayList.add(new UserData("a2", "123", 0, null));
        arrayList.add(new UserData("a3", "123", 0, null));
        //初始域变量
        context = config.getServletContext();
        context.setAttribute("count", 0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData userData = new UserData();
        //获取name标签的请求数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置格式，避免乱码
        response.setContentType("text/html;charset=utf-8");
        //获取响应输入流
        Writer writer = response.getWriter();
        userData.setUsername(username);
        userData.setPassword(password);
        //遍历数组寻找匹配项目
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(userData)) {
                //设置域变量，登陆+1
                context.setAttribute("count", (int) context.getAttribute("count") + 1);
                writer.write("<h1>你是第" + context.getAttribute("count") + "位登陆</h1>");
                userData = arrayList.get(i);
                //设置模拟数据库登陆次数
                userData.setLogCount(userData.getLogCount() + 1);
                writer.write("<h1>这是第" + userData.getLogCount() + "次登陆</h1>");
                if (userData.getLastLogTime() != null) {
                    writer.write("<h1>这是上次登陆时间" + userData.getLastLogTime() + "</h1>");
                }
                //设置时间格式输出
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userData.setLastLogTime(simpleDateFormat.format(new Date()));
                return;
            }
        }
        writer.write("<h1>错误</h1>");
    }
}
