package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;

public interface OrderService {
    JSONObject isAppointed(HttpSession session);

    JSONObject addAppoint(HttpSession session, JSONObject data);

    JSONObject getAllAppoints(HttpSession session);
}
