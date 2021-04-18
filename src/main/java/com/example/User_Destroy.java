package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class User_Destroy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");

        int result=User_delete.delete(new User(0,username,password,null,email));

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<script type='text/javascript'>");
        if(result!=0){
            out.println("alert('删除成功')");
            out.println("document.location.href='http://localhost:8080/testManagement//User/Server/findAll'");
        }
        else {
            out.println("alert('删除失败,账号信息不匹配')");
            out.println("document.location.href='http://www.baidu.com'");
        }
        out.println("</script>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           String email=request.getParameter("email");

           int result=User_delete.delete(new User(0,username,password,null,email),request);

           response.setContentType("text/html;charset=utf-8");
           PrintWriter out=response.getWriter();
           out.println("<html><body>");
           out.println("<script type='text/javascript'>");
           if(result!=0){
               out.println("alert('删除成功')");
               out.println("document.location.href='http://localhost:8080/testManagement/findAll'");
           }
           else {
               out.println("alert('删除失败,账号信息不匹配')");
               out.println("document.location.href='http://www.baidu.com'");
           }
           out.println("</script>");
           out.println("</body></html>");
    }
}
