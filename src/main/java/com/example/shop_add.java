package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class shop_add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //读取用户信息
        Cookie[] cards = request.getCookies();
        String username = null;
        if(cards.length==0) {
            response.sendRedirect("/testManagement");
            return ;
        }
        for (Cookie e : cards) {
            if (e.getName().equals("username"))
                username = e.getValue();
        }
        if (username == null) {
            response.sendRedirect("/testManagement");
            return ;
        }
        //读取参数
        String goodsname = request.getParameter("goodsname");
        String price_String = request.getParameter("price");
        int price = Integer.parseInt(price_String);


        HttpSession session = request.getSession(false);

        if(session==null){
            response.sendRedirect("/testManagement");
            return ;
        }
        //第一次加入购物车时创建一个map
        if (session.getAttribute(username) == null) {
            HashMap<String, Integer> map = new HashMap<>();
            session.setAttribute(username, map);

        }
        //更新map
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute(username);
        map.putIfAbsent(goodsname + "-" + price, 0);
        map.put(goodsname + "-" + price, map.get(goodsname + "-" + price) + 1);
        System.out.println(map);
        session.setAttribute(username, map);
        //回到购物车
        response.sendRedirect("/testManagement/shop_return.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
