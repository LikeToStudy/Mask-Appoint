package com.dgut.domain;

import java.util.UUID;

public class NeedProduct {
    private String proID;
    private String proName;

    public NeedProduct(String proName) {
        this.proID = UUID.randomUUID().toString();
        this.proName = proName;
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
}
