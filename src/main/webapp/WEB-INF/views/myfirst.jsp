<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
	<link rel="stylesheet" href="../my.css">
    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!--<meta http-equiv="Access-Control-Allow-Origin" content="http://39.108.233.120:8080/android/doAppLogin" />-->
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <!--Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="msapplication-TileColor" content="#e1652f">
    <!--<meta name="Access-Control-Allow-Origin" content="*" />-->


 
    <script src="http://cdn.static.runoob.com/libs/jquery/1.8.3/jquery.js"></script>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
 
    <script>
        $(document).ready(function () {//当 DOM（文档对象模型） 已经加载，并且页面（包括图像）已经完全呈现时，会发生 ready 事件。
            $("#mybutton").click(function () {
//                $.post("http://127.0.0.1:8080/market/register",//可以获取
//                    {
//                        username: "455454",
//                        password: "123456",
//                    },
//                    function (data, status) {
//                        alert("数据: \n" + data.response + "\n状态: " + status);
//                    },
//                    "json");
//                var myjson = {
//                    password: "123456",
//                    username: "sulc",
//                };
//                alert(JSON.stringify(myjson)); 对象编程json   pars 是讲json编程js对象
//                $.getJSON("http://127.0.0.1:8080/market/register",//可以获取
//                    myjson,
//                    function (result, status, xhr) {
//                        alert("数据: \n" + result + "\n状态: " + status + "   ----xhr=" + xhr);
//                        $.each(result, function (i, field) {
//
//                        });
//                    });
                var myjson = {password: "123456", username:"sulc"};
                //alert(getpath(false)),
                $.ajax({
                    url: "http://127.0.0.1:8081/NihaoController/nihao",  //可以获取
                   
                    data : myjson,
               
                   contentType: "application/json; charset=utf-8",//(可以)
                    success: function (data, status) {
                        //alert(JSON.stringify(data));
                        alert(data.age);
                        //alert("数据: \n" + data + "\n状态: " + status);
                    },
                    error: function (data,xhr) {
                        alert("错误提示： " + data.status + " " + xhr.statusText+"---xhr"+xhr.statusText);
                    },
//                    headers:{
//                        "Access-Control-Allow-Origin"
//                    },
                    beforeSend:function (xhr) {
                        //alert("请求之前");
                        //xhr.addheader("Access-Control-Allow-Origin","*");
                       // Access-Control-Request-Headers:access-control-allow-origin
                    }
                });

            });
        });
        //                    $(document).ready(function(){
        //                        $("#mybutton").click(function(){
        //                            alert("请求！");
        //                            $.http.jsonp("http://39.108.233.120:8080/android/doAppLogin",
        //                                {password:"123456",
        //                                    username:"sulc",
        //                              }
        //                            ,function(data,status){
        //                                alert("数据: \n" + data + "\n状态: " + status);
        //                            });
        //                        });https://www.baidu.com/s?ie=UTF-8&wd=nihao
        //                    });

        //response.setHeader("Access-Control-Allow-Origin", "*"); 需要在服务器加。
        //        $(document).ready(function () {
        //            $("#mybutton").click(function () {
        //                alert("请求！");
        //
        //            });
        //        });


        //                $(document).ready(function(){
        //                    $("#mybutton").click(function () {
        //                        $.getJSON("http://39.108.233.120:8080/android/doAppLogin",
        //                            {
        //                                password: "123456",
        //                                username: "sulc",
        //                            },
        //                            function(result){
        //                            $.each(result, function(i, field){
        //                                $("div").append(field + " ");
        //                            });
        //                        });
        //                    });
        //                });
    </script>

    <script type="text/javascript">
        function imgPreview(fileDom) {
            //判断是否支持FileReader
            if (window.FileReader) {
                var reader = new FileReader();
            } else {
                alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
            }

            //获取文件
            var file = fileDom.files[0];
            var imageType = /^image\//;
            //是否是图片
            if (!imageType.test(file.type)) {
                alert("请选择图片！");
                return;
            }
            //读取完成
            reader.onload = function (e) {
                //获取图片dom
                //var img = document.getElementById("preview");
                $("#preview").attr("src",e.target.result);
                //图片路径设置为读取的图片
                //img.src = e.target.result;
            };
            reader.readAsDataURL(file);
        }
    </script>
    <script>
        var option = {
            url: "http://127.0.0.1:8080/market/register",//默认是form action  //能发送成功，后台获取不到
            type: "POST",
            // dataType : 'json',
            //headers : {"ClientCallMode" : "ajax"}, //添加请求头部
            clearForm: false,
            resetForm: false,
            success: function (data, stat) {
                alert('状态: ' + stat + '\n 返回的内容是: \n' + data);
            },
        };
        function mylogin() {
            $("#myform").ajaxSubmit(option);
            return false;
        }
        function mylogintwo() {//能发送成功，后台能获取http://127.0.0.1:8081/student
            $.ajax({
                type: 'post',
                url: 'http://127.0.0.1:8081/student/form',
                data: $("#myform").serialize(),
                cache: false,
                dataType: 'json',
                success: function (data) {
                    alert("请求成功");
                },
            });
        }
        function myloginthree() {//能发送成功，后台获取成功。
//            var fd = new FormData(document.getElementById("myform"));
           var fd = new FormData($("#myform")[0]);
//var fd = new FormData($("#myformid"));
            $.ajax({
                url: "http://127.0.0.1:8081/student/form",
                type: "POST",
                data: fd,
                processData: false,  // 告诉jQuery不要去处理发送的数据
                contentType: false,  // 告诉jQuery不要去设置Content-Type请求头
                success: function (msg) {
                    alert("Data Saved: " + msg);
                },
            });
        }
        //        function mylogin(){
        //            alert("登陆了");
        //            var form = new FormData(document.getElementById("myform"));
        ////             var req = new XMLHttpRequest();
        ////             req.open("post", "${pageContext.request.contextPath}/public/testupload", false);
        ////             req.send(form);
        //            $.ajax({
        //                url:"http://39.108.233.120:8080/android/doAppLogin",
        //                type:"post",
        //                data:form,
        //                processData:false,
        //                contentType:false,
        //                success:function(data){
        //                    //window.clearInterval(timer);
        //                    console.log("over..");
        //                },
        //                error:function(e){
        //                    alert("错误！！");
        //                    //window.clearInterval(timer);
        //                }
        //            });
        //           // get();//此处为上传文件的进度条
        //        }
    </script>
    <style>
        #textcontent {
        }
    </style>

    <style>
        #photoqw h3{
            text-align: center;
        }
    </style>
    <script>
        $(function () {
            after:function after() {

            }
        });
    </script>
    <!--<script type="text/javascript">-无效->
        <!--$(function(){-->
    <!--$('.am-slider').flexslider({-->
    <!--playAfterPaused: 1000,-->
    <!--animation: "fade",-->
    <!--animationLoop: true,-->
    <!--smoothHeight: true,-->
    <!--animationSpeed: 1000,-->
    <!--slideshowSpeed: 1000,-->
    <!--});-->
    <!--});-->
    <!--</script>-->
