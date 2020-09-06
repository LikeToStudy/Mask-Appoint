package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*反馈控制器
* 用于处理用户反馈信息*/

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("message")
    public JSONObject message(@RequestBody JSONObject data){
        String mesContent = data.getString("message");
        return feedbackService.addMessage(mesContent);
    }

    @RequestMapping("contactSubmit")
    public JSONObject contact(@RequestBody JSONObject data){
        return feedbackService.addContact(data);
    }
}
