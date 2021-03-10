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

@WebServlet("/LoginServletThree")
public class LoginServletThree extends HttpServlet {
    ArrayList<UserData> arrayList = null;
    ServletContext context = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟数据库
        arrayList = new ArrayList<>();
        arrayList.add(new UserData("b1","123",0,null));
        arrayList.add(new UserData("b2","123",0,null));
        arrayList.add(new UserData("b3","123",0,null));
        //初始化域变量
        context = config.getServletContext();
        context.setAttribute("count",0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData userData = new UserData();
        //获取请求，通过name名获取到value值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置文本编码格式
        response.setContentType("text/html;charset=utf-8");
        userData.setUsername(username);
        userData.setPassword(password);
        //获取响应的当中的字符输入流
        Writer writer = response.getWriter();
        //是否包含数据
        if (arrayList.contains(userData)){
            //域变量+1
            context.setAttribute("count",(int)context.getAttribute("count")+1);
        writer.write("<h1>您是第"+context.getAttribute("count")+"位</h1>");
        for (int i =0;i<arrayList.size();i++){
            //匹配数据
            if (arrayList.get(i).equals(userData)){
                userData = arrayList.get(i);
                //对象登陆次数+1
                userData.setLogCount(userData.getLogCount()+1);
                writer.write("<h1>这是您第"+userData.getLogCount()+"次登陆</h1>");
                if (userData.getLastLogTime()!=null){
                    //设置上次登陆时间
                    writer.write("<h1>上次登陆时间是"+userData.getLastLogTime()+"</h1>");
                }
                userData.setLastLogTime(simpleDateFormat.format(new Date()));
            }
        }
        }else {
            writer.write("用户名或密码错误");
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
