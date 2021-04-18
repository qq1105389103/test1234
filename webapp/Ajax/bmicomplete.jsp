<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/11
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>全局刷新方式计算bmi</title>
</head>
<body>
    <form action="http://localhost:8080/testManagement/practice/bmi_complete" method="get">
         <table align="center">
            <tr>
                <td>请输入你的身高</td><td><input type="text" name="height" ></td>
            </tr>
            <tr>
            <td>体重</td><td><input type="text" name="weight"></td>
            </tr>
             <tr align="center">
                 <td colspan="2"><input type="submit" value="计算"></td>
             </tr>
        </table>
    </form>

</body>
</html>
