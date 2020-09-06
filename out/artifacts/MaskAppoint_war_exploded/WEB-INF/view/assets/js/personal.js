$(function () {

    // 点击左侧目录，进行颜色变化
    $(".intro-content-left-center>ul>li>a").click(function (event) {
        event.preventDefault();

        var parent = $(this).parent();

        parent.addClass("change-color");
        $(parent.siblings()).removeClass("change-color");
    });

    // 显示个人信息
    $("#oneItemIcon").click(function () {
        $("#oneItem").addClass("item-show");
        $($("#oneItem").siblings()).removeClass("item-show");
    });

    // 显示修改个人信息
    $("#twoItemIcon").click(function () {
        $("#twoItem").addClass("item-show");
        $($("#twoItem").siblings()).removeClass("item-show");

        $("#changeName").attr("value",data.userName);
        $("#changeSex").attr("value",data.userSex);
        $("#changeBirth").attr("value",data.userBirth);
        $("#changePhone").attr("value",data.userPhone);
        $("#changeNation").attr("value",data.userNation);
        $("#changeAddress").attr("value",data.userAddress);
        $("#changePhoneNumber").attr("value",data.userPhoneNumber);
        $("#changeEmail").attr("value",data.userEmail);
    });

    // 显示预约信息
    $("#threeItemIcon").click(function () {

        $("#threeItem").addClass("item-show");
        $($("#threeItem").siblings()).removeClass("item-show");


        // 获得预约记录
        /*
         *    从前台传入的json数组
         *    data = null ;
         */
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getAllAppoints",
            dataType: "json", //返回数据类型
            contentType: 'application/json',
            success: function(data){
                /*
                 *    从后台传出的json数组
                 *    data = {
                 *          "appointments" : {
                 *                              "appointmentTime" : appointmentTime ,
                 *                              "appointmentSpeed" : appointmentSpeed
                 *                           }
                 *      }
                 *
                 *    appointmentTime      预约的时间
                 *    appointmentSpeed     预约完成，等待送达！ 或者 成功送达，预约成功！
                 *
                 *
                 */
                for ( var i = 0 ; i < data.appointments.length ; i++){
                    $("#slidesDocker").append(
                        "<li style=\"width: 253px; float: left; display: block;\">\n" +
                        "                                                    <div class=\"item\">\n" +
                        "                                                        <h3>" + data.appointments[i].appointmentTime + "</h3>\n" +
                        "                                                        <div class=\"desc\">\n" +
                        "                                                            <p>\n" +
                        "                                                                " + data.appointments[i].appointmentSpeed + "\n" +
                        "                                                            </p>\n" +
                        "                                                        </div>\n" +
                        "                                                    </div>\n" +
                        "                                                </li>"
                    )
                }
            }
        });
    });

    // 查看个人信息时，点击修改，触发第二个item的点击事件
    $("#clickChange").click(function () {
        $("#twoItemIcon").trigger('click');
    });


    // 控制预约信息往右移动
    var numbers = 1;
    $("#rightShow").click(function () {
        if(!(numbers*200>((253*(($("#slidesDocker>li").length)-1))))){
            $("#slidesDocker").animate({
                marginLeft : -200*numbers+"px"
            },"slow");
            ++numbers;
        }
    });

    // 控制预约信息往左移动
    var numbersOfLeft = 0;
    $("#leftShow").click(function () {
        numbersOfLeft = numbers-2;
        if(!(numbers*200 <= 200)){
            $("#slidesDocker").animate({
                marginLeft : -200*numbersOfLeft+"px"
            },"slow");
            --numbers;
        }
    });



    // 初始化个人信息
    /*
     *    从前台传入的json数组
     *    data = null ;
     */
    $.ajax({
        type: "post",
        url: "http://localhost:8080/userInfo",
        dataType: "json", //返回数据类型,
        contentType : 'application/json',
        success: function(data){
            /*
             *    从后台传出的json数组
             *    data = {
             *          "userName" : userName ,
             *          "userSex" : userSex ,
             *          "userBirth" : userBirth ,
             *          "userPhone" : userPhone ,
             *          "userNation" : userNation ,
             *          "userAddress" : userAddress ,
             *          "userPhoneNumber" : userPhoneNumber ,
             *          "userEmail" : userEmail
             *      }
             *
             *    userName          用户真实姓名
             *    userSex           用户性别
             *    userBirth         用户出生日期
             *    userPhone         用户绑定的手机号码
             *    userNation        用户的民族
             *    userAddress       用户的收件地址
             *    userPhoneNumber   用户的收件号码
             *    userEmail         用户的邮箱
             *
             *    如果没有该信息，则返回对应的空字符串“”
             *
             */
            document.getElementById("userName").innerHTML = data.userName;
            document.getElementById("userSex").innerHTML = data.userSex;
            document.getElementById("userBirth").innerHTML = data.userBirth;
            document.getElementById("userPhone").innerHTML = data.userPhone;
            document.getElementById("userNation").innerHTML = data.userNation;
            document.getElementById("userAddress").innerHTML = data.userAddress;
            document.getElementById("userPhoneNumber").innerHTML = data.userPhoneNumber;
            document.getElementById("userEmail").innerHTML = data.userEmail;

            //初始化修改信息
            $("#changeName").attr("value",data.userName);
            $("#changeSex").attr("value",data.userSex);
            $("#changeBirth").attr("value",data.userBirth);
            $("#changePhone").attr("value",data.userPhone);
            $("#changeNation").attr("value",data.userNation);
            $("#changeAddress").attr("value",data.userAddress);
            $("#changePhoneNumber").attr("value",data.userPhoneNumber);
            $("#changeEmail").attr("value",data.userEmail);
        }
    });



    // 确认修改
    $("#confirmChange").click(function () {
        if (
                $("#changeName").val() == "" || $("#changeSex").val() == "" || $("#changeBirth").val() == "" || $("#changePhone").val() == ""
                || $("#changeNation").val() == "" || $("#changeAddress").val() == ""  || $("#changePhoneNumber").val() == "" || $("#changeEmail").val() == ""
        ){
            $(".intro-content-right-center-right>.tips").css("display","block");
        }else{
            // 确认修改个人信息
            var data = {
                "changeName" : $("#changeName").val(),
                "changeSex" : $("#changeSex").val(),
                "changeBirth" : $("#changeBirth").val(),
                "changePhone" : $("#changePhone").val(),
                "changeNation" : $("#changeNation").val(),
                "changeAddress" : $("#changeAddress").val(),
                "changePhoneNumber" : $("#changePhoneNumber").val(),
                "changeEmail" : $("#changeEmail").val()
            };
            var myJSON = JSON.stringify(data);
            /*
                     *    从前台传出的json数组
                     *    data = {
                     *          "changeName" : changeName ,
                     *          "changeSex" : changeSex ,
                     *          "changeBirth" : changeBirth ,
                     *          "changePhone" : changePhone ,
                     *          "changeNation" : changeNation ,
                     *          "changeAddress" : changeAddress ,
                     *          "changePhoneNumber" : changePhoneNumber ,
                     *          "changeEmail" : changeEmail ,
                     *      }
                     *
                     *    changeName          修改后用户真实姓名
                     *    changeSex           修改后用户性别
                     *    changeBirth         修改后用户出生日期
                     *    changePhone         修改后用户绑定的手机号码
                     *    changeNation        修改后用户的民族
                     *    changeAddress       修改后用户的收件地址
                     *    changePhoneNumber   修改后用户的收件号码
                     *    changeEmail         修改后用户的邮箱
                     *
                     *    如果没有该信息，则返回对应的空字符串“”
                     *
                     */
            $.ajax({
                type: "post",
                url: "http://localhost:8080/updateUserInfo",
                data : myJSON,
                dataType: "json", //返回数据类型
                contentType: 'application/json',
                success: function(data){
                    /*
                     *    从后台传出的json数组
                     *    data = {
                     *          "result" : result
                     *      }
                     *
                     *    result      是否修改成功，成功返回true,否则返回false
                     *
                     *
                     *
                     */
                    if(data.result){
                        alert("修改成功！");

                        document.getElementById("userName").innerHTML = $("#changeName").val();
                        document.getElementById("userSex").innerHTML = $("#changeSex").val();
                        document.getElementById("userBirth").innerHTML = $("#changeBirth").val();
                        document.getElementById("userPhone").innerHTML = $("#changePhone").val();
                        document.getElementById("userNation").innerHTML = $("#changeNation").val();
                        document.getElementById("userAddress").innerHTML = $("#changeAddress").val();
                        document.getElementById("userPhoneNumber").innerHTML = $("#changePhoneNumber").val();
                        document.getElementById("userEmail").innerHTML = $("#changeEmail").val();
                    }else{
                        alert("修改失败！");
                    }
                }
            });
        }
    });


});