package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class login_check implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if(request.getRequestURI().contains("/login")||request.getRequestURI().equals("/testManagement/")) {
            filterChain.doFilter(request, response);
            return;
        }
           HttpSession session= request.getSession(false);
            if(session==null){
                response.sendRedirect("/testManagement");
                return ;
            }
            filterChain.doFilter(request,response);
        }
    }

