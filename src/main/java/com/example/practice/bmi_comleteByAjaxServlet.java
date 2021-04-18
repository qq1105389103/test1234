package com.example.practice;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bmi_comleteByAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //正则表达式过滤不合规矩的数据
        Pattern pattern=Pattern.compile("(\\d)+(\\.\\d+)?"); //匹配正浮点数
        String weights=request.getParameter("weight");
        String heights=request.getParameter("height");
        Matcher mathcer=pattern.matcher(weights);
        if(!mathcer.matches())
            weights="";
        mathcer=pattern.matcher(heights);
        if(!mathcer.matches())
            heights="";


        if(heights!=""&&weights!="") {
            request.setCharacterEncoding("utf-8");
            Float weight = Float.valueOf(weights);
            Float height = Float.valueOf(heights);
            float bmi = 0;
            bmi = (float) (weight / Math.pow(height, 2));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("你的bmi是" + bmi);
            out.flush();
            out.close();
        }
        else
            response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("请输入正确的数据");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
