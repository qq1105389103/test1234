package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String optionA=request.getParameter("optionA");
        String optionB=request.getParameter("optionB");
        String optionC=request.getParameter("optionC");
        String optionD=request.getParameter("optionD");
        String answer=request.getParameter("answer");
        int result=0;
        response.setContentType("text/html;charset=utf-8");
        Question question=new Question(null,title,optionA,optionB,optionC,optionD,answer);
        result=Question_insert.add(question,request);
        if(result!=0){
            response.sendRedirect("/testManagement/test/add_success.jsp");
        }
        else{
            response.sendRedirect("/testManagement/test/add_failure.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
