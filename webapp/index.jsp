<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<iframe src="顶部空白页.html" style="position: absolute;top: 0px;height: 15%;width: 100%">

</iframe>
<br/>
<div style="position: absolute;right: 100px;top:100px;width: 150px;height: 150px;background-color: antiquewhite;opacity: 0.3">
  <img src="IMG_0074.PNG" width="150px">
</div>
<div style="position: absolute;right: 70px;top:150px;width: 150px;height: 150px;opacity: 1.1">
    <a href="userlogin_first.jsp"><font size="5px" color="#e9967a">用户登录</font></a><br>
    <a href="用户注册.html"><font size="5px"color="#e9967a">用户注册</font></a><br>
    <a href="查询用户信息.html"><font size="5px"color="#ff8c00">用户查询</font></a><br>
    <a href="用户注销.html"><font size="5px"color="#dc143c">用户注销</font></a>
</div>
<div style="position: absolute;right: 70px;top:300px;width: 150px;height: 150px;opacity: 1.1">
  <ul>
    <li><p id="user_menu">用户管理</P>
      <ul>
         <li><p id="login">用户登录</p></li>
         <li><p id="register">用户注册</p></li>
         <li><p id="search">用户查询</p></li>
         <li><p id="destroy">用户注销</p></li>
      </ul>
    </li>
  </ul>
</div>
<div>
<img src="IMG_0074.PNG"></img>
</div>
<iframe id='iframe1' name='iframe1'src="空白页.html" style="position: absolute;right:280px;top: 16%;width: 600px;height: 700px ">
</iframe>
<a href="用户注册.html" target="iframe1">测试target</a>
<a href="http://localhost:8080/testManagement/IMG_0006.JPG?age=17">测试Filter</a>
<script type="text/javascript">
  window.onload=function (){
      //设为顶级窗口
      if(window.top!=window.self)
      {
          window.top.location=window.self.location
      }
      //用户管理模块
        iframeelt=document.getElementById('iframe1');
      document.getElementById("login").onmouseover=function (){
          iframeelt.src='http://localhost:8080/testManagement/userlogin_first.jsp'
      }
       document.getElementById("register").onmouseover=function (){
           iframeelt.src='http://localhost:8080/testManagement/用户注册.html'
       }
    document.getElementById("search").onmouseover=function (){
      iframeelt.src='http://localhost:8080/testManagement/查询用户信息.html'
    }
    document.getElementById("destroy").onmouseover=function (){
      iframeelt.src='http://localhost:8080/testManagement/用户注销.html'
    }
    document.getElementById("user_menu").onmouseover=function (){
        iframeelt.src='http://localhost:8080/testManagement/空白页.html'
    }
    iframeelt.onblur=function (){
         iframeelt.src='空白页.html'
    }
    //用户管理模块
  }
</script>
<style type="text/css">
  p{
    cursor: pointer;
    font-size: 15px;
    color: crimson;
    background-image: url("http://localhost:8080/testManagement/IMG_0074.PNG");
  }
  #iframe1{
    border: 0px;
  }
  ul{
    list-style-type: none;
  }
</style>
</body>
</html>