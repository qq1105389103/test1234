package com.example;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 用于连接数据库,将User_add读取的参数插入到数据库中
 */
public class User_insert {
    public User_insert(){ }
    public static int add(User user){
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="insert into userinf (username,password,sex,email) values(?,?,?,?)";
        try{
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3,user.getSex());
            pstmt.setString(4,user.getEmail());
            return pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.close(null,pstmt,conn);
        }

    }
    //重载的add,适用于预创建Connection
    public static int add(User user, HttpServletRequest request){
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="insert into userinf (username,password,sex,email) values(?,?,?,?)";
        try{
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3,user.getSex());
            pstmt.setString(4,user.getEmail());
            return pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.close(null,pstmt,conn,request);
        }

    }
}
