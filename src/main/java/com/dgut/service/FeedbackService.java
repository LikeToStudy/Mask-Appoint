package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

public interface FeedbackService {
    JSONObject addMessage(String mesContent);

    JSONObject addContact(JSONObject data);
}
