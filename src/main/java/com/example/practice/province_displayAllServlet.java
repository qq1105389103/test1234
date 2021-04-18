package com.example.practice;

import com.example.practice.dao.province_select;
import com.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class province_displayAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          ArrayList<Province> plist= province_select.getProvinceAll(request);
          if(plist!=null&&plist.size()!=0) {
              String json = JSONUtil.provincestoJson(plist);
              response.setContentType("text/html;charset=utf-8");
              response.getWriter().println(json);
          }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
