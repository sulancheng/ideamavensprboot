$.fn.myFun1 = function (name) {
    alert("我的名字是:"+name);
};
var postone="http://127.0.0.1:8081";
/*封装成功！*/
$.fn.myPost=function (url, sucess, fail) {
    var myjson = {"phone": "15907526346", "code": "5184"};
    $.ajax({
        url: postone+"/test/helloworld",
        type: "POST",
        async: true,
        contentType: "application/json",
        data: JSON.stringify(myjson),
        dataType: 'json',
        success: function (datas) {
            if (typeof  sucess ==="function"){
                sucess(datas);
            }
        },
        error: function (datas) {
            if (typeof  fail ==="function"){
                fail(datas);
            }
        }
    });
};
