package com.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


/**用户注册Servlet程序
 * 读取请求参数存入User对象并调用User_insert方法将用户信息插入数据库
 */
@WebServlet("/User/add") //使用注解创建别名
public class User_add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           Class a= Class.forName("123");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date start=new Date();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");
        User user=new User(0,username,password,sex,email);
        int result=User_insert.add(user,request);
            if(result!=0) {
                System.out.println("注册成功");
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<script type=text/javascript>window.alert('注册成功');document.location.href='http://localhost:8080/testManagement/空白页.html'</script>");
                out.println("</html></body>");

            }
        if(result==0) {
            System.out.println("注册失败,用户名重复");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<script type=text/javascript>window.alert('注册失败,用户名重复');document.location.href='http://localhost:8080/testManagement/空白页.html'</script>");
            out.println("</html></body>");

        }
        Date end=new Date();
        System.out.println(end.getTime()-start.getTime());
        }

    }

