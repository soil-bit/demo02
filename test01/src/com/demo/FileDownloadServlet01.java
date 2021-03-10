package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "FileDownloadServlet01", urlPatterns = "/FileDownloadServlet01.do")
public class FileDownloadServlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        //获取响应对象的字节输入流
        OutputStream outputStream = response.getOutputStream();
        //服务器需要传输的文件
        File file = new File("C:\\Users\\Lenovo\\Pictures\\ssr.png");
        //设置响应头
        response.setHeader("content-disposition","attachment;fileName="+  new String("淇℃伅.jpg".getBytes("utf-8"),"ISO8859-1"));
//        new String("淇℃伅.jpg".getBytes("utf-8"),"ISO8859-1")
        InputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int length=0;
        while ((length = inputStream.read(buffer))!=-1){
            outputStream.write(buffer);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
