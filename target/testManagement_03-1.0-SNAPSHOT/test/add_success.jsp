<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/8
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0074.PNG');background-size: 100% ">
 <script type="text/javascript">
     window.onload=function (){
         alert("添加成功")


<%
    if(request.getSession(false)==null){
%>
     document.location="http://localhost:8080/testManagement/"
<%
    }
    else{
%>
     document.location="http://localhost:8080/testManagement/test/添加试题.html"
<%
    }
%>
     }
 </script>
</body>
</html>
