package com.listener;

import com.util.DBUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class listener_conn_create implements ServletContextListener {
    @Override
    //Tomcat启动时预先创建20个Connection对象
    //执行User_add等操作时将connection交给他们
    public void contextInitialized(ServletContextEvent sce) {
        HashMap map=new HashMap<Connection,Boolean>();
             for(int i=0;i<=20;i++){
                 try {
                     Connection conn= DBUtil.getConnection();
                     System.out.println(conn+"被创建");
                     map.put(conn,true);
                     //塞到全局作用域对象中存储,便于共享
                     sce.getServletContext().setAttribute("conn",map);
                 } catch (SQLException throwables) {
                     throwables.printStackTrace();
                 }
             }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
             Map map=(Map) sce.getServletContext().getAttribute("conn");
            Iterator it=  map.keySet().iterator();
            while(it.hasNext()){
              Connection conn=(Connection) it.next();
              if(conn!=null){
                  try {
                      conn.close();
                      System.out.println(conn+"被销毁");
                  } catch (SQLException throwables) {
                      throwables.printStackTrace();
                  }
              }
            }
    }
}
