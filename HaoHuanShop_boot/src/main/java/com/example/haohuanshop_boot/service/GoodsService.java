package com.example.haohuanshop_boot.service;

import com.example.haohuanshop_boot.model.GoodsResult;

import java.util.List;

public interface GoodsService {
    public List<GoodsResult> getShowGoodsList(String word);
}
