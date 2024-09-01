package com.example.haohuanshop_boot.service.impl;

import com.example.haohuanshop_boot.entity.User;
import com.example.haohuanshop_boot.mapper.UserMapper;
import com.example.haohuanshop_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User userLogin(String phone, String password) {
        User user = userMapper.selectByPrimaryKeyAndPassword(phone,password);

        return user;
    }

    @Override
    public int chargeByPhoneNo(String phoneNo, Integer amount) {
        return userMapper.updateBalanceByPhoneNo(phoneNo,amount);
    }

    @Override
    public int registerUser(User user) {
        User data = userMapper.selectByPrimaryKey(user.getPhoneno());

        if(null != data){
            return 0;
        }

        return userMapper.insert(user);
    }
}
