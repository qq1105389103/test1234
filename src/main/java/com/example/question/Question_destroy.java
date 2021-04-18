package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_destroy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
       int id=Integer.parseInt(request.getParameter("id"));
       int result=Question_delete.delete(id,request);
       if(result!=0)
       {
           response.setContentType("text/html;charset=utf-8");
           response.getWriter().println("<script type=text/javascript>alert('删除成功');window.history.back()</script>");
       }
       else
       {
           response.setContentType("text/html;charset=utf-8");
           response.getWriter().println("<script type=text/javascript>alert('删除失败,已删除');window.history.back()</script>");
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
