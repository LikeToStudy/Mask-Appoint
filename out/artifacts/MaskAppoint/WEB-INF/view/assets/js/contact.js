$(function () {

    // 把取得联系的信息，传入后端
    $("#submitBtn").click(function () {
        if(
            $("#contactName").val() == "" ||
            $("#contactUsername").val() == "" ||
            $("#contactEmail").val() == "" ||
            $("#contactPhone").val() == "" ||
            $("#contactMessage").val() == ""
        ){
            alert("输入不能为空！");
        }else {
            var data = {
                "contactName" : $("#contactName").val(),
                "contactUsername" : $("#contactUsername").val(),
                "contactEmail" : $("#contactEmail").val(),
                "contactPhone" : $("#contactPhone").val(),
                "contactMessage" : $("#contactMessage").val()
            };
            var myJSON = JSON.stringify(data);
            //序列化，是以键值对的形式发过来的
            /*
             *    从前台传入的json数组
             *    需要的产品
             *    contactName = contactName
             *    contactUsername = contactUsername
             *    contactEmail = contactEmail
             *    contactPhone = contactPhone
             *    contactMessage = contactMessage
             *
             *    contactName  发送消息的姓名
             *    contactUsername  发送消息的用户名
             *    contactEmail  发送消息的邮件
             *    contactPhone  发送消息的电话
             *    contactMessage  发送消息的信息
             *
             */
            $.ajax({
                type: "post",
                url: "http://localhost:8080/contactSubmit",
                data:myJSON,
                dataType: "json", //返回数据类型
                contentType: 'application/json',
                success: function(data){
                    /*
                     *    从后台传出的json数组
                     *    data = { "result" : result }
                     *
                     *    result    如果发送存在则返回true,否则则返回false
                     *
                     */
                    if(data.result){
                        alert("您的信息，我们已收到，会即时与您取得联系，谢谢您的支持！");
                        $("#contactName").val("");
                        $("#contactUsername").val("");
                        $("#contactEmail").val("");
                        $("#contactPhone").val("");
                        $("#contactMessage").val("");
                    } else{
                        alert("服务器繁忙，请稍后再试！");
                    }
                }
            });
        }
    });

});