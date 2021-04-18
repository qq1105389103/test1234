package com.example.practice.dao;

import com.example.practice.City;
import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class city_select {
    public static ArrayList<City> getCity(HttpServletRequest request, int provinceid){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        ArrayList<City> clist=new ArrayList<>();
        String name=null;
        int id=0;
        String sql="select * from city where provinceid =?";
        try {
            conn= DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,provinceid);
           rs= pstmt.executeQuery();
           while (rs.next()){
             name=rs.getString("name");
             id=rs.getInt("id");
             clist.add(new City(provinceid,name,id));
           }
           return  clist;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
       finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
    public static City getCityById(HttpServletRequest request, int id){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String name=null;
        int provinceid=0;
        String sql="select * from city where id =?";
        try {
            conn= DBUtil.getConnection(request);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs= pstmt.executeQuery();
            if (rs.next()){
                name=rs.getString("name");
                id=rs.getInt("id");
                return  new City(provinceid,name,id);
            }
            else
                return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            DBUtil.close(rs,pstmt,conn,request);
        }
    }
}
