package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/*用户控制器
* 用于处理用户操作*/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginSubmit")
    public JSONObject login(@RequestBody JSONObject data, HttpSession session){
        String username = data.getString("userName");
        String password = data.getString("passWord");
        return userService.login(username, password, session);
    }

    @RequestMapping("/register")
    public JSONObject register(@RequestBody JSONObject data, HttpSession session){
        String username = data.getString("registerUserName");
        String password = data.getString("registerPassWord");
        return userService.register(username, password, session);
    }

    @RequestMapping("/isLogin")
    public JSONObject isLogin(HttpSession session){
        return userService.isLogin(session);
    }

    @RequestMapping("/logout")
    public JSONObject logout(HttpSession session){
        return userService.logout(session);
    }

    @RequestMapping("/userInfo")
    public JSONObject userInfo(HttpSession session){
        return userService.getUserInfo(session);
    }

    @RequestMapping("/isOffAddrInfo")
    public JSONObject isOffAddrInfo(HttpSession session){
        return userService.isOfferAddressInfo(session);
    }

    @RequestMapping("/updateUserInfo")
    public JSONObject updateUserInfo(HttpSession session, @RequestBody JSONObject data){
        return userService.updateUserInfo(session, data);
    }
}