</head>
<body>
<header data-am-widget="header"
        class="am-header am-header-default">
    <div class="am-header-left am-header-nav">
        <a href="#left-link" class="">
            <i class="am-header-icon am-icon-home"></i>
        </a>
    </div>

    <h1 class="am-header-title">
        <a href="#title-link" class="">
            主页
        </a>
    </h1>

    <div class="am-header-right am-header-nav">
        <a href="#right-link" class="">

            <i class="am-header-icon am-icon-bars"></i>
        </a>
    </div>
</header>
<div id="shujuid">
	<h2 class="shujuidtext" th:text="${msg}"></h2>
</div>
<div data-am-widget="slider" class="am-slider am-slider-c2" data-am-slider='{"directionNav":false}'>
    <ul class="am-slides">
        <li>
            <img src="http://s.amazeui.org/media/i/demos/bing-1.jpg">
            <div class="am-slider-desc">远方 有一个地方 那里种有我们的梦想</div>

        </li>
        <li>
            <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg">
            <div class="am-slider-desc">某天 也许会相遇 相遇在这个好地方</div>

        </li>
        <li>
            <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg">
            <div class="am-slider-desc">不要太担心 只因为我相信 终会走过这条遥远的道路</div>

        </li>
        <li>
            <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg">
            <div class="am-slider-desc">OH PARA PARADISE 是否那么重要 你是否那么地遥远</div>

        </li>
    </ul>
</div>


<ul data-am-widget="gallery" class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-4 am-gallery-default" data-am-gallery="{ pureview: true }">
    <li>
        <div class="am-gallery-item">
            <a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
                <img src="http://s.amazeui.org/media/i/demos/bing-1.jpg" alt="远方 有一个地方 那里种有我们的梦想"/>
                <h3 class="am-gallery-title">远方 有一个地方 那里种有我们的梦想</h3>
                <div class="am-gallery-desc">2375-09-26</div>
            </a>
        </div>
    </li>
    <li>
        <div class="am-gallery-item">
            <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg" alt="某天 也许会相遇 相遇在这个好地方"/>
                <h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
                <div class="am-gallery-desc">2375-09-26</div>
            </a>
        </div>
    </li>
    <li>
        <div class="am-gallery-item">
            <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg" alt="不要太担心 只因为我相信"/>
                <h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
                <div class="am-gallery-desc">2375-09-26</div>
            </a>
        </div>
    </li>
    <li>
        <div class="am-gallery-item">
            <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg" alt="终会走过这条遥远的道路"/>
                <h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
                <div class="am-gallery-desc">2375-09-26</div>
            </a>
        </div>
    </li>
</ul>


<div id="container" style="width:100%">

    <div id="header" style="background-color:#FFA500;">
        <h1 style="margin-bottom:0;">主要的网页标题</h1></div>

    <div id="menu" style="background-color:#FFD700;height:200px;width:20%;float:left;">
        <b>菜单</b><br>
        HTML<br>
        CSS<br>
        JavaScript
    </div>
    <div id="content" style="background-color:#EEEEEE;height:200px;width:80%;float:left;">
        内容在这里
    </div>

    <div id="textcontent" style="width: 100%">
        <div id="textone" style="width: 30%;float: left;display: inline">nihao</div>
        <div id="textotwo" style="width: 30%;float: right;display: inline">nihao2</div>
        <button id="mybutton" style="width: 40%;float:right">发送请求</button>
    </div>

    <div style="background-color:#FFA500;clear:both;text-align:center;">
        版权 © runoob.com
    </div>
</div>
<div id="photoqw">
    <h3 >你好，请问有热吗？</h3>
    <img src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg"
         style="width: 88%;text-align: center;margin-left: 6%"
         class="am-img-responsive"/>

    <input id="myfiles" multiple type="file">


    <img id="preview" style="position: relative;left: 0px"/>
    <br/>
</div>
<div>
    <!-- 配置nultipartresolver,注意：id名必须这样写，不然会报错 -->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="defaultEncoding" value="UTF-8"></property>
        <property name="maxInMemorySize" value="10240000"></property>
    </bean>
    <form class="am-form" id="myform" method="post" enctype="multipart/form-data"
          style="text-align: center;margin-left: 14%;margin-right: 14%">
        <div>
            <div class="am-form-group" style="align-content: center;height: 34px;">
                <label for="doc-ipt-email-1"
                       style="float: left;width: 20%;vertical-align: middle;text-align: center;margin-top: 1px;margin-right: 2px">用户名：</label>
                <input type="text" name="username" id="doc-ipt-email-1" placeholder="输入用户名"
                       style="border-radius: 4px;width: 70%;vertical-align: middle">
            </div>
            <div class="am-form-group">
                <label for="doc-ipt-pwd-1">密码</label>
                <input type="password" maxlength="11" name="password" id="doc-ipt-pwd-1" placeholder="输入11位密码"
                       style="border-radius: 4px">
            </div>
            <input type="file" name="myfile" onchange="imgPreview(this)"/>
            <button id="tijiao" type="submit" onclick="myloginthree()">登陆</button>
            <div id="output1">nih</div>
        </div>

    </form>
