package com.example.haohuanshop_boot.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private Integer id;

    private Date date;

    private String userid;

    private Integer goodsid;

    private String way;

    public Order(String userId, int goodsId, String way) {
        Date date = new Date();

        this.id = 0;
        this.date = new Timestamp(date.getTime());
        this.userid = userId;
        this.goodsid = goodsId;
        this.way = way;
    }

    public Order(int id, Timestamp time, String userId, int goodsId, String way) {
        this.id = id;
        this.date = time;
        this.userid = userId;
        this.goodsid = goodsId;
        this.way = way;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}