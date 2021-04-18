package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private int userid;
    private String username;
    private String password;
    private String sex;
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int userid, String username, String password, String sex, String email) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public User() {
    }

    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=com.util.DBUtil.getConnection();
            String sql="select * from userinf";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            com.util.DBUtil.close(rs,pstmt,conn);
        }
    }
}
