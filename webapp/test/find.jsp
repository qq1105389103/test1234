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
<head>
    <title>Title</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0085.JPG');background-size: 100% ">
    <center>
        <table>
            <tr>
                <td>题目id</td><td>标题</td><td>A选项</td><td>B选项</td><td>C选项</td><td>D选项</td>
            </tr>

   <%
       List<Question> list=(List<Question>) request.getAttribute("find");
       int i=0;
       if(list.size()!=0){
       for(Question q:list){

   %>
            <tr id="tr<%=i%>">
                <td><%=q.getId()%></td><td><%=q.getTitle()%></td><td><%=q.getOptionA()%></td><td><%=q.getOptionB()%></td><td><%=q.getOptionC()%></td><td><%=q.getOptionD()%></td>
                <td><a href="/testManagement/question/find?id=<%=q.getId()%>">查看详情</a></td> <!--url中有特殊符号,不方便用超链接-->
                <td><a href="/testManagement/question/delete?id=<%=q.getId()%>" class="delete" name="<%=i%>">删除</a></td>
            </tr>
   <%   i++;
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
        </table>
    </center>
<script type="text/javascript">
    window.onload=function (){
    var as= document.getElementsByClassName("delete");
     for(var i in as){
         as[i].onclick=function (){
            if(window.confirm('确定删除')) {

                return true;
            }
            else
                return  false;
         }
     }
    }
</script>
<style type="text/css">

</style>
</body>
</html>
