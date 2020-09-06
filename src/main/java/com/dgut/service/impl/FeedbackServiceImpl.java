package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.Contact;
import com.dgut.domain.Message;
import com.dgut.mapper.FeedbackMapper;
import com.dgut.service.FeedbackService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackMapper feedbackMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper, JsonHelper jsonHelper){
        this.feedbackMapper = feedbackMapper;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JSONObject addMessage(String mesContent) {
        Message message = new Message(mesContent);
        int result = feedbackMapper.insertMessage(message);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject addContact(JSONObject data) {
        String contactName = data.getString("contactName");
        String contactUsername = data.getString("contactUsername");
        String contactEmail = data.getString("contactEmail");
        String contactPhone = data.getString("contactPhone");
        String contactMessage = data.getString("contactMessage");
        Contact contact = new Contact(contactName, contactUsername, contactEmail,
                contactPhone, contactMessage);
        int result = feedbackMapper.insertContact(contact);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }
}
