package com.example.question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question_offer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int limit= Integer.parseInt(request.getParameter("limit"));
        List<Question> list= Question_select.findlimit(request,limit);
             request.setAttribute("findlimit",list);

             List<String> answerlist =new ArrayList<>();
             List<Integer> idlist=new ArrayList<>();
             //获取试题答案和id到列表
             for(Question q:list){
                 String answer=q.getAnswer();
                 answerlist.add(answer);
                 idlist.add(q.getId());
             }


             //存储答案列表,与id列表到session    //不严谨,应该存题目实体类到session
             HttpSession session=request.getSession(false);
             session.setAttribute("answerlist",answerlist);
             session.setAttribute("idlist",idlist);
             //展示题目
             request.getRequestDispatcher("/test/offer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
