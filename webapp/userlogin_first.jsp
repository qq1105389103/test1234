<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/9
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html lang="en">
<%
    if(request.getSession(false)!=null)
        response.sendRedirect("/testManagement/main.jsp");
%>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0085.JPG');background-size: 100% ">
<form action="http://localhost:8080/testManagement/login" method="post" id="form_login">
    <table border="2px" align="center">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="button" value="登录" id="button"></td>
        </tr>
    </table>
</form>
<script>
    window.onload=function (){
        var buttonelt=document.getElementById("button")
        buttonelt.onclick=function (){
            document.getElementById("form_login").submit();
        }
        document.getElementById("password").onkeydown=function(e){
            if(e.keyCode==13)
                buttonelt.click();
        }
    }
</script>
</body>
</html>
