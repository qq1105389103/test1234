package com.example.practice;

import com.example.practice.dao.province_select;
import com.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class province_displayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        Province province= province_select.getProvince(id,request);
        response.setContentType("text/html;charset=utf-8");
        if(province!=null){
            String shenghui=province.getShenghui();
            String name=province.getName();
            PrintWriter out=response.getWriter();
            String json=JSONUtil.provincetoJson(province);
            out.println(json);
            out.flush();
            out.close();
        }
        else {
            response.getWriter().println(" ");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
