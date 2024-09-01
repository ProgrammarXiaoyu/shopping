package com.example.haohuanshop_boot.mapper;

import com.example.haohuanshop_boot.entity.Order;
import com.example.haohuanshop_boot.model.OrderResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    List<OrderResult> selectAllOrdersByUserId(@Param("userId") String phoneNo);

    int insertSelective(Order record);
}