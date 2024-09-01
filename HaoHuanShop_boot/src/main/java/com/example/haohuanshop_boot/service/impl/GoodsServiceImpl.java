package com.example.haohuanshop_boot.service.impl;

import com.example.haohuanshop_boot.mapper.GoodsMapper;
import com.example.haohuanshop_boot.model.GoodsResult;
import com.example.haohuanshop_boot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsResult> getShowGoodsList(String word) {
        return goodsMapper.selectGoodsByKeyword(word);
    }
}
