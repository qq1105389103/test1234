package com.example.question;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question_insert {
    public  static int add(Question question, HttpServletRequest request){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn=DBUtil.getConnection(request);
            String sql="insert into question (title,OptionA,OptionB,OptionC,OptionD,answer) values(?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,question.getTitle());
            pstmt.setString(2,question.getOptionA());
            pstmt.setString(3,question.getOptionB());
            pstmt.setString(4,question.getOptionC());
            pstmt.setString(5,question.getOptionD());
            pstmt.setString(6,question.getAnswer());


            int result=pstmt.executeUpdate();
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
