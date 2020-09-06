package com.dgut.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonHelper {
    //登录状态常数
    public static final int LOGIN_SUCCESS;  //登录成功
    public static final int USERNAME_WRONG; //用户名错误
    public static final int PASSWORD_WRONG; //密码错误
    public static final int UID_WRONG;      //用户ID错误
    public static final int LOGGED_OUT;     //用户未登录
    public static final int LOGGED_IN;      //用户已登录

    //通用常数
    public static final int SUCCESS;     //操作成功
    public static final int FAILED;      //操作失败

    //产品搜索常数
    public static final int SEARCH_SUCCESS;     //查询成功
    public static final int SEARCH_FAILED;      //查询失败
    static {
        LOGIN_SUCCESS = 1;
        USERNAME_WRONG = 2;
        PASSWORD_WRONG = 3;
        LOGGED_OUT = 4;
        LOGGED_IN = 5;
        UID_WRONG = 6;

        SUCCESS = 1;
        FAILED = 2;

        SEARCH_SUCCESS = 1;
        SEARCH_FAILED = 2;
    }

    public JSONObject login(int mark){
        JSONObject jsonObject = new JSONObject();
        if (mark == LOGIN_SUCCESS) {
            jsonObject.put("result", true);
            jsonObject.put("message", "登录成功");
        }
        else if (mark == USERNAME_WRONG){
            jsonObject.put("result", false);
            jsonObject.put("message", "用户不存在");
        }
        else if (mark == PASSWORD_WRONG){
            jsonObject.put("result", false);
            jsonObject.put("message", "密码错误");
        }
        else if (mark == LOGGED_OUT){
            jsonObject.put("result", false);
            jsonObject.put("message", "用户未登录");
        }
        else if (mark == LOGGED_IN){
            jsonObject.put("result", true);
            jsonObject.put("message", "用户已登录");
        }
        else if (mark == UID_WRONG){
            jsonObject.put("result", false);
            jsonObject.put("message", "用户ID不存在");
        }
        else {
            jsonObject.put("result", false);
            jsonObject.put("message", "JsonHelper_login参数错误");
        }
        return jsonObject;
    }

    public JSONObject operator(int mark){
        JSONObject jsonObject = new JSONObject();
        if (mark == SUCCESS) {
            jsonObject.put("result", true);
        }
        else if (mark == FAILED){
            jsonObject.put("result", false);
        }
        return jsonObject;
    }

    public JSONObject search(int mark, List<String> list){
        JSONObject jsonObject = new JSONObject();
        if (mark == SUCCESS) {
            jsonObject.put("result", true);
            jsonObject.put("uris", list);
        }
        else if (mark == FAILED){
            jsonObject.put("result", false);
            jsonObject.put("uris", null);
        }
        return jsonObject;
    }
}
