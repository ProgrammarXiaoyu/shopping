package com.example.haohuanshop_boot.entity;

public class User {
    private String phoneNo;

    private String password;

    private Integer balance;

    public String getPhoneno() {
        return phoneNo;
    }

    public void setPhoneno(String phoneno) {
        this.phoneNo = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public User() {
    }

    public User(String phoneno, String password, Integer balance) {
        this.phoneNo = phoneno;
        this.password = password;
        this.balance = balance;
    }
}