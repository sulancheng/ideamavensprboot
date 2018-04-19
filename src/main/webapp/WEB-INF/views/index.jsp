<%@ page language="java" contentType="text/html; utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <link rel="stylesheet" href="../css/public.css">
    <script>
        function qingqiu() {
            var json = {
                "username":"admin",
                "password":123
            };
            $.ajax({
                url: "/helloworld",
                type: "POST",
                async: true,
                contentType: "application/json",
                data: JSON.stringify(json),
                dataType: 'json',
                success: function (data) {
                    alert(JSON.stringify(data))
                },
                errer:function (data) {
                    
                }
            });
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<span class='uyou'>你好的</span>
<button class="qingq" onclick="qingqiu()"></button>
</body>
</html>