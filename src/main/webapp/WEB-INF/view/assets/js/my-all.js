$(function () {


    // 判断是否登录
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8080/isLogin",
        dataType: "json", //返回数据类型
        contentType: 'application/json',
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = { "result" : result ; "name" : name }
             *
             *    result    是否已经登录，登录为true,否则为false
             *    name       传送出名字
             *
             */
            if(data.result){
                $("#loginnow").css("display","block");
                $($("#loginnow").siblings()).css("display","none");
                document.getElementById("username").innerHTML = data.name;
            }
        }
    });

    // 搜索查询
    $("#searchIcon").click(function () {

        var data = { "searchContent" : $("#s-full").val() };
        var myJSON = JSON.stringify(data);
        /*
         *    从前台传入的json数组
         *    searchContent = $("#s-full").val()
         *
         *    searchContent 代表传入查询的字符
         *
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8080/search",
            data:myJSON,
            dataType: "json", //返回数据类型
            contentType: 'application/json',
            success: function(data){
                /*
                 *    从后台传出的json数组
                 *    data = { "result" : result ,"uris" : uris  }
                 *
                 *    result    是否存在相应的商品可以进行预约，如果存在则返回true,否则则返回false
                 *    uris      支持模糊查询，返回带有查询关键字的网址 （uris是List）
                 *
                 *    例如查询口罩，则返回
                 *    { "result" : true , "uris":"N95防护口罩","一次性防护口罩" ... }
                 *
                 */
                if(data.result){
                    var arr = data.uris;
                    for(var i = 0 ; i<data.uris.length ; i++){
                        switch ( arr[i] ) {
                            case "N95防护口罩":
                                $("#searchDocker").append("<a class=\"hint\" href=\"single-product.html\">N95&nbsp;防&nbsp;护&nbsp;口&nbsp;罩</a>");
                                break;
                            case "一次性防护口罩":
                                $("#searchDocker").append("<a class=\"hint\" href=\"single-product-one.html\">一&nbsp;次&nbsp;性&nbsp;防&nbsp;护&nbsp;口&nbsp;罩</a>");
                                break;
                            case "医用防护口罩":
                                $("#searchDocker").append("<a class=\"hint\" href=\"single-product-care.html\">医&nbsp;用&nbsp;防&nbsp;护&nbsp;口&nbsp;罩</a>");
                                break;
                            case "儿童防护口罩":
                                $("#searchDocker").append("<a class=\"hint\" href=\"single-product-nth.html\">儿&nbsp;童&nbsp;防&nbsp;护&nbsp;口&nbsp;罩</a>");
                                break;
                        }
                    }
                } else{
                    alert("您查询的信息不存在！");
                }
            }
        });
    });

    // 退出搜索，则自动删除相应的条目
    $("#closeIcon").click(function () {
        $("#s-full").val("");
        $("#searchDocker > a").remove();
    });

    // 点击退出登录时，发送给后台，需要删除Session
    $("#signOut").click(function () {
        /*
           *    从前台传入的json数组
           *    data = { "signOut" : signOut }
           *
           *    signOut 退出登录
           *
           */
        var signOut = { "signOut": true };
        var myJSON = JSON.stringify(signOut);
        $.ajax({
            type: "post",
            traditional: true,
            contentType:'application/json;charset=UTF-8',
            url: "http://localhost:8080/logout",
            data: myJSON,
            dataType: "json", //返回数据类型
            success: function(data){
                /*
                *    从后台传来的json数组
                *    data = { "result" : result }
                *
                *    result 是否退出成功
                *
                */
                if(data.result){
                    alert("退出成功");
                    $("#loginnow").css("display","none");
                    $($("#loginnow").siblings()).css("display","block");
                    window.parent.location.href = "index.html";
                }else{
                    alert("退出失败！")
                }
            }
        });
    })
});