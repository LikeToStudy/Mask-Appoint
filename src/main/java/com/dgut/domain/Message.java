package com.dgut.domain;

import java.util.UUID;

public class Message {
    private String mesID;
    private String mesContent;

    public Message() {
        super();
    }

    public Message(String mesContent) {
        this.mesID = UUID.randomUUID().toString();
        this.mesContent = mesContent;
    }

    public String getMesID() {
        return mesID;
    }

    public void setMesID(String mesID) {
        this.mesID = mesID;
    }

    public String getMesContent() {
        return mesContent;
    }

    public void setMesContent(String mesContent) {
        this.mesContent = mesContent;
    }
}
