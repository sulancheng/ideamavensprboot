<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/jquery-weui/0.8.3/css/jquery-weui.min.css">
    <script src="//cdn.bootcss.com/jquery-weui/0.8.3/js/jquery-weui.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
    <script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.ie8polyfill.min.js"></script>
    <script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.widgets.helper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        #zongconent {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100px;
        }

        .carddiv {
            position: relative;
            margin-top: 12px;
            margin-right: 6px;
            left: -15px;
            width: 100%;
            background: #f5f9fc;
            background: url("../images/logo.png");
            box-shadow: 7px 7px 3px #888888;
        }

        .media-object {
            width: 110px;
            height: 130px;
            margin: 12px 12px 12px 12px;

        }

        .media-body {
            padding-top: 5px;
            padding-right: 10px;
        }

        .mybutton {
            margin-left: 5%;
            border-radius: 18px;
        }

        /* .mybutton:visited {
             //color: #00FF00;
             //border-radius: 0px;
         }
 */
        /* 已访问链接 */
        .riqi span {
            width: 200px;
            border-right: 1px solid #01a001;
            border-bottom: 3px solid #ff0000;
            border-left: 1px dashed #ffe09f;
            border-collapse: separate;
            padding: 10px 30px 10px 10px;
        }

        .listcard ul li:active {
            background-color: #0c7cb5;
        }

        .anbutton {
            border-bottom: 3px solid #ff0000;
            border-spacing: 10px 10px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $('.am-slider-manual').flexslider({
                animation: "slide",             // String: ["fade"|"slide"]，动画效果
                controlNav: false,               // Boolean: 是否创建控制点
                reverse: true,                 // Boolean: 翻转 slide 运动方向
                slideshowSpeed: 3000,           // Integer: ms 滚动间隔时间
            });
            $("#zongconent").click(function () {
                //alert($(this).attr("data-action"))
                var a="${hitCounter}";
                var b="${sessionScope.sessinoko88}";
                var b="${sessinoko88}";
                //alert(b);
            	//localStorage.setItem('wodeone',"我的挼搜ID谁骄傲的");
            	//localStorage.setItem('wodetwo',"我的桥的665656566");
            	//window.location.href="/student";
            });
            
            $("#huchub").click(function(){
            	//alert($('#testSelect option:selected').val());//选中的值
            	 // window.location.href = "http://huichubang:8080/strs?system=pc&id=45464"; 
            	
            });
            
            $(".mybuttonzu button").click(function () {
                //$(this).attr("disabled","disabled");//不可点击
                //$(this).prop("disabled","disabled");//不可点击都有用
                $(this).css("background-color", "#45ff44").css("border-radius", "0px").addClass("anbutton").siblings().css("background-color", "#e56c0c");//自己编绿色
                // $(this).siblings().css("background-color","#e56c0c");
            });
            $(".riqi span").text(new Date());

        });
    </script>
</head>
<body>

