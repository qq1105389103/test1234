package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              int id=Integer.parseInt(request.getParameter("id"))  ;
              String title=request.getParameter("title");
              String optionA=request.getParameter("optionA");
              String optionB=request.getParameter("optionB");
              String optionC=request.getParameter("optionC");
              String optionD=request.getParameter("optionD");
              String answer=request.getParameter("answer");
              int result=Question_update_Dao.update(new Question(id,title,optionA,optionB,optionC,optionD,answer),request);
              if(result!=0){
                  response.setContentType("text/html;charset=utf-8");
                  response.sendRedirect("/testManagement/test/update_success.jsp?id="+id);
              }
              else {
                  response.setContentType("text/html;charset=utf-8");
                  response.sendRedirect("/testManagement/question/update_failure.jsp?id="+id);
              }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
