package com.example;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class shop_show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session==null){
            response.sendRedirect("/testManagement");
            return;
        }
        request.setCharacterEncoding("utf-8");
        Cookie[] cards = request.getCookies();
        //无用户登录cookie则返回登录页面
        String username = null;
        for (Cookie e : cards) {
            if (e.getName().equals("username"))
                username = e.getValue();
        }
        //未登录则返回登录页面
        if (username == null) {
            response.sendRedirect("/testManagement");
            return;
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<link rel=stylesheet type=text/css href='http://localhost:8080/testManagement/bodycss.css'>");
        out.println("<table border=2px align=center>");
        out.println("<tr>");
        out.println("<td>商品名</td><td>价格</td><td>数量</td><td>总价</td>");
        out.println("</tr>");
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute(username);
        if(map==null) {
            response.sendRedirect("/testManagement/shop.html");
            return;
        }
        map.forEach((String s, Integer v) -> {

            out.println("<tr>");
            out.println("<td>" + s.split("[-]")[0] + "</td>");//商品名
            out.println("<td>" + s.split("[-]")[1] + "</td>");//价格
            out.println("<td>" + v + "</td>");
            out.println("<td class='total'>"+Integer.parseInt(s.split("[-]")[1])*v+"</td>");//总价
            out.println("</tr>");
        });
        out.println("<tr align=center>");
        out.println("<td colspan=3><input type=button value=结算 id='button'></td>");
        out.println("<td id=totalprice></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<script type=text/javascript>");
        out.println("var totalarray=document.getElementsByClassName('total')");
        out.println("var sum=0");
        out.println("for(var i=0;i<totalarray.length;i++)");
        out.println("{sum+=(parseInt(totalarray[i].innerText))}");
        out.println("document.getElementById('totalprice').innerHTML=sum");
        out.println("</script>");
        out.println("</html></body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
