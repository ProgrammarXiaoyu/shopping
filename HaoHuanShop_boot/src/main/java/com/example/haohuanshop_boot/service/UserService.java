package com.example.haohuanshop_boot.service;

import com.example.haohuanshop_boot.entity.User;

public interface UserService {
    /**
     * 验证用户登录信息
     * @param phone 用户输入的手机号
     * @param password  用户输入的密码
     * @return  手机号和密码所匹配的用户，如果错了返回空
     */
    User userLogin(String phone,String password);

    int chargeByPhoneNo(String phoneNo,Integer amount);

    int registerUser(User user);
}
