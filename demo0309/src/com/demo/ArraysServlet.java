package com.demo;

import com.bean.Student;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArraysServlet", urlPatterns = "/demo01.do")
public class ArraysServlet extends HttpServlet {
    ArrayList<Student> arrayList = new ArrayList<>();
//    ServletContext context = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        arrayList.add(new Student(123, "adsf", 123));
        arrayList.add(new Student(312, "aasdsf", 321));

//        context=config.getServletContext();
//        context.setAttribute("stu",arrayList);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("stu", arrayList);

        request.getRequestDispatcher("/demo01.jsp").forward(request, response);
    }

}
