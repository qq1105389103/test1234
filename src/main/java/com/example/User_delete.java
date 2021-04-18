package com.example;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_delete {

    public static  int delete(User user) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String sql="delete from userinf where username=? and password=? and email=?";
        try {
            conn = DBUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getEmail());
            int result=pstmt.executeUpdate();
            System.out.println(result);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
           return 0;
        }
        finally {
            DBUtil.close(rs,pstmt,conn);
        }
    }
    public static  int delete(User user, HttpServletRequest request) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String sql="delete from userinf where username=? and password=? and email=?";
        try {
            conn = DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getEmail());
            int result=pstmt.executeUpdate();
            System.out.println(result);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
}
