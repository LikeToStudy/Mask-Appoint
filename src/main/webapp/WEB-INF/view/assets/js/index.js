$(function () {


    // 提交建议进入后台
    $("#submitBtn").click(function () {
        if($("#message").val() == ""){
            alert("消息不能为空！");
        }else {
            var data = { "message" : $("#message").val()};
            var myJSON = JSON.stringify(data);
            //序列化，是以键值对的形式发过来的
            /*
             *    从前台传入的json数组
             *
             *    message = message
             *
             *    message     建议
             */
            $.ajax({
                type: "post",
                url: "http://localhost:8080/message",
                data: myJSON,
                dataType: "json", //返回数据类型
                contentType: 'application/json',
                success: function (data) {
                    /*
                     *    从后台传出的json数组
                     *    data = { "result" : result }
                     *
                     *    result    如果发送成功则返回true,否则则返回false
                     *
                     */
                    if (data.result) {
                        alert("您的建议，我们已收到，会即时进行改进，谢谢您的支持！");
                        $("#message").val("");
                    } else {
                        alert("服务器繁忙，请稍后再试！");
                    }
                }
            });
        }
    });
});