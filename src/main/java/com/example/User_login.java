package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class User_login extends HttpServlet {
    public User_login(String a,Integer b){

    }
    public User_login(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 request.setCharacterEncoding("utf-8");
                String username= request.getParameter("username");
                String password=request.getParameter("password");

                int result=User_login_select.login(username,password,request);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String url1="http://localhost:8080/testManagement/main.jsp";
                if(result==1) {
                    Cookie card=new Cookie("username",username);
                    Cookie card1=new Cookie("password",password);
                    response.addCookie(card);
                    response.addCookie(card1);
                    HttpSession session=request.getSession();
                     session.setAttribute("username",username);
                     session.setAttribute("password",password);
                    response.sendRedirect(url1);


                }
                else
                    response.sendRedirect("http://localhost:8080/testManagement/userlogin.html");


    }
}
