package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question_find extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
       int  id=Integer.parseInt(request.getParameter("id"));
        List<Question> list=new ArrayList<>();
        list=Question_select.findbyId(request,id);

        request.setAttribute("find",list);
        request.getRequestDispatcher("/test/display.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String title=request.getParameter("title");
        List<Question> list=new ArrayList<>();
        list=Question_select.find(request,title);

        request.setAttribute("find",list);
        request.getRequestDispatcher("/test/find.jsp").forward(request,response);
    }
}
