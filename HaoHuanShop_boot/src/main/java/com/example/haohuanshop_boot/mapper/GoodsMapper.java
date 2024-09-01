package com.example.haohuanshop_boot.mapper;

import com.example.haohuanshop_boot.entity.Goods;
import com.example.haohuanshop_boot.model.GoodsResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<GoodsResult> selectGoodsByKeyword(@Param("word") String word);
}