package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.User;
import com.dgut.mapper.UserMapper;
import com.dgut.service.UserService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, JsonHelper jsonHelper){
        this.userMapper = userMapper;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JSONObject login(String username, String password, HttpSession session) {
        String uid = userMapper.getUIDByUsername(username);
        if (uid == null || uid.equals("")) return jsonHelper.login(2);
        else {
            uid = null;
            uid = userMapper.getUIDByUserInfo(username, password);

            if (uid == null || uid.equals("")) return jsonHelper.login(3);
            else {
                session.setAttribute("UID", uid);
                return jsonHelper.login(1);
            }
        }
    }

    @Override
    public JSONObject register(String username, String password, HttpSession session) {
        String uid = userMapper.getUIDByUsername(username);
        if (uid == null || uid.equals("")){
            User user = new User(username, password);
            int result = userMapper.addUser(user);
            if (result == 1){
                session.setAttribute("UID", user.getUserID());
                return jsonHelper.operator(1);
            }
            else return jsonHelper.operator(2);
        }
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject isLogin(HttpSession session) {
        String uid = (String)session.getAttribute("UID");
        if (uid != null && !uid.equals("")){
            JSONObject jsonObject = jsonHelper.operator(1);
            jsonObject.put("name", userMapper.getUsernameByUID(uid));
            return jsonObject;
        }
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject logout(HttpSession session) {
        String uid = (String)session.getAttribute("UID");
        if (uid != null && !uid.equals("")){
            session.invalidate();
            return jsonHelper.operator(1);
        }
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject getUserInfo(HttpSession session) {
        String userID = (String)session.getAttribute("UID");
        User user = userMapper.getUser(userID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", user.getUsername());
        if (user.getUserSex() == null) jsonObject.put("userSex", "");
        else jsonObject.put("userSex", user.getUserSex());
        if (user.getUserSex() == null) jsonObject.put("userBirth", "");
        else jsonObject.put("userBirth", user.getUserBirth());
        if (user.getUserSex() == null) jsonObject.put("userPhone", "");
        else jsonObject.put("userPhone", user.getUserPhone());
        if (user.getUserSex() == null) jsonObject.put("userNation", "");
        else jsonObject.put("userNation", user.getUserNation());
        if (user.getUserSex() == null) jsonObject.put("userAddress", "");
        else jsonObject.put("userAddress", user.getUserAddress());
        if (user.getUserSex() == null) jsonObject.put("userPhoneNumber", "");
        else jsonObject.put("userPhoneNumber", user.getUserReceiptPhone());
        if (user.getUserSex() == null) jsonObject.put("userEmail", "");
        else jsonObject.put("userEmail", user.getUserEmail());
        return jsonObject;
    }

    @Override
    public JSONObject isOfferAddressInfo(HttpSession session) {
        String uid = (String)session.getAttribute("UID");
        String result = userMapper.isOfferAddressInfo(uid);
        if (result == null) {
            return jsonHelper.operator(2);
        }
        else return jsonHelper.operator(1);
    }

    @Override
    public JSONObject updateUserInfo(HttpSession session, JSONObject data) {
        String uid = (String)session.getAttribute("UID");
        String changeName = data.getString("changeName");
        String changeSex = data.getString("changeSex");
        String changeBirth = data.getString("changeBirth");
        String changePhone = data.getString("changePhone");
        String changeNation = data.getString("changeNation");
        String changeAddress = data.getString("changeAddress");
        String changePhoneNumber = data.getString("changePhoneNumber");
        String changeEmail = data.getString("changeEmail");
        User user = new User(uid, changeName, changeSex, changeBirth, changePhone, changeNation
        , changeAddress, changePhoneNumber, changeEmail);
        int result = userMapper.updateAllInfo(user);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }
}
