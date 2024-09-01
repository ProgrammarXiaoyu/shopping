package com.example.haohuanshop_boot.web;

import com.example.haohuanshop_boot.entity.User;
import com.example.haohuanshop_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public @ResponseBody String register(@RequestParam("phoneNo") String phoneNo, @RequestParam("password") String password){
        User user = new User(phoneNo,password,0);
        int ret = userService.registerUser(user);

        if (ret == 1)
            return "注册成功，跳转到登录页！";

        return "注册失败，当前手机号已注册！";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }
}