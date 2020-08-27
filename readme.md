IDEA中修改各个部位的字体大小
1.菜单栏

Setting -> Appearance&Behavior -> Appearance ->Override default fonts by (not recommended),

勾选前面的框，下面的一行（Name和Size）被点亮，Name中调整字体风格，Size中调整大小。

 

2.鼠标滚轮控制缩放字体大小

File -> Setting -> Editor -> Gennral

选中Change font size (Zoom) with Ctrl+Mouse wheel，之后，使用Ctrl + 鼠标滚轮 快捷键就可以实时控制代码字体大小显示了，需要注意的是这种设置只对当前正在编辑的文件有效

 

3.鼠标滚轮放大缩小图片

File -> Setting -> Editor -> Images

选中Zoom image with mouse wheel (Ctrl+Mouse wheel)，之后，使用Ctrl + 鼠标滚轮 快捷键就可以实时调整正在查看的图片的显示大小了

 

3.设置Terminal窗口字体大小

File -> Setting -> Editor -> Color&Font -> Console Font

选中以后可以设置字体大小与行间距，不过设置完以后，重新打开一个Terminal窗口才会生效。

永久激活方式
第一步：将bin目录下的三个文件拷贝到IDEA安装之后的bin目录下，替换文件。

第二步：编辑idea.exe.vmoptions和idea64.exe.vmoptions文件，这两个文件的修改方式完全相同，都是修改文件的最后一行："-javaagent:"。确保"-javaagent:将jar文件的全路径拷贝到这里"。例如：

-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.3\bin\JetbrainsIdesCrack-4.2-release-sha1-3323d5d0b82e716609808090d3dc7cb3198b8c4b.jar

第三步：打开IDEA工具：Help-->Register...-->选择Activation code，将以下激活码粘贴进去，重启IDEA
ThisCrackLicenseId-{
"licenseId":"ThisCrackLicenseId",
"licenseeName":"idea",
"assigneeName":"",
"assigneeEmail":"idea@163.com",
"licenseRestriction":"For This Crack, Only Test! Please support genuine!!!",
"checkConcurrentUse":false,
"products":[
{"code":"II","paidUpTo":"2099-12-31"},
{"code":"DM","paidUpTo":"2099-12-31"},
{"code":"AC","paidUpTo":"2099-12-31"},
{"code":"RS0","paidUpTo":"2099-12-31"},
{"code":"WS","paidUpTo":"2099-12-31"},
{"code":"DPN","paidUpTo":"2099-12-31"},
{"code":"RC","paidUpTo":"2099-12-31"},
{"code":"PS","paidUpTo":"2099-12-31"},
{"code":"DC","paidUpTo":"2099-12-31"},
{"code":"RM","paidUpTo":"2099-12-31"},
{"code":"CL","paidUpTo":"2099-12-31"},
{"code":"PC","paidUpTo":"2099-12-31"} ],
"hash":"2911276/0",
"gracePeriodDays":7,
"autoProlongated":false}
第四步：重启IDEA后，查看Help-->Register...，是否显示激活到2100年。

在pom里面的maven 不下载包的时候，点击右边的maven prj 中的clean 然后就好了。