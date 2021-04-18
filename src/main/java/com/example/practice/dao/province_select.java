package com.example.practice.dao;

import com.example.practice.Province;
import com.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class province_select {
  public static Province getProvince(int id, HttpServletRequest request)
  {
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String name=null;
      String shenghui=null;
      String jiancheng=null;
      String sql="select * from province where id=? ";
      try {
          conn=DBUtil.getConnection(request);
          pstmt=conn.prepareStatement(sql);
          pstmt.setInt(1,id);
          rs=pstmt.executeQuery();
          if(rs.next())
          {   id=rs.getInt("id");
              name=rs.getString("name");
               jiancheng=rs.getString("jiancheng");
               shenghui=rs.getString("shenghui");
              return  new Province(id,name,jiancheng,shenghui);
          }
      } catch (SQLException throwables) {
          throwables.printStackTrace();
          return null;
      }
      finally {
          DBUtil.close(rs,pstmt,conn,request);
      }
      return  null;
  }
  public static ArrayList<Province> getProvinceAll(HttpServletRequest request){
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String name=null;
      String shenghui=null;
      String jiancheng=null;

      int id=0;
      ArrayList<Province> plist=new ArrayList<>();
      String sql="select * from province";
      try {
         conn= DBUtil.getConnection(request);
         pstmt=conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
         while(rs.next()){
             id=rs.getInt("id");
             name=rs.getString("name");
             shenghui=rs.getString("shenghui");
             jiancheng=rs.getString("jiancheng");
             plist.add(new Province(id,name,jiancheng,shenghui));
         }
         return plist;
      } catch (SQLException throwables) {
          throwables.printStackTrace();
          return  null;
      }
      finally {
          DBUtil.close(rs,pstmt,conn,request);
      }
  }
}
