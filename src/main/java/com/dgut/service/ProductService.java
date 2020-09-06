package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

public interface ProductService {
    JSONObject search(String searchStr);

    JSONObject addProduct(String proName, int proStock);

    JSONObject getProStock(String proName);

    JSONObject addNeedProduct(String needProduct);
}
