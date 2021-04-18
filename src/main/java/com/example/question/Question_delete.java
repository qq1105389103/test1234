package com.example.question;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question_delete {
    public static int  delete(int id, HttpServletRequest request){
        Connection conn=null;
        PreparedStatement pstmt=null;
        int result=0;
        String sql="delete from question where id=?";
        try {
            conn= DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            result=pstmt.executeUpdate();
            return  result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.close(null,pstmt, conn,request);
        }
    }
}
