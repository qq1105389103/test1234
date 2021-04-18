package com.example.practice;

import com.example.practice.dao.city_select;
import com.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class city_displayAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               int provinceid =Integer.parseInt(request.getParameter("id")) ;
                ArrayList<City> clist= city_select.getCity(request,provinceid);
                if(clist!=null&&clist.size()>0) {
                    String json = JSONUtil.citystoJson(clist);
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
