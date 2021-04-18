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
<head><!--出题-->
    <title>Title</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0085.JPG');background-size: 100% ">
<center>
    <form action="http://localhost:8080/testManagement/question/correct" method="get">


                <%
            List<Question> list=(List<Question>) request.getAttribute("findlimit");//取出从数据库伪随机拿的题目
                    int i=1;
            if(list.size()!=0){
                for(Question q:list){

        %><table align="center" >
            <tr>
                <td><input type="hidden" name="id" value="<%=q.getId()%>" readonly></td>
            </tr>

            <tr align="center">
                <td colspan="3">题目<%=i%></td><td><%=q.getTitle()%></td>
            </tr>
            <tr>
                <td>A:</td><td colspan="2" align="center"><%=q.getOptionA()%></td><td align="right"><input type="radio" name="option<%=i%>" value="A" class="option" checked></td>
            </tr>
            <tr>
                <td>B:</td><td colspan="2" align="center"><%=q.getOptionB()%></td><td align="right"><input type="radio" name="option<%=i%>" value="B" class="option"></td>
            </tr>
            <tr>
                <td>C:</td><td colspan="2" align="center"><%=q.getOptionC()%></td><td align="right"><input type="radio" name="option<%=i%>" value="C" class="option"></td>
            </tr>
            <tr>
                <td>D:</td><td colspan="2" align="center"><%=q.getOptionD()%></td><td align="right"><input type="radio" name="option<%=i%>" value="D" class="option"></td>
            </tr>
        </table>

                <%i++;
            }
        }
        else{
        %><table>
            <tr align="center">
                <td colspan="6"><p>未查找到题目<p></td>
            </tr>
          </table>
                <%
            }
        %><table>
                    <tr>
                        <td><a href="javascript:void(0)" id="back" onclick="window.history.back()">返回</a></td>
                        <td><input type="submit" value="交卷"></td>
                        <td><input type="hidden" name="number" value="<%=i-1%>" readonly></td>
                    </tr>
        </table>
    </form>

</center>
<script type="text/javascript">

</script>
<style type="text/css">


</style>
</body>
</html>
