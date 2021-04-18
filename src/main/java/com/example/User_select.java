package com.example;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 连接数据库,根据User_find读取的用户名查询数据,查询到的数据存储在User类的数组列表中
 */
public class User_select {
    public static ArrayList<User> select(String username){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="select * from userinf where username=?";
        ArrayList<User> userlist=new ArrayList<>(5);
        try{
           conn=DBUtil.getConnection();
           pstmt=conn.prepareStatement(sql);
           pstmt.setString(1,username);
           rs=pstmt.executeQuery();
           while(rs.next()){
               int userid=rs.getInt("userid");
               String sex=rs.getString("sex");
               String email=rs.getString("email");
               userlist.add(new User(userid,username,null,sex,email));
           }
           if(userlist.size()!=0)
           return userlist;
           else return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn);
        }
    }
    public static ArrayList<User> select(String username, HttpServletRequest request){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="select * from userinf where username=?";
        ArrayList<User> userlist=new ArrayList<>(5);
        try{
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();
            while(rs.next()){
                int userid=rs.getInt("userid");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                userlist.add(new User(userid,username,null,sex,email));
            }
            if(userlist.size()!=0)
                return userlist;
            else return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
    public static ArrayList<User> selectALL(){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="select * from userinf ";
        ArrayList<User> userlist=new ArrayList<>(5);
        try{
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                String username=rs.getString("username");
                int userid=rs.getInt("userid");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                String password=rs.getString("password");
                userlist.add(new User(userid,username,password,sex,email));
            }
            if(userlist.size()!=0)
                return userlist;
            else return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn);
        }
    }
    public static ArrayList<User> selectALL(HttpServletRequest request){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="select * from userinf ";
        ArrayList<User> userlist=new ArrayList<>(5);
        try{
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                String username=rs.getString("username");
                int userid=rs.getInt("userid");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                String password=rs.getString("password");
                userlist.add(new User(userid,username,password,sex,email));
            }
            if(userlist.size()!=0)
                return userlist;
            else return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
}
