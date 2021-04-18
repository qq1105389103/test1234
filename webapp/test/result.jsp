<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/9
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background: url('http://localhost:8080/testManagement/IMG_0085.JPG');background-size: 100% ">
    <table align="center">
<%      //记录当前页面url
             String url=(String) request.getAttribute("correcturl");
             if(request.getQueryString()!=null)   //获取?后面的所有参数字符串
              url+="?"+request.getQueryString();   //拼接成完整url!
          request.getSession(false).setAttribute("firsturl",url);//url存入session


       List<Boolean> list=(List<Boolean>) request.getAttribute("result");//每一题是否正确
       List<Integer> idlist= (List<Integer>) request.getSession(false).getAttribute("idlist");//每一题编号
       String [] useranswer=(String[]) request.getAttribute("useranswer");//用户的回答
    ArrayList<String> urls=new ArrayList<>();//一个存储超链接的数组
       //转成数组,两个一起遍历
       Boolean [] lists=new Boolean[list.size()];
       list.toArray(lists);
       Integer [] idlists=new Integer[idlist.size()];
       idlist.toArray(idlists);

       if(list.size()!=0&&idlist.size()!=0){
      for(int i=0;i<lists.length;i++){ //此处可改进,点击第一题显示题目内容 那得得到题目的id 应该加一个find_readonly方法,不与更新绑定
%>
      <tr>
          <td><a href="/testManagement/question/find_readonly?id=<%=idlists[i]%>&useranswer=<%=useranswer[i]%>&correct=<%=lists[i]%>&number=<%=i+1%>" class="a">第<%=i+1%>题</a></td><td <%=lists[i]==false?"style='color: crimson'":"+"%>><%=lists[i]==true?"正确":"错误"%></td>
          <td>你的答案: <%=useranswer[i]%></td>
      </tr>
<%urls.add("/testManagement/question/find_readonly?id="+idlists[i]+"&useranswer="+useranswer[i]+"&correct="+lists[i]+"&number="+(i+1));
    }  request.getSession(false).setAttribute("urls",urls); //用户所有题作答详情的展示
       }else{

%>
        <tr>
            <td>未作答</td>
        </tr>
<%
    }
%>

    </table>
    <P style="font-size: 22px;color: crimson">你的分数:${point}</P>
</body>
<script type="text/javascript">

</script>
<style type="text/css">
    td{
        font-size: 16px;
        color: black;
    }
</style>
</html>
