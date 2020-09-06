package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;

public interface UserService {
    JSONObject login(String username, String password, HttpSession session);

    JSONObject register(String username, String password, HttpSession session);

    JSONObject isLogin(HttpSession session);

    JSONObject logout(HttpSession session);

    JSONObject getUserInfo(HttpSession session);

    JSONObject isOfferAddressInfo(HttpSession session);

    JSONObject updateUserInfo(HttpSession session, JSONObject data);
}
