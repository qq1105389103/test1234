<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  session="false" %>
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
<%
    HttpSession session=request.getSession(false);
    if(session==null)
    {
        response.sendRedirect("/testManagement");
        return;
    }
    String username=(String) session.getAttribute("username");
%>
<div style="position: absolute;right: 70px;top:150px;width: 150px;height: 150px;opacity: 1.1">
    <p id="namedisplay"><%=username%></p>
    <a href="用户注册.html"><font size="5px"color="#e9967a">用户注册</font></a><br>
    <a href="查询用户信息.html"><font size="5px"color="#ff8c00">用户查询</font></a><br>
    <a href="用户注销.html"><font size="5px"color="#dc143c">用户注销</font></a>
</div>
<div style="position: absolute;right: 70px;top:300px;width: 150px;height: 150px;opacity: 1.1">
    <ul>
        <li><p id="user_menu">用户管理</P>
            <ul>
                <li><p id="register">用户注册</p></li>
                <li><p id="search">用户查询</p></li>
                <li><p id="destroy">用户注销</p></li>
                <li><p id="shop">购物</p></li>
                <li><p id="shoplist">购物车</p></li>
                <li><p id="signout">退出登录</p></li>
            </ul>
        </li>
        <li id="test_list"><p id="test_manage">试题管理</p>
            <ul>
                <li><p  id="question_add">添加试题</p></li>
                <li><p  id="question_find">查询试题</p></li>
                <li><p  id="question_offer">出题</p></li>
                <li><p id="question_test>">参加测试</p></li>
            </ul>
        </li>
        <li> <p>其他应用</p>
            <ul>
                <li><p id="bmi_complete">计算bmi</p></li>
                <li><input type="text" name="id" id="province_id" maxlength="2"> </li>
                <li>
                    <select name="id" id="province_id2">
                        <option value=0>请选择省份</option>
                    </select>
                </li>
                <li><div id="province_display"></div></li>
                <li><div id="province_display2"></div></li>
                <li><div id="city_display" style="display: none">
                        <select name="id" id="city_id"></select>
                    </div>
                </li>
                <li><div id="city_display2" ></div></li>
            </ul>
        </li>
    </ul>
</div>
<div style="position: absolute;top: 15%;width: 51%">
    <img src="IMG_0006.JPG" width="100%"></img>
</div>
<iframe id='iframe1' name='iframe1'src="空白页.html" style="position: absolute;right:280px;top: 16%;width: 600px;height: 700px ">
</iframe>
<a href="用户注册.html" target="iframe1">测试target</a>
<script type="text/javascript" src="/testManagement/jQuery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="main.js"></script>

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