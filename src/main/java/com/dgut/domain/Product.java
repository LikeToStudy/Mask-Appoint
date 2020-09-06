package com.dgut.domain;

import java.util.UUID;

public class Product {
    private String proID;
    private String proName;
    private int proStock;

    public Product() {
        super();
    }

    public Product(String proName, int proStock) {
        this.proID = UUID.randomUUID().toString();
        this.proName = proName;
        this.proStock = proStock;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProStock() {
        return proStock;
    }

    public void setProStock(int proStock) {
        this.proStock = proStock;
    }
}
