package com.example.practice;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class bmi_completeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Double height=Double.parseDouble(request.getParameter("height"));
            Double weight=Double.parseDouble(request.getParameter("weight"));
            double bmi=0.0;
            if(height!=null&&weight!=null) {
                bmi = weight / Math.pow(height, 2);
                DecimalFormat dc=new DecimalFormat("0.00");
                request.setAttribute("bmi", "你的bmi是"+dc.format(bmi));
                request.getRequestDispatcher("/Ajax/bmi_result.jsp").forward(request, response);
            }
            else
                request.setAttribute("bmi", "请正确输入身高和体重");
        request.getRequestDispatcher("/Ajax/bmi_result.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
