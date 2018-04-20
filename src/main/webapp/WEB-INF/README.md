# [HTML5 Boilerplate](https://html5boilerplate.com)

[![Build Status](https://travis-ci.org/h5bp/html5-boilerplate.svg)](https://travis-ci.org/h5bp/html5-boilerplate)
[![devDependency Status](https://david-dm.org/h5bp/html5-boilerplate/dev-status.svg)](https://david-dm.org/h5bp/html5-boilerplate#info=devDependencies)

HTML5 Boilerplate is a professional front-end template for building
fast, robust, and adaptable web apps or sites.

This project is the product of many years of iterative development and
combined community knowledge. It does not impose a specific development
philosophy or framework, so you're free to architect your code in the
way that you want.

* Homepage: [https://html5boilerplate.com](https://html5boilerplate.com)
* Source: [https://github.com/h5bp/html5-boilerplate](https://github.com/h5bp/html5-boilerplate)
* Twitter: [@h5bp](https://twitter.com/h5bp)


## Quick start

Choose one of the following options:

1. Download the latest stable release from
   [html5boilerplate.com](https://html5boilerplate.com/) or create a
   custom build using [Initializr](http://www.initializr.com).
2. Clone the git repo — `git clone
   https://github.com/h5bp/html5-boilerplate.git` - and checkout the
   [tagged release](https://github.com/h5bp/html5-boilerplate/releases)
   you'd like to use.


## Features

* HTML5 ready. Use the new elements with confidence.
* Designed with progressive enhancement in mind.
* Includes:
  * [`Normalize.css`](https://necolas.github.com/normalize.css/)
    for CSS normalizations and common bug fixes
  * [`jQuery`](https://jquery.com/) via CDN, with a local fallback
  * A custom build of  [`Modernizr`](http://modernizr.com/) for feature
    detection
  * [`Apache Server Configs`](https://github.com/h5bp/server-configs-apache)
    that, among other, improve the web site's performance and security
* Placeholder CSS Media Queries.
* Useful CSS helper classes.
* Default print styles, performance optimized.
* An optimized version of the Google Universal Analytics snippet.
* Protection against any stray `console` statements causing JavaScript
  errors in older browsers.
* "Delete-key friendly." Easy to strip out parts you don't need.
* Extensive inline and accompanying documentation.


## Browser support

* Chrome *(latest 2)*
* Edge *(latest 2)*
* Firefox *(latest 2)*
* Internet Explorer 8+
* Opera *(latest 2)*
* Safari *(latest 2)*

*This doesn't mean that HTML5 Boilerplate cannot be used in older browsers,
just that we'll ensure compatibility with the ones mentioned above.*

If you need legacy browser support (IE 6+, Firefox 3.6+, Safari 4+) you
can use [HTML5 Boilerplate v4](https://github.com/h5bp/html5-boilerplate/tree/v4),
but is no longer actively developed.


## Documentation

Take a look at the [documentation table of contents](dist/doc/TOC.md).
This documentation is bundled with the project, which makes it readily
available for offline reading and provides a useful starting point for
any documentation you want to write about your project.


## Contributing

Hundreds of developers have helped make the HTML5 Boilerplate what it is
today. Anyone and everyone is welcome to [contribute](CONTRIBUTING.md),
however, if you decide to get involved, please take a moment to review
the [guidelines](CONTRIBUTING.md):

* [Bug reports](CONTRIBUTING.md#bugs)
* [Feature requests](CONTRIBUTING.md#features)
* [Pull requests](CONTRIBUTING.md#pull-requests)


## License

The code is available under the [MIT license](LICENSE.txt).

第一次写h5 ，点击事件都不熟悉：
1.妹子框架的点击事件：
   $('.js-demo-slider-btn').on('click', function() {
      var action = this.getAttribute('data-action');
      if (action === 'add') {
        $slider.flexslider('addSlide', getSlide());
      } else {
        var count = $slider.flexslider('count');
        count > 1 && $slider.flexslider('removeSlide', $slider.flexslider('count') - 1);
      }
    });
    
    jQuery  :
    语法
  $("p").click(function(){
      alert("段落被点击了。");
  });
 2.基本点击事件：
 <script>
 function changetext(id)
 {
 id.innerHTML="谢谢!";
 }
 </script>
 </head>
 <body>
 <h1 onclick="changetext(this)">请点击该文本</h1>
 <button type="button" onclick="loadXMLDoc()">获取我的 CD</button>
 </body>
 
 定义的一个方法：
 function loadXMLDoc()
 {
 	var xmlhttp;
 	if (window.XMLHttpRequest)
 	{
 		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
 		xmlhttp=new XMLHttpRequest();
 	}
 	else
 	{
 		// IE6, IE5 浏览器执行代码
 		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
 	}
 	xmlhttp.onreadystatechange=function()
 	{
 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
 		{
 			document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
 		}
 	}
 	xmlhttp.open("GET","/try/ajax/ajax_info.txt",true);
 	xmlhttp.send();
 }
 
 
<p>点击按钮就可以执行 <em>displayDate()</em> 函数。</p>
<button id="myBtn">点击这里</button>
<script>
document.getElementById("myBtn").onclick=function(){displayDate()};
function displayDate()
{
document.getElementById("demo").innerHTML=Date();
}
</script>
<p id="demo"></p>
</body>
2.关于横向布局 ：
(1)我们对div设置一个float浮动属性即可解决不并排显示，只要你的并排div盒子总宽度小于或等于最外层盒子宽度即可实现多个div对象并排显示。float:left  会随着屏幕宽度高度的变化 实现排版的变化。
(2).我们加入display:inline即可解决实现同行并排显示div盒子对象。
    未设置display样式效果截图：display: inline
  重要的添加内容： 
  block元素可以包含block元素和inline元素；但inline元素只能包含inline元素。要注意的是这个是个大概的说法，每个特定的元素能包含的元素也是特定的，所以具体到个别元素上，这条规律是不适用的。
  比如 P 元素，只能包含inline元素，而不能包含block元素。
  一般来说，可以通过display:inline和display:block的设置，改变元素的布局级别。
  
   
    block元素的特点是：  块 有自动换行 <h> <p> <div>
    　　总是在新行上开始；
    block元素会独占一行，多个block元素会各自新起一行。默认情况下，block元素宽度自动填满其父元素宽度。
    block元素可以设置width,height属性。块级元素即使设置了宽度,仍然是独占一行。
    block元素可以设置margin和padding属性。
    
    　inline元素的特点是：  内联  排一排。 
    　inline元素的特点是： 
    　　和其他元素都在一行上；
    　　高，行高及顶和底边距不可改变；
    　　宽度就是它的文字或图片的宽度，不可改变。
    　　<span>, <a>, <label>, <input>, <img>, <strong> 和<em>是inline元素的例子。
    　　和其他元素都在一行上；
        inline元素不会独占一行，多个相邻的行内元素会排列在同一行里，直到一行排列不下，才会新换一行，其宽度随元素的内容而变化。
        inline元素设置width,height属性无效。
        inline元素的margin和padding属性，水平方向的padding-left, padding-right, margin-left, margin-right都产生边距效果；
        但竖直方向的padding-top, padding-bottom, margin-top, margin-bottom不会产生边距效果。
    
    
    inline-block的元素特点：
    display:inline-block
        简单来说就是将对象呈现为inline对象，但是对象的内容作为block对象呈现。之后的内联对象会被排列在同一行内。
        比如我们可以给一个link（a元素）inline-block属性值，使其既具有block的宽度高度特性又具有inline的同行特性。
    　   将对象呈递为内联对象，但是对象的内容作为块对象呈递。旁边的内联对象会被呈递在同一行内，允许空格。(准确地说，应用此特性的元素呈现为内联对象，周围元素保持在同一行，但可以设置宽度和高度地块元素的属性)
    
 （3）position:static  标签默认的就是这个   position:fixed 定位，窗口滚动它也不滚动
 position:relative 相对定位元素的定位是相对其正常位置
 position: absolute 定位
      绝对定位的元素的位置相对于最近的已定位父元素，如果元素没有已定位的父元素，那么它的位置相对于<html>:
  
  
  数据定义与储存。
  action-data与action-type 自定义数据方便操作。
  
  <div id='test' data-age="23">html5 data-*自定义属性 data-age</div>
  获取$('#test').data('age');
  
  if(typeof(Storage)!=="undefined")
  {
    localStorage.haha="jokoo";
    document.getElementById("result").innerHTML="网站名：" + localStorage.haha;
  }
  else
  {
    document.getElementById("result").innerHTML="对不起，您的浏览器不支持 web 存储。";
  }
  
  
3.关于大量的数据提交 可以考虑表单提交： 也可以FormData对象是html5的一个对象。
4.关于节点的操作：
<div id="test">
<div></div>
<div></div>
</div>
var a = docuemnt.getElementById("test").getElementsByTagName("div");  这样是没有问题的
var b =document.getElementById("test").childNodes;  

<div id="test">
<div></div>
<div></div>
</div>
<script>
function dom() {
var s= document.getElementById("test");
del_ff(s);    //清理空格
var chils= s.childNodes;  //得到s的全部子节点
var par=s.parentNode;   //得到s的父节点
var ns=s.nextSbiling;   //获得s的下一个兄弟节点
var ps=s.previousSbiling;  //得到s的上一个兄弟节点
var fc=s.firstChild;   //获得s的第一个子节点
var lc=s.lastChile;   //获得s的最后一个子节点

}

function del_ff(elem){
var elem_child = elem.childNodes;
for(var i=0; i<elem_child.length;i++){
if(elem_child[i].nodeName == "#text" && !/\s/.test(elem_child.nodeValue))
{elem.removeChild(elem_child)
}
}
}
</script>


对于json的解析：
不建议使用eval（）函数，因为eval（）接受任意的字符串，并当作JavaScript代码来处理,这个机制已经有安全隐患了
var str='{ "name": "John" }';
var obj = eval  ('(' + str + ')');
alert(obj.name);
  
$.parseJSON()和JSON.parse()函数用于将格式完好的JSON字符串转为与之对应的JavaScript对象。所谓"格式完好"，就是要求指定的字符串必须符合严格的JSON格式，
例如：属性名称必须加双引号、字符串值也必须用双引号。其次，JSON标准不允许字符串中出现"控制字符"，正确写法应该是使用两个反斜杠，以免被JS解析器直接转义。
  
1、JSON字符串转换为JSON对象
var str='{ "name": "John" ,"age": "24" }';
var obj = $.parseJSON(str);
alert(obj.name);  //John
  
var str = '{ "name": "John", "age": "24" }';
var obj = JSON.parse(str);
alert(obj.name);  //John
  
2、将JSON对象转换为字符串
var obj={name: "John", age: "24"};
var last=JSON.stringify(obj);
alert(last);  //'{name: "John", age: "24"}'
  
var obj={name: "John", age: "24"};
var last=obj.toJSONString();
alert(last);  //'{name: "John", age: "24"}'
  
3、解析读取json对象
var str={
  "result":{
    "age":"33",
    "id":"2server",
    "name":"mady"
  }
};
alert(str.result.age);  //33
  
var result = $.parseJSON( '[ 1, true, "CodePlayer" ]' );
alert( result[1] );  // CodePlayer
  
var result = $.parseJSON( "\"专注于编程开发技术分享\"" );
alert(result);  //专注于编程开发技术分享


4.表单提交的多种方式：
（1）
 <body>
    <form action="" id="myform">
        用户名<input type="text" name="username"/>
        密码<input type="password" name="password"/>
        性别<input type="radio" name="sex" value="男人">man
           <input type="radio" name="sex" value="女人">woman
    </form>

    <a href="#" style="text-decoration: none;">使用ajax提交表单数据</a>
  </body>
<script type="text/javascript">
        $(document).ready(function(){
            $("a").click(function(){
                 $.ajax({    
                    type:'post',        
                    url:'FormServlet',    
                    data:$("#myform").serialize(),    
                    cache:false,    
                    dataType:'json',    
                    success:function(data){   
                        alert("请求成功");
                    }    
                });    
            });
        });
    </script>

（2）
$.ajax({
                cache: true,
                type: "POST",
                url:ajaxCallUrl,
                data:$('#yourformid').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                    $("#commonLayout_appcreshi").parent().html(data);
                }
            });
（3）使用formdata上传表单 包含 文件图片上传。
var fd = new FormData(document.getElementById("myformid"));
//var fd = new FormData($("#myformid")[0]);
fd.append("CustomField", "This is some extra data");
$.ajax({
  url: "stash.php",
  type: "POST",
  data: fd,
  processData: false,  // 告诉jQuery不要去处理发送的数据
  contentType: false   // 告诉jQuery不要去设置Content-Type请求头
   success: function(msg){
       alert( "Data Saved: " + msg );
    }
});

关于jquery 设置属性 获取属性与一处属性。 prop  attr  css(style里面的属性用)
对于HTML元素本身就带有的固有属性，在处理时，使用prop方法。
对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法。 例如action  data-action
提示：如需检索 HTML 属性，请使用 attr() 方法代替。
提示：如需移除属性，请使用 removeProp() 方法。css只能修改属性名为style的值，也就是style=""里面的值

居中的方式L:    .content {
                   width: 300px;
                   height: 300px;
                   background: orange;
                   margin: 0 auto; /*水平居中*/
                   position: relative;
                   top: 50%; /*偏移*/
                   transform: translateY(-50%);
               }
                 body {
                           display: flex;
                           align-items: center; /*定义body的元素垂直居中多个孩子用align-content */
                           justify-content: center; /*定义body的里的元素水平居中*/
                       }
                       .content {
                           width: 300px;
                           height: 300px;
                           background: orange;        
                       }

 display: flex;
    flex-direction:column;纵向
    flex-direction:row;横向

 $("#zongconent").click(function () {
                alert($(this).attr("data-action"))

this默认是元素js加了$就是jquery
            });

5.关于多个div重叠 相对布局的内容 

整个demo地址：http://www.divcss5.com/shili/s587.shtml

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="utf-8" /> 
<title>div重叠 叠加实例 未排层叠顺序 www.divcss5.com</title> 
<style> 
.div-relative{position:relative; color:#000; border:1px solid #000; width:500px; height:400px} 
.div-a{ position:absolute; left:30px; top:30px; background:#F00; width:200px; height:100px} 
/* css注释说明： 背景为红色 */ 
.div-b{ position:absolute; left:50px; top:60px; background:#FF0; width:400px; height:200px} 
/* 背景为黄色 */ 
.div-c{ position:absolute; left:80px; top:80px; background:#00F; width:300px; height:300px} 
/* DIV背景颜色为蓝色 */ 
</style> 
</head> 
<body> 
<div class="div-relative"> 
<div class="div-a">我背景为红色</div> 
<div class="div-b">我背景为黄色</div> 
<div class="div-c">我背景为蓝色</div> 
</div> 
</body> 
</html> 
实例说明：
我们使用position实现绝对定位，对父级设置position:relative属性，对其子级设置position:absolute加上left或right和top或bottom实现子级在父级内任意定位。
在原始情况下重叠是按DIV代码本身顺序排列，越后输入的DIV盒子其越靠前（浮在上面）。除了改变源代码本身div代码在html顺序，我们还可以使用css z-index实现DIV层排列顺序。
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="utf-8" /> 
<title>div重叠 叠加实例 排层叠顺序 www.divcss5.com</title> 
<style> 
.div-relative{position:relative;color:#000;border:1px solid #000;width:500px;height:400px} 
.div-a{ position:absolute;left:30px;top:30px;z-index:100;background:#F00;width:200px;height:100px} 
/* div背景色为红色 */ 
.div-b{ position:absolute;left:50px;top:60px;z-index:80;background:#FF0;width:400px;height:200px} 
/* 背景为黄色 */ 
.div-c{ position:absolute;left:80px;top:80px;z-index:70;background:#00F;width:300px;height:300px} 
/* 背景为蓝色 */ 
</style> 
</head> 
<body> 
<div class="div-relative"> 
<div class="div-a">我背景为红色</div> 
<div class="div-b">我背景为黄色</div> 
<div class="div-c">我背景为蓝色</div> 
</div> 
</body> 
</html> 



6.关于监听滑动事件
<script type="text/javascript">
 $(window).scroll(function () {
      //已经滚动到上面的页面高度
     var scrollTop = $(this).scrollTop();
      //页面高度
     var scrollHeight = $(document).height();
       //浏览器窗口高度
     var windowHeight = $(this).height();
      //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
      if (scrollTop + windowHeight == scrollHeight) {
        alert('页面到底部了');
       }
        if (scrollHeight-(scrollTop + windowHeight )<30) {
               alert('页面到底部了');
              }
 });
</script>
7. box-sizing:border-box向内扩张在设置padding时候
box-sizing:conent-box 向外扩张 改变大小
