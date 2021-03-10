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

@WebServlet("/Login")
public class LoginServletOne extends HttpServlet {
    ArrayList<UserData> userDataArrayList = null;
    ServletContext context = null;


    @Override
    public void init(ServletConfig config) throws ServletException {
        //新建一个动态数组用于存取数据
        userDataArrayList = new ArrayList<>();
        //模拟数据库存三个用户
        userDataArrayList.add(new UserData("adm01", "123", 0, null));
        userDataArrayList.add(new UserData("adm02", "123", 0, null));
        userDataArrayList.add(new UserData("adm03", "123", 0, null));
        //获取ServletContext()的域变量值
        context = config.getServletContext();
        //设置名为count值为0
        context.setAttribute("count", 0);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //新建一个对象用于存储请求的数据
        UserData userData = new UserData();
        //通过name名获取到value值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置容器类型为文本，编码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        //将获取的值存入对象
        userData.setUsername(username);
        userData.setPassword(password);
        //获取响应的当中的字符输入流
        Writer writer = response.getWriter();

        //查找模拟数据库是否包含对象，若不包含后续else判断输出
        if (userDataArrayList.contains(userData)) {
            //循环遍历动态数组
            for (int i = 0; i < userDataArrayList.size(); i++) {
                //如果模拟数据库与对象数据相等。重写了equal方法这里只比较名字与密码
                if (userDataArrayList.get(i).equals(userData)) {
                    //域变量count加1
                    context.setAttribute("count", (int) context.getAttribute("count") + 1);
                    //向客户端输出字符串
                    writer.write("<h1>您是第" + context.getAttribute("count") + "位登陆本地址的用户");
                    //确定模拟数据库中的数据,设置匹配到的当前对象
                    userData = userDataArrayList.get(i);
                    //设置对象中访问次数加1
                    userData.setLogCount(userData.getLogCount() + 1);
                    //向客户端输出字符串
                    writer.write("<h1>这是您第" + userData.getLogCount() + "次登陆</h1>");
                    //对象时间不为空及非第一次登陆
                    if (userData.getLastLogTime() != null) {
                        //向客户端输出字符串
                        writer.write("<h1>上次登陆的时间为" + userData.getLastLogTime() + "</h1>");
                       //设置新时间
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    userData.setLastLogTime(simpleDateFormat.format(new Date()));
                }
            }
        } else {
            //向客户端输出字符串
            writer.write("<h1>用户名或密码输入错误</h1>");
        }
    }


}
