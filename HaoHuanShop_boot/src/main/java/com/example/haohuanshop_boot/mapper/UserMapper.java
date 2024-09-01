package com.example.haohuanshop_boot.mapper;

import com.example.haohuanshop_boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String phoneno);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String phoneno);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPrimaryKeyAndPassword(@Param("phoneNo") String phoneNo,@Param("password") String password);

    int updateBalanceByPhoneNo(@Param("phoneNo") String phoneNo,@Param("amount") Integer amount);
}