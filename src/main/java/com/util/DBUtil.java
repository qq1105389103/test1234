package com.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 一个JDBC工具类,用于简化JDBC编程六步,封装了JDBC编程繁琐步骤的代码
 * 封装了注册驱动,获取数据库连接对象,释放资源的代码
 */
public class DBUtil {
    private DBUtil() {}

    static {  //加载该类会注册驱动 ,静态代码块只执行一次   //类调用方法会加载类
        try {
            ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
            String driver=bundle.getString("driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{


        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        Connection conn = DriverManager.getConnection(url, user, password);
        if(conn!=null) {
            System.out.println("连接数据库成功");
            return conn;
        }
        else
        {
            System.out.println("连接数据库失败");
            throw new SQLException();

        }
    }
    //重载的getConnection,适用于预创建Connection
    public static Connection getConnection(HttpServletRequest request) throws SQLException{
 Connection conn=null;
        ServletContext application=request.getServletContext();
        Map map=(Map) application.getAttribute("conn");
        //通过迭代器取出键值,即Connection对象的引用
        Iterator it=map.keySet().iterator();
        //找空闲
        while(it.hasNext()){
             conn=(Connection) it.next();
             if((boolean)map.get(conn)==true)
                 break;
        }
        //是否无空闲
        if((boolean)map.get(conn)==false){
            System.out.println("没有空闲的数据库连接对象");
            throw new SQLException();
        }
        map.replace(conn,true,false);
        if(conn!=null) {
            System.out.println("连接数据库成功");
            return conn;
        }
        else
        {
            System.out.println("连接数据库失败");
            throw new SQLException();

        }
    }

    /**
     * 释放资源的代码整合
     * @param rs 结果集
     * @param stmt 数据库操作对象
     * @param conn 数据库连接对象
     */
    public  static void close(ResultSet rs, Statement stmt,Connection conn)
    {
        try{
            if(rs!=null)
                rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(stmt!=null)
                stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    //重载的close,适用于预创建Connection
    public  static void close(ResultSet rs, Statement stmt,Connection conn,HttpServletRequest request)
    {
        try{
            if(rs!=null)
                rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(stmt!=null)
                stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        ServletContext application=request.getServletContext();
        Map map=(Map) application.getAttribute("conn");
         map.put(conn,true);
    }

}
