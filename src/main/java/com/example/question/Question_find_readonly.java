package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question_find_readonly extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int  id=Integer.parseInt(request.getParameter("id"));
        List<Question> list=new ArrayList<>();
        list=Question_select.findbyId(request,id);

        request.setAttribute("find",list);
        request.setAttribute("useranswer",request.getParameter("useranswer"));//用户该题回答
        request.setAttribute("correct",request.getParameter("correct"));//用户该题回答是否正确
        request.setAttribute("number",request.getParameter("number"));//该题题号
        request.getRequestDispatcher("/test/display_readonly.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
