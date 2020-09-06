package com.dgut.mapper;

import com.dgut.domain.NeedProduct;
import com.dgut.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    /*select*/
    List<String> getSurplusProductName(String searchStr);

    String getProIDByProName(String proName);

    int getProStockByProID(String proID);

    /*update*/

    int updateProStock(String proID, int proStock);

    /*insert*/

    int insertProduct(Product product);

    int insertNeedProduct(NeedProduct needProduct);

    
}
