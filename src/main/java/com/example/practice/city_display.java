package com.example.practice;

import com.example.practice.dao.city_select;
import com.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class city_display extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id")) ;
       City city= city_select.getCityById(request,id);
        if(city!=null) {
            String json = JSONUtil.citytoJson(city);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
