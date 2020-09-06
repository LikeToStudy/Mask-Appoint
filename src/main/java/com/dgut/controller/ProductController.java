package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/search")
    public JSONObject search(@RequestBody JSONObject data){
        String searchStr = data.getString("searchContent");
        return productService.search(searchStr);
    }

    @RequestMapping("/queryStock")
    public JSONObject queryStock(@RequestBody JSONObject data){
        String productName = data.getString("productName");
        return productService.getProStock(productName);
    }

    @RequestMapping("/addNeedProduct")
    public JSONObject addNeedProduct(@RequestBody JSONObject data){
        String needProduct = data.getString("needProduct");
        return productService.addNeedProduct(needProduct);
    }
}
