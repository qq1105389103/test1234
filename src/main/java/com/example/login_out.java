package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
 //用户注销,销毁所有cookie
public class login_out extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置Cookie寿命为1s,杀死
        Cookie[]cards=request.getCookies(); //读取该网站下所有cookie
        for(int i=0;i<cards.length;i++)
        {
            cards[i].setMaxAge(0);
            response.addCookie(cards[i]);
        }

        response.sendRedirect("/testManagement");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
