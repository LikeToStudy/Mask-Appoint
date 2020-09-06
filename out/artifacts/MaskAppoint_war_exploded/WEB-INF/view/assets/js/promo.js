$(function () {

    // 提交需要的产品，进入后台
    $("#submitBtn").click(function () {
        if($("#needProduct").val() == ""){
            alert("输入不能为空！")
        }else {
            var data = { "needProduct" : $("#needProduct").val()};
            var myJSON = JSON.stringify(data);
            //序列化，是以键值对的形式发过来的
            /*
             *    从前台传入的json数组
             *    需要的产品
             *    needProduct = needProduct
             *
             */
            $.ajax({
                type: "post",
                url: "http://localhost:8080/addNeedProduct",
                data:myJSON,
                dataType: "json", //返回数据类型
                contentType : 'application/json',
                success: function(data){
                    /*
                     *    从后台传出的json数组
                     *    data = { "result" : result }
                     *
                     *    result    如果发送存在则返回true,否则则返回false
                     *
                     */
                    if(data.result){
                        alert("您需要的产品，我们已收到，会即使进行采购，谢谢您的支持！");
                        $("#needProduct").val("");
                    } else{
                        alert("服务器繁忙，请稍后再试！");
                    }
                }
            });
        }
    });


});