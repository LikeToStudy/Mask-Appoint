package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.AppointLog;
import com.dgut.domain.TempAppointLog;
import com.dgut.mapper.OrderMapper;
import com.dgut.mapper.ProductMapper;
import com.dgut.service.OrderService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    private ProductMapper productMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, JsonHelper jsonHelper
    , ProductMapper productMapper){
        this.orderMapper = orderMapper;
        this.jsonHelper = jsonHelper;
        this.productMapper = productMapper;
    }

    @Override
    public JSONObject isAppointed(HttpSession session) {
        String userID = (String)session.getAttribute("UID");
        List<AppointLog> list = orderMapper.getIncompleteAppoint(userID);
        if (list.size() > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject addAppoint(HttpSession session, JSONObject data) {
        String userID = (String)session.getAttribute("UID");
        int quantity = Integer.parseInt((String)data.get("quantity"));
        String productName = data.getString("productName");
        String proID = productMapper.getProIDByProName(productName);
        int proStock = productMapper.getProStockByProID(proID);
        proStock = proStock - quantity;
        AppointLog appointLog = new AppointLog(userID, 0);
        int result1 = orderMapper.insertAppointInfo(appointLog);
        int result2 = productMapper.updateProStock(proID, proStock);
        if (result1 == 1 && result2 == 1) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject getAllAppoints(HttpSession session) {
        String userID = (String)session.getAttribute("UID");
        orderMapper.updateAppointStatus(userID);
        List<AppointLog> list = orderMapper.getAppointList(userID);
        List<TempAppointLog> list1 = new ArrayList<>();
        for (AppointLog log:list){
            String time = log.getAppointTime();
            String speed;
            if (log.getIsComplete() == 0) speed = "预约完成，等待送达！";
            else speed = "成功送达，预约成功！";
            TempAppointLog temp = new TempAppointLog(time, speed);
            list1.add(temp);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appointments", list1);
        return jsonObject;
    }
}
