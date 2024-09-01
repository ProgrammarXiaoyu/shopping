package com.example.haohuanshop_boot.model;

import java.sql.Timestamp;

public class OrderResult {
    private int orderId;
    private Timestamp time;
    private String phone;
    private int goodsId;
    private String payWay;
    private String goodsName;
    private double amount;
    private String url;

    public OrderResult() {
    }

    public OrderResult(Timestamp time, int orderId, String goodsName, double amount, String phone, String payWay,String url,int goodsId) {
        this.time = time;
        this.orderId = orderId;
        this.goodsName = goodsName;
        this.amount = amount;
        this.phone = phone;
        this.payWay = payWay;
        this.url = url;
        this.goodsId = goodsId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
