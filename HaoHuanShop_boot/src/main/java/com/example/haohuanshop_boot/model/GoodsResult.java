package com.example.haohuanshop_boot.model;

public class GoodsResult {
    private String name;
    private String url;

    public GoodsResult() {
    }

    public GoodsResult(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