<div id="zongconent" style="background-color: #eaeaea;height: 100%" data-action="nimei">
    <!--轮播图开始-->
    <div data-am-widget="slider" class="am-slider am-slider-a1 am-slider-manual" data-am-slider='{"directionNav":false}'
         style="bottom: 0;margin-bottom: 0px">
        <ul class="am-slides">
            <li>
                <img src="http://s.amazeui.org/media/i/demos/bing-1.jpg">

            </li>
            <li>
                <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg">

            </li>
            <li>
                <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg">

            </li>
            <li>
                <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg">

            </li>
        </ul>
    </div>
    <!--轮播图end-->
    <div class="listcard">
        <!--列表st-->
        <ul style="list-style: none">
            <li class="carddiv" id="ullicon" honclick="window.open('http://www.cnblogs.com')">
                <a class="media-left">
                    <img class="media-object"
                         src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
                         alt="媒体对象">
                </a>
                <div class="media-body" style="font-size: 13px">
                    <h4 class="" style="margin-top: 10px">媒体标题</h4>
                    <span style="position: relative;top: -10px">
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                    </span>

                </div>
            </li>
            <li class="carddiv">
                <a class="media-left" href="#">
                    <img class="media-object"
                         src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
                         alt="媒体对象">
                </a>
                <div class="media-body" style="font-size: 13px">
                    <h4 class="" style="margin-top: 10px">媒体标题</h4>
                    <span style="position: relative;top: -10px">
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                    </span>

                </div>
            </li>
            <li class="carddiv">
                <a class="media-left" href="#">
                    <img class="media-object"
                         src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
                         alt="媒体对象">
                </a>
                <div class="media-body" style="font-size: 13px">
                    <h4 class="" style="margin-top: 10px">媒体标题</h4>
                    <span style="position: relative;top: -10px">
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                        这是一些示例文本。这是一些示例文本。
                    </span>

                </div>
            </li>
        </ul>
        <!--列表end-->
    </div>
    <!--划线-->
    <div id="Layer1"
         style="position: relative; width:1px; height:200px; z-index:1; background-color: #000000;layer-background-color: #000000; border: 1px none #000000; left: 143px"></div>


    <div style="display: block;margin-top: 10px;width: 100%;height: auto;text-align: center">
        <h5 id="miaoswenz" style="display: inline-block">新闻内容</h5>
        <h5 style="display: inline-block;margin-left: 10%">新闻内容</h5>
        <h5 style="display: inline-block;margin-left: 10%">新闻内容</h5>
    </div>
    <!--按钮开始-->
    <div class="mybuttonzu"
         style="display: block;text-align: center;height: 200px;background-color: #e56c0c;line-height: 200px;">
        <!--    <div class="mybuttonzu" style="display: flex;align-items: center;height: 200px;background-color: #e56c0c;" >-->
        <!--也是可以居中-->
        <!-- 表示应谨慎采取的动作 -->
        <button type="button" class="btn btn-warning mybutton">警告按钮</button>
        <!-- 表示一个危险的或潜在的负面动作 -->
        <button type="button" class="btn btn-danger mybutton">危险按钮</button>
        <button type="button" class="btn btn-success mybutton">成功按钮</button>
        <button type="button" class="btn btn-success mybutton">成功按钮</button>
    </div>
    <!--按钮结束-->
    <div class="riqi" style="text-align: center">
        日期：<span></span>
    </div>
    <div class="weui_cells weui_cells_access" style="display: block;text-align: center">
        <div class="weui_cell" href="javascript:;" style="float: left;right: 0px">
            <div class="weui_cell_hd">
                <img
                    src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
                    style="width:20px;margin-right:5px;display:block">
            </div>

            <div class="weui_cell_ft" id="myzan" style="border: none">
                说明文字
            </div>
        </div>
        <div class="weui_cell" href="javascript:;" style="float: left">
            <div class="weui_cell_hd" style="display: inline">
                <img
                    src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
                    style="width:20px;margin-right:5px;display:block">
            </div>

            <div style="display: inline">
                说明文字
            </div>
        </div>
    </div>
    <!--关于横向居中与竖直居中start-->
    <div style="width: 100%;height: 100px;background: #F37B1D;display: block">
        <div style="position: relative;top: 50%;transform: translateY(-50%);display:inline-block ;margin-left: 30px">
            <div>就是新的1</div>
            <span>你还是旧的吧1</span>
        </div>
        <img class="photo"
             src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
             alt="媒体对象" style="height: 88px;position: absolute;margin-top: 6px;right: 4px">
    </div>

    <div style="width: 100%;height: 100px;background: #F37B1D;display: block;margin-top: 10px;position: relative">
        <div style="position: relative;top: 50%;transform: translateY(-50%);margin-left: 30px;float: left">
            <div>就是新的2</div>
            <span>你还是旧的吧2</span>
        </div>
        <img class="photo"
             src="http://www.17sucai.com/preview/79936/2016-12-05/wap%E5%BE%AE%E5%BA%97%E6%95%B4%E7%AB%991/images/temp/pic.jpg"
             alt="媒体对象" style="height: 88px;position: absolute;margin-top: 6px;right: 4px">
    </div>
    <div style="width: 100%;height: 100px;background: #F37B1D;display: block;margin-top: 10px">
        <div style="margin: 0 auto;position: relative;display: block;width: 100px;background: #ffff00">
            <div>就是新的3</div>
            <span>你还是旧的吧3</span>
        </div>
    </div>

    <div style="width: 100%;height: 200px;background: #F37B1D;display: block;margin-top: 10px">
        <div style="text-align: center">
            <div>就是新的4</div>
            <div style="display: inline">你还是旧的吧4</div>
        </div>
        <div style="text-align: center">
            <span>就是新的5</span>
            <span>你还是旧的吧5</span>
        </div>
        <div style="margin: 0 auto;position: relative;width: 300px;">//margin: 0 auto;position: relative 会默认with100%;导致内容居左 所以text-align: center让内容居中
            <span>就是新的51</span>
            <span>你还是旧的吧51</span>
        </div>
    </div>
    <div style="width: 100%;height: 100px;background: #F37B1D;margin-top: 10px;display: flex;align-items: center;justify-content: center">
        <div>
            <div>就是新的6</div>
            <div>你还是旧的吧6</div>
        </div>
    </div>
    <div style="width: 100%;height: 100px;background: #F37B1D;margin-top: 10px;display: flex;align-items: center;justify-content: center">
        <div>
            <span>就是新的7</span>
            <span style="margin-left: 20px">你还是旧的吧7</span>
        </div>
    </div>
    <!--关于横向居中与竖直居中end-->
    <!--ulstart-->
   
    <!--ulstart-->
    <style type="text/css">
        .head-nav{
            width:100%;
            display:block;
            position: relative;
            height: 100px;
        }
        .head-nav ul{
            list-style:none;
        }
        .head-nav ul li{
            float:left;
        }
    </style>
    <div style="display: flex;flex-direction: column" >
        <div class="head-nav">
            <ul>
                <li>
                    nishishui
                </li>
                <li>
                    nishishui
                </li>
                <li>
                    nishishui
                </li>
            </ul>

        </div>
        <div style="width: 100%;background: #F37B1D;display: block;margin-top: 10px">
           EL表达式 ${one}
           <h6>${hitCounter}</h6>
        </div>
        	集合
        <div>
        	<c:forEach  items="${list}" var="li">
        	
        	  <ul style="list-style: none;line-height: 0px;height:0px">
                <li>
                    ${li.name}
                </li>
               
            </ul>
			</c:forEach>
		
        </div>
        <div style="padding:2px">
        	<select id="testSelect">
				<c:forEach  items="${list}" var="li">
	        	 <option value="${li.id}">${li.name}</option>
				</c:forEach>
			</select>
        </div>
		<div>
			打开惠厨帮
			<a href="app://huichubang?system=pc&id=45464">test</a>
		</div>
		
		<div id="huchub">
			自定义跳转
		</div>
    </div>
	
	
	
</div>
</body>
</html>
