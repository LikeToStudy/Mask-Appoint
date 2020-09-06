package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.NeedProduct;
import com.dgut.domain.Product;
import com.dgut.mapper.ProductMapper;
import com.dgut.service.ProductService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, JsonHelper jsonHelper){
        this.productMapper = productMapper;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JSONObject search(String searchStr) {
        searchStr = "%"+searchStr+"%";
        List<String> list = productMapper.getSurplusProductName(searchStr);
        if (list == null || list.size() == 0) return jsonHelper.search(2, list);
        else return jsonHelper.search(1, list);
    }

    @Override
    public JSONObject addProduct(String proName, int proStock) {
        String pro_id = productMapper.getProIDByProName(proName);
        if (pro_id == null || pro_id.equals("")){
            Product product = new Product(proName, proStock);
            int result = productMapper.insertProduct(product);
            if (result > 0) return jsonHelper.operator(1);
            else return jsonHelper.operator(2);
        }
        else {
            int result = productMapper.updateProStock(pro_id, proStock);
            if (result > 0) return jsonHelper.operator(1);
            else return jsonHelper.operator(2);
        }
    }

    @Override
    public JSONObject getProStock(String proName) {
        String proID = productMapper.getProIDByProName(proName);
        int stock = productMapper.getProStockByProID(proID);
        JSONObject jsonObject = jsonHelper.operator(1);
        jsonObject.put("productStock", stock);
        return jsonObject;
    }

    @Override
    public JSONObject addNeedProduct(String needProduct) {
        NeedProduct product = new NeedProduct(needProduct);
        int result = productMapper.insertNeedProduct(product);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }
}
