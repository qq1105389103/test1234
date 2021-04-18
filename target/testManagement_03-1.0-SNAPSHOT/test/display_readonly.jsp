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
<body style="background: url('http://localhost:8080/testManagement/IMG_0085.JPG');background-size: 100%; ">
<center>
<<%
       String firsturl=(String) request.getSession(false).getAttribute("firsturl"); //取出用户答题的首页url
%>

        <%                                                                                      //useranswer-用户该题的回答
            List<Question> list=(List<Question>) request.getAttribute("find"); //题目信息与答案      //correct-用户该题的回答正确还是错误
                List<String>   url =(List<String>)  request.getSession(false).getAttribute("urls");//获取题目信息的url,生成下一题按钮
                 int nextNumber=Integer.parseInt((String)request.getAttribute("number"))+1 ;
                 int lastNumber=Integer.parseInt((String)request.getAttribute("number"))-1;
                 String nexturl="javascript:void(0)";
                 String lasturl="javascript:void(0)";
            for(String s:url){
                if(s.contains("number="+lastNumber)){
                    lasturl=s;
                }
                if(s.contains("number="+nextNumber)) {
                    nexturl = s;
                    break;
                }
            }

            int i=1;
            if(list.size()!=0){
                for(Question q:list){

        %><table align="center" >


        <tr align="center">
            <td colspan="3">题目${number}</td><td><%=q.getTitle()%></td>
        </tr>
        <tr ${"A"eq useranswer &&!correct? "style='color: crimson'":""}>
            <td <%=q.getAnswer().equals("A")?"style='color: cadetblue'":""%>>A:</td><td colspan="2" align="center"><%=q.getOptionA()%></td><td align="right"><input type="radio" name="option<%=i%>" value="A" class="option" <%=q.getAnswer().equals("A")?"checked":""%> ></td>
        </tr>
        <tr ${"B"eq useranswer &&!correct? "style='color: crimson'":""}>
            <td <%=q.getAnswer().equals("B")?"style='color: cadetblue'":""%>>B:</td><td colspan="2" align="center"><%=q.getOptionB()%></td><td align="right"><input type="radio" name="option<%=i%>" value="B" class="option" <%=q.getAnswer().equals("B")?"checked":""%>></td>
        </tr>
        <tr ${"C"eq useranswer&&!correct? "style='color: crimson'":""}>
            <td <%=q.getAnswer().equals("C")?"style='color: cadetblue'":""%>>C:</td><td colspan="2" align="center"><%=q.getOptionC()%></td><td align="right"><input type="radio" name="option<%=i%>" value="C" class="option" <%=q.getAnswer().equals("C")?"checked":""%>></td>
        </tr >
        <tr ${"D"eq useranswer&&!correct? "style='color: crimson'":""}>
            <td <%=q.getAnswer().equals("D")?"style='color: cadetblue'":""%>>D:</td><td colspan="2" align="center"><%=q.getOptionD()%></td><td align="right"><input type="radio" name="option<%=i%>" value="D" class="option" <%=q.getAnswer().equals("D")?"checked":""%>></td>
        </tr>
        <tr>
            <td style="color: cadetblue">答案</td><td colspan="2" align="center"><%=q.getAnswer()%></td><td align="right"></td>
        </tr>
         <tr>
            <td>你的选择</td><td colspan="2" align="center">${useranswer}</td><td align="right"></td>
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
            <td><a href="<%=firsturl%>" id="back" >返回</a></td>
        </tr>
        <tr>
            <td><a href="<%=lasturl%>" id="lasturl">上一题</a></td>
        </tr>
        <tr>
            <td><a href="<%=nexturl%>" id="nexturl">下一题</a></td>
        </tr>
    </table>


</center>
<script type="text/javascript">
    window.onload=function () {
        var a_lastelt=document.getElementById("lasturl")
         a_lastelt.onclick=function (){
             if(a_lastelt.href==="javascript:void(0)")
                 alert("已经是最后一题了")
         }
        var a_nextelt = document.getElementById("nexturl")
         a_nextelt.onclick = function () {
             if(this.href==="javascript:void(0)")
                 alert("已经是最后一题了")
         }
    }
</script>
<style type="text/css">
         d

</style>
</body>
</html>
