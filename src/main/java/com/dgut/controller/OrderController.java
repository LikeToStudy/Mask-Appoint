package com.dgut.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/*预约信息控制器
* 用于处理与预约相关的请求*/

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/isAppointed")
    public JSONObject isAppointed(HttpSession session){
        return orderService.isAppointed(session);
    }

    @RequestMapping("/appointSubmit")
    public JSONObject appoint(HttpSession session, @RequestBody JSONObject data){
        return orderService.addAppoint(session, data);
    }

    @RequestMapping("/getAllAppoints")
    public JSONObject getAllAppoints(HttpSession session){
        return orderService.getAllAppoints(session);
    }
}
