package com.example.question;

import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question_select {
    public static List<Question> findAll(HttpServletRequest request){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from question";
        String title=null;
        String optionA=null;
        String optionB=null;
        String optionC=null;
        String optionD=null;
        String answer=null;
        int id=0;
        List<Question> list=new ArrayList<>();
        try {
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                id=rs.getInt("id");
                title=rs.getString("title");
                optionA=rs.getString("optiona");
                optionB=rs.getString("optionB");
                optionC=rs.getString("optionC");
                optionD=rs.getString("optionD");
               list.add(new Question(id,title,optionA,optionB,optionC,optionD,answer));
               System.out.println(optionA);
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
    public static List<Question> find(HttpServletRequest request,String title){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from question where title like ?";
        String optionA=null;
        String optionB=null;
        String optionC=null;
        String optionD=null;
        String answer=null;
        int id=0;
        List<Question> list=new ArrayList<>();
        try {
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"%"+title+"%");
            rs=pstmt.executeQuery();
            while(rs.next()){
                id=rs.getInt("id");
                title=rs.getString("title");
                optionA=rs.getString("optiona");
                optionB=rs.getString("optionB");
                optionC=rs.getString("optionC");
                optionD=rs.getString("optionD");
                list.add(new Question(id,title,optionA,optionB,optionC,optionD,answer));
                System.out.println(optionA);
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
    public static List<Question> findbyId(HttpServletRequest request,int id){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from question where id = ?";
        String optionA=null;
        String optionB=null;
        String optionC=null;
        String optionD=null;
        String title=null;
        String answer=null;
        List<Question> list=new ArrayList<>();
        try {
            conn=DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                id=rs.getInt("id");
                title=rs.getString("title");
                optionA=rs.getString("optiona");
                optionB=rs.getString("optionB");
                optionC=rs.getString("optionC");
                optionD=rs.getString("optionD");
                answer=rs.getString("answer");
                list.add(new Question(id,title,optionA,optionB,optionC,optionD,answer));

            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
    public static List<Question> findlimit(HttpServletRequest request,int limit){//随机加限制行数查询
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from question order by rand()limit ?";
        String sql2="select count(*) from question";
        String title=null;
        String optionA=null;
        String optionB=null;
        String optionC=null;
        String optionD=null;
        String answer=null;
        int id=0;
        List<Question> list=new ArrayList<>();
        try {
            conn=DBUtil.getConnection(request);
            //
            pstmt=conn.prepareStatement(sql2);
            rs=pstmt.executeQuery();
            if(rs.next()){
                System.out.println("总条数="+rs.getInt("count(*)"));
            }
            //
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,limit);
            rs=pstmt.executeQuery();
            while(rs.next()){
                id=rs.getInt("id");
                title=rs.getString("title");
                optionA=rs.getString("optiona");
                optionB=rs.getString("optionB");
                optionC=rs.getString("optionC");
                optionD=rs.getString("optionD");
                answer=rs.getString("answer");
                list.add(new Question(id,title,optionA,optionB,optionC,optionD,answer));
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
}
