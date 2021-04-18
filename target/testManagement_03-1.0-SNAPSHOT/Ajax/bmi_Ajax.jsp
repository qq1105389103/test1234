<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/11
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/testManagement/jQuery/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn1").on("click",function (){
                var height=$("#height").val()
                var weight=$("#weight").val()
                //点击按钮时实现Ajax局部刷新
                $.ajax({url:"/testManagement/practice/bmi_comleteByAjax",data:{"height":height,"weight":weight},
                    success:function (data){
                    alert(data)
                    $("#bmi_display").text(data)
                    }})
            })
        })
    </script>
</head>
<body style="background-image:url('http://localhost:8080/testManagement/IMG_0006.JPG');background-size: 100%;">
    <div>
     身高<input type="text" name="height" id="height"><br>
      体重<input type="text" name="weight" id="weight"><br>
        <input type="button" value="计算"  id="btn1">
        <div id="bmi_display">正在等待计算</div>
    </div>
</body>
</html>
