package com.example;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_login_select {
    public static int login(String username,String password){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="select count(*) from userinf where username=? and password= ?";
        int result=0;
        try {
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            rs.next();
            if(rs.getInt("count(*)")==1)
            {
                result=1;
            }
            else
                result=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result=0;
        }
        finally {
            DBUtil.close(rs,pstmt,conn);
            System.out.println("result="+result);
        }
        return result;
    }
    public static int login(String username, String password, HttpServletRequest request){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="select count(*) from userinf where username=? and password= ?";
        int result=0;
        try {
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            rs.next();
            if(rs.getInt("count(*)")==1)
            {
                result=1;
            }
            else
                result=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result=0;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
            System.out.println("result="+result);
        }
        return result;
    }
}
