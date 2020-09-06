package com.dgut.mapper;

import com.dgut.domain.NeedProduct;
import com.dgut.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void TestAddProduct(){
        Product product = new Product("test-mask"+ UUID.randomUUID().toString(), 10000);
        Assert.assertSame("Test: TestProductMapper:testAddProduct Failed!",
                1, productMapper.insertProduct(product));
    }

    @Test
    public void TestSurplusProductName(){
        String s = "%口罩%";
        List<String> list = productMapper.getSurplusProductName(s);
        for (String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void TestGetProIDByProName(){
        String s = "一次性防护口罩";
        String str = productMapper.getProIDByProName(s);
        System.out.println(str);
    }

    @Test
    public void TestGetProStockByProID(){
        String proID = "c497f647-434c-41a7-87c1-f2b41065f1aa";
        int stock = productMapper.getProStockByProID(proID);
        System.out.println(stock);
    }

    @Test
    public void TestUpdateProStock(){
        String proID = "c497f647-434c-41a7-87c1-f2b41065f1aa";
        int stock = 5000;
        Assert.assertSame("Test: TestProductMapper:TestUpdateProStock Failed!",
                1, productMapper.updateProStock(proID, stock));
    }

    @Test
    public void TestInsertNeedProduct(){
        NeedProduct product = new NeedProduct("test-need-mask"+UUID.randomUUID().toString());
        Assert.assertSame("Test: TestProductMapper:TestInsertNeedProduct Failed!",
                1, productMapper.insertNeedProduct(product));
    }
}
