package com.dgut.domain;

import java.util.UUID;

public class User {
    private String userID;
    private String username;
    private String password;
    private String userSex;
    private String userBirth;
    private String userPhone;
    private String userNation;
    private String userAddress;
    private String userReceiptPhone;
    private String userEmail;

    public User() {
        super();
    }

    public User(String username, String password) {
        this.userID = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public User(String userID, String username, String userSex, String userBirth, String userPhone, String userNation, String userAddress, String userReceiptPhone, String userEmail) {
        this.userID = userID;
        this.username = username;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userNation = userNation;
        this.userAddress = userAddress;
        this.userReceiptPhone = userReceiptPhone;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNation='" + userNation + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userReceiptPhone='" + userReceiptPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserReceiptPhone() {
        return userReceiptPhone;
    }

    public void setUserReceiptPhone(String userReceiptPhone) {
        this.userReceiptPhone = userReceiptPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
