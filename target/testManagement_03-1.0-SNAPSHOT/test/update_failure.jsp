<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/9
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    int id= Integer.parseInt(request.getParameter("id"));
%>
<body>
<script type="text/javascript">
    if(confirm('更新失败,是否继续更新?'))
        document.location="http://localhost:8080/testManagement/question/find?id=<%=id%>>"
    else
        document.location="http://localhost:8080/testManagement/test/查询试题.html"
</script>
</body>
</html>
