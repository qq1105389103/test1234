<%@ page import="java.util.List" %>
<%@ page import="com.example.question.Question" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/8
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head><!--根据id查找显示的题目详细信息,可更新题目-->
    <title>Title</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0085.JPG');background-size: 100% ">
<center>
  <form action="http://localhost:8080/testManagement/question/update" method="get">
    <table align="center">

        <%
            List<Question> list=(List<Question>) request.getAttribute("find");
            if(list.size()!=0){
                for(Question q:list){

        %>
        <tr>
            <td><input type="hidden" name="id" value="<%=q.getId()%>" readonly></td>
        </tr>

        <tr>
            <td>题目</td><td><input type="text" name="title" value="<%=q.getTitle()%>"></td>
        </tr>
        <tr>
            <td>A:</td><td><input type="text" name="optionA" value="<%=q.getOptionA()%>"></td>
        </tr>
        <tr>
            <td>B:</td><td><input type="text" name="optionB" value="<%=q.getOptionB()%>"></td>
        </tr>
        <tr>
            <td>C:</td><td><input type="text" name="optionC" value="<%=q.getOptionC()%>"></td>
        </tr>
        <tr>
            <td>D:</td><td><input type="text" name="optionD" value="<%=q.getOptionD()%>"></td>
        </tr>
        <tr>
            <td>answer:</td><td><input type="text" name="answer" value="<%=q.getAnswer()%>" maxlength="1" id="answer"></td>
        </tr>
        <tr>
            <td><a href="javascript:void(0)" id="back" onclick="window.history.back()">返回</a></td>
            <td><input type="submit" value="更新"></td>
        </tr>
        <%
            }
        }
        else{
        %>
        <tr align="center">
            <td colspan="6"><p>未查找到题目<p></td>
        </tr>
        <%
            }
        %>
  </form>
    </table>
</center>
<script type="text/javascript">
    document.getElementById("answer").oninput=function (){
        var reg=/[^(A-D)|(a-d)]/g
        this.value=this.value.replace(reg,"")
        this.value=this.value.toUpperCase()
    }
</script>
<style type="text/css">


</style>
</body>
</html>
