package com.example.haohuanshop_boot.web;

import com.example.haohuanshop_boot.entity.User;
import com.example.haohuanshop_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("key")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        User user = userService.userLogin(username,password);

         if(null != user){
            model.addAttribute("key",user);
            return "redirect:index";
        }

        return "fail";
    }
}
