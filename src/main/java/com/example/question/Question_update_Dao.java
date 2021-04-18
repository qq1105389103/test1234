package com.example.question;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question_update_Dao {
    public static  int update(Question question, HttpServletRequest request){
        Connection conn=null;
        PreparedStatement pstmt=null;
        int result=0;
        String sql="update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where id=?";
        try {
            conn= DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(7,question.getId());
            pstmt.setString(1,question.getTitle());
            pstmt.setString(2,question.getOptionA());
            pstmt.setString(3,question.getOptionB());
            pstmt.setString(4,question.getOptionC());
            pstmt.setString(5,question.getOptionD());
            pstmt.setString(6,question.getAnswer());
            result=pstmt.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.close(null,pstmt,conn,request);
        }
    }
}
