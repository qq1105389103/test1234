package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class filter_test implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
          String age= servletRequest.getParameter("age");
          int i=0;
          if((i=Integer.parseInt(age))>=18)
              filterChain.doFilter(servletRequest,servletResponse);
          else
          { servletResponse.setContentType("text/html;charset=utf-8");
              PrintWriter out=servletResponse.getWriter();
                 out.println("<html><body>");
              out.println("<script type='text/javascript'>alert('再等"+(18-i)+"年再来吧')");
              out.println("document.location='/testManagement'</script>");
              out.println("</html></body>");

          }
    }
}
