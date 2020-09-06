$(function () {

    // 判断是否登录变量
    var falgOfLogin = false;

    // 判断是否登录
    /*
     *    从前台传入的json数组
     *    data = null
     *
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8080/isLogin",
        // 关闭异步请求，修改全局变量
        async: false,
        dataType: "json", //返回数据类型
        contentType : 'application/json',
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
                falgOfLogin = true;
            }
        }
    });

    // 显示库存
    /*
     *    从前台传入的json数组
     *    productName = productName
     *
     *    productName   产品名称
     *
     */
    var stockJSON = JSON.stringify({ "productName" : "一次性防护口罩" });
    $.ajax({
        type: "post",
        url: "http://localhost:8080/queryStock",
        data:stockJSON,
        dataType: "json", //返回数据类型
        contentType : 'application/json',
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = { "productStock" : productStock }
             *
             *    productStock    返回产品库存
             *
             */
            document.getElementById("productStock").innerHTML = data.productStock;
        }
    });


    // 判断是否预约
    $("#appointment").click(function () {
        if(parseInt(document.getElementById("productStock").innerHTML) < parseInt($("#quantity").val())){
            alert("库存不足，请调整数量，或者补充后再继续预约！")
        }else{
            if(falgOfLogin){
                /*
                 *    从前台传入的json数组
                 *    data = null ;
                 */
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/isAppointed",
                    dataType: "json", //返回数据类型
                    contentType : 'application/json',
                    success: function(data){
                        /*
                         *    从后台传出的json数组
                         *    data = { "result" : result }
                         *
                         *    result    是否预约，预约为true,否则为false
                         *
                         */
                        if(data.result){
                            alert("您已经在三天内，预约过口罩了！");
                        }else{
                            appointment();
                        }
                    }
                });
            }else {
                alert("您还未登录，请登录后再试！");
                window.parent.location.href = "login.html";
            }
        }
    });


    // 进行口罩预约
    function appointment () {
        var data = {"quantity": $("#quantity").val(), "productName": "一次性防护口罩"};
        var myJSON = JSON.stringify(data);
        /*
         *    从前台传入的json数组
         *    quantity = quantity
         *    productName = productName
         *
         *    quantity   数量
         *    productName  产品名称
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8080/appointSubmit",
            data: myJSON,
            dataType: "json", //返回数据类型
            contentType : 'application/json',
            success: function (data) {
                /*
                 *    从后台传出的json数组
                 *    data = { "result" : result }
                 *
                 *    result    预约是否成功，成功为true,否则为false
                 *
                 */
                if (data.result) {
                    alert("预约成功，请等候您的口罩！");
                    window.location.reload();
                } else {
                    alert("预约失败，服务器繁忙，等稍后再试");
                }
            }
        });
    }
});