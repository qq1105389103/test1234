package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question_correct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                //题目数
        int number=Integer.parseInt(request.getParameter("number"));
        ArrayList<String> list=new ArrayList<>();
        //按顺序得到答案
                for(int i=1;i<=number;i++){
                    //取出作答的答案
                    String s=request.getParameter("option"+i);
                    list.add(s);
                   
                }
                HttpSession session=request.getSession(false);
                //拿到标准答案
               List<String> answerlist= (List<String>) session.getAttribute("answerlist");

               //放到数组中
               String [] lists=new String[number];
               list.toArray(lists);

               String [] answerlists=new String[number];
               answerlist.toArray(answerlists);


               //比较改分,存储每一题是否正确          //不严谨,严谨的应该是将题目所有信息(实体类)存到session,通过id判断用户提交的题目(请求参数name与id相关)
           ArrayList<Boolean>  result=new ArrayList<>();
           int point=0;
          for(int i=0;i<lists.length;i++){
              if(lists[i].equals(answerlists[i])){
                       result.add(true);
                       point+=15;
              }
              else{
                  result.add(false);
              }
          }
          //记录结果并展示
          request.setAttribute("result",result);
          request.setAttribute("point",point);

        //记录用户作答内容
        request.setAttribute("useranswer",lists);
      request.setAttribute("correcturl",request.getRequestURL().toString());//用户回答的url无参数部分
          request.getRequestDispatcher("/test/result.jsp").forward(request,response);


          //应该加一个将分数存入数据库

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
