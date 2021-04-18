
window.onload=function (){
    //设为顶级窗口
    if(window.top!=window.self)
    {
        window.top.location=window.self.location
    }
    //用户管理模块
    iframeelt=document.getElementById('iframe1');
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
    document.getElementById("shop").onmouseover=function (){
        iframeelt.src="/testManagement/shop.html"
    }
    document.getElementById("shoplist").onmouseover=function (){
        iframeelt.src='/testManagement/shop_show'
    }
    document.getElementById("signout").onclick=function (){
        iframeelt.src='/testManagement/out'
    }
    iframeelt.onblur=function (e){
        iframeelt.src='空白页.html'
    }
    document.getElementById("question_add").onmouseover=function (){
        iframeelt.src='/testManagement/test/添加试题.html'
    }
    document.getElementById("question_find").onmouseover=function (){
        iframeelt.src='/testManagement/test/查询试题.html'
    }
    document.getElementById("question_offer").onmouseover=function (){
        iframeelt.src='/testManagement/test/出题.html'
    }
    document.getElementById("question_test>").onclick=function (){
        iframeelt.src='/testManagement/question/offer?limit=5'
    }

    document.getElementById("bmi_complete").onclick=function (){
        iframeelt.src="/testManagement/Ajax/bmi_Ajax.jsp"
    }
    $("#province_id:enabled").on("input",function (){
        const reg = /^[1-9][0-1]{0,1}$/g;
        var ok=reg.test($(this).val())
        if(ok){
            var id=$(this).val()
            $.ajax({
                url:"/testManagement/practice/province_display",
                data:{"id":id},
                dataType:"json", //如果返回的是json格式字符串,jQuery将自动转为json对象,传到data参数
                success:function (data){
                    $("#province_display").text(data.name)
                    $("#province_display2").text(data.shenghui)
                }
            })
        }
    })
    $("#province_id").on("blur",function (){
        $("#province_display").hide("slow")
        $("#province_display2").hide("fast")
    })
    $("#province_id").on("focus",function (){
        $("#province_display").show("fast")
        $("#province_display2").show("slow")
    })



    /*
    以下是实现级联刷新的
     */

      $(function (){//页面加载完成时,完成下拉表单中数据的读取
          readProvince=function (){
          $.get({
              url: "/testManagement/practice/province_displayAll",
              data: {},
              dataType: "json",
              success: function (data) {   //此时data应该是一个json数组
                  $.each(data, function (i, e) {
                      $("#province_id2").append("<option value='+" + e.id + "'>" + e.name + "</option>")
                  })
              }
          })}
          readProvince()
      })
    //选择省份时,显示对应省份所属城市的下拉列表
    $("#province_id2").on("change",function (){
        $("#city_dipslay").hide("fast")
        $("#city_id").empty(); //每次选择先清空城市列表和城市信息
        $("#city_display2").empty();
        $.get({
            url:"/testManagement/practice/city_displayAll",
            data:{"id":$(this).val()},//省份id作为参数
            dataType:"json",
            success:function (data){
                 $("#city_id").append("<option value=0>请选择城市</option>") //遍历前添加默认值
                    $.each(data, function (i, e) {
                        $("#city_id").append("<option value='"+e.id+"'>" + e.name + "</option>")
                    })
                     $("#city_display").show("fast")

            },
            error:error
        })
    })

    //选择城市时,显示城市详细信息
    $("#city_id").on("change",function (){
        $("#city_display2").empty();
             $.get({
                 url:"/testManagement/practice/city_display",
                 data:{"id":$(this).val()},
                 dataType:"json",
                 success:function (resp){
                     $("#city_display2").append("城市名:"+resp.name+",城市id:"+resp.id)
                 }

             })
    })

    function error(){
        $("#city_id").append("<option>数据库中无数据</option>")

    }

    /*document.getElementById("province_id").oninput=function (){ //输入id时执行局部更新
        var reg=/^[1-9][0-1]{0,1}$/g
        var ok;
         ok=reg.test(this.value)
        if(ok) {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange=function (){
                if(xmlHttp.readyState==4&&xmlHttp.status==200){
                    var data=this.responseText;
                    var jsonobj=eval('('+data+')')
                  //更新页面,可封装到一个函数中
                    document.getElementById("province_display").innerText=jsonobj.name;
                    document.getElementById("province_display2").innerText=jsonobj.shenghui;
                }
            }
            var id=this.value;
            xmlHttp.open("get","/testManagement/practice/province_display?id="+id,true)
            xmlHttp.send()
        }
    }*/
    //用户管理模块
    //js通过cookie读取用户名
    /*var card=document.cookie  //获得一串cookie对象,以;分割每个对象
    var cards=card.split(/;/g) //拆分cookie对象为 name=value
    var username=''
    for(var i=0;i<cards.length;i++){
        if(cards[i].indexOf("username")>=0) {    //搜索name=username
            var j = cards[i].indexOf("=")
            username = cards[i].substr(j + 1)      //获取username的值
        }

    }
    if(username!='')
    document.getElementById("namedisplay").innerHTML="<font size=3px color=black>Hello! "+username+"</font>"
    */

}
