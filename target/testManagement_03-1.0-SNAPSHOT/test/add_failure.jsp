<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/8
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<script type="text/javascript">

        alert("添加失败,试题重复")

</script>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加试题</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0074.PNG');background-size: 100% ">
<center>
    <form action="http://localhost:8080/testManagement/question/add" method="get" id="form_add">
        <table border="2px">
            <tr>
                <td>题目名</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>选项A</td>
                <td><input type="text" name="OptionA"></td>
            </tr>
            <tr>
                <td>选项B</td>
                <td><input type="text" name="OptionB"></td>
            </tr>
            <tr>
                <td>选项C</td>
                <td><input type="text" name="OptionC"></td>
            </tr>
            <tr>
                <td>选项D</td>
                <td><input type="text" name="OptionD"></td>
            </tr>
            <tr>
                <td>答案</td>
                <td><input type="text" name="answer"></td>
            </tr>
            <tr align="center">
                <td colspan="3"><input type="button" value="提交" id="button"></td>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript">
    window.onload=function (){
        document.getElementById("button").onclick=function (){
            document.getElementById("form_add").submit();
        }
    }
</script>
</body>
</html>