</div>
<script>
    $(function () {
        const onAction = function (index, direction) {
            alert('激活的幻灯片编号：', index, '，滚动方向：', direction);
        };
    });


</script>
<div data-am-widget="tabs"
     class="am-tabs am-tabs-default"
>
    <ul class="am-tabs-nav am-cf">
        <li class="am-active"><a href="[data-tab-panel-0]">青春</a></li>
        <li class=""><a href="[data-tab-panel-1]">彩虹</a></li>
        <li class=""><a href="[data-tab-panel-2]">歌唱</a></li>
    </ul>
    <div class="am-tabs-bd">
        <div data-tab-panel-0 class="am-tab-panel am-active">
            <img src="apple-touch-icon.png">
            【青春】那时候有多好，任雨打湿裙角。忍不住哼起，心爱的旋律。绿油油的树叶，自由地在说笑。燕子忙归巢，风铃在舞蹈。经过青春的草地，彩虹忽然升起。即使视线渐渐模糊，它也在我心里。就像爱过的旋律，没人能抹去。因为生命存在失望，歌唱，所以才要歌唱。
        </div>
        <div data-tab-panel-1 class="am-tab-panel ">
            【彩虹】那时候有多好，任雨打湿裙角。忍不住哼起，心爱的旋律。绿油油的树叶，自由地在说笑。燕子忙归巢，风铃在舞蹈。经过青春的草地，彩虹忽然升起。即使视线渐渐模糊，它也在我心里。就像爱过的旋律，没人能抹去。因为生命存在失望，歌唱，所以才要歌唱。
        </div>
        <div data-tab-panel-2 class="am-tab-panel ">
            【歌唱】那时候有多好，任雨打湿裙角。忍不住哼起，心爱的旋律。绿油油的树叶，自由地在说笑。燕子忙归巢，风铃在舞蹈。经过青春的草地，彩虹忽然升起。即使视线渐渐模糊，它也在我心里。就像爱过的旋律，没人能抹去。因为生命存在失望，歌唱，所以才要歌唱。
        </div>
    </div>
</div>

<nav class="tabbar tabbar-primary">
    <a icon="list" title="组件" class="active tabbar-item" href="#/">
        <span class="icon icon-list"></span>
        <span class="tabbar-label">组件</span>
    </a>
    <a icon="info" title="关于" class="tabbar-item" href="#/about">
        <span class="icon icon-info">
            <span class="badge badge-alert badge-rounded">β</span>
        </span>
        <span class="tabbar-label">关于</span>
    </a>
</nav>
<footer data-am-widget="footer"
        class="am-footer am-footer-default"
        data-am-footer="{  }">
    <div class="am-footer-switch">
    <span class="am-footer-ysp" data-rel="mobile"
          data-am-modal="{target: '#am-switch-mode'}">
          手机
    </span>
        <span class="am-footer-divider"> | </span>
        <a id="godesktop" data-rel="desktop" class="am-footer-desktop" href="javascript:">
            手机吗
        </a>
    </div>
    <div class="am-footer-miscs ">

        <p>由 <a href="http://www.yunshipei.com/" title="诺亚方舟"
                target="_blank" class="">诺亚方舟</a>
            提供技术支持</p>
        <p>CopyRight©2014 AllMobilize Inc.</p>
        <p>京ICP备13033158</p>
    </div>
</footer>

<div id="am-footer-modal"
     class="am-modal am-modal-no-btn am-switch-mode-m am-switch-mode-m-default">
    <div class="am-modal-dialog">
        <div class="am-modal-hd am-modal-footer-hd">
            <a href="javascript:void(0)" data-dismiss="modal" class="am-close am-close-spin " data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            您正在浏览的是

            <span class="am-switch-mode-owner">
            云适配
        </span>

            <span class="am-switch-mode-slogan">
              为您当前手机订制的移动网站。
        </span>
        </div>
    </div>
</div>

</body>
</html>
