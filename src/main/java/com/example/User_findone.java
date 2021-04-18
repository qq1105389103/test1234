package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class User_findone extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        ArrayList<User> userlist=User_select.select(username,request);


        /*
         * 输出表格
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html><body style='background: url(http://localhost:8080/testManagement/IMG_0085.JPG);background-size: 100%'>");
        out.println("<table border='2px' align='center'>");
        out.println("<thead>");
        out.println("<tr><th>id</th><th>用户名</th><th>性别</th><th>邮箱</th><th>操作</th></tr>");
        out.println("</thead>");
        out.println("<tbody id='tbody'>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("<script type='text/javascript'>");
        int i=1;
        if(userlist!=null) {
            StringBuilder html = new StringBuilder();
            for (User e : userlist) {
                html.append("<tr>");
                html.append("<td>");
                html.append(e.getUserid());
                html.append("</td>");
                html.append("<td>");
                html.append(e.getUsername());
                html.append("</td>");
                html.append("<td>");
                html.append(e.getSex());
                html.append("</td>");
                html.append("<td>");
                html.append(e.getEmail());
                html.append("</td>");
                html.append("<td><a href=http://localhost:8080/testManagement/User/Server/delete?username=" +e.getUsername()
                        +"&password="+e.getPassword()+"&email="+e.getEmail()  +" id=a"+i+"> 删除 </a></td>");
                html.append("</tr>");
                i++;
            }
            out.println("document.getElementById('tbody').innerHTML=" + "'"+html.toString()+"'");
            System.out.println("查找到"+userlist.size()+"个数据");
        }
        else{
            out.println("document.getElementById('tbody').innerHTML='<tr align=center><td colspan=5>未查找到该用户</td></tr>'");
            System.out.println("未查找到数据");
        }
        for(int j = 1; j<i; j++) {
            out.println("var elt=document.getElementById('a" + j + "').onclick=function(){" +
                    "ok=confirm('确定删除?');if(!ok)return false;}");
        }
        out.println("</script>");
        out.println("<link rel='stylesheet' type='text/css' href='http://localhost:8080/testManagement/a_delete.css'");
        out.println("<body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
