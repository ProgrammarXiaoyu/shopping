package com.example.haohuanshop_boot.web;

import com.example.haohuanshop_boot.entity.User;
import com.example.haohuanshop_boot.model.GoodsResult;
import com.example.haohuanshop_boot.service.GoodsService;
import com.example.haohuanshop_boot.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("key")
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/user/charge")
    public String charge(@RequestParam("phoneNo") String phoneNo, @RequestParam("password") String password, @RequestParam("balance") Integer balance, @RequestParam("amount") Integer amount, Model model){
        userService.chargeByPhoneNo(phoneNo,balance + amount);

        User user = new User(phoneNo,password,balance + amount);
        model.addAttribute("key",user);

        return "index";
    }

    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/list")
    public String toList(){
        return "list";
    }

    @RequestMapping(value = "/user/logoff")
    public String logoff(HttpSession session, SessionStatus sessionStatus){
        session.removeAttribute("key");
        sessionStatus.setComplete();

        return "redirect:index";
    }

    @RequestMapping(value = "/search")
    public @ResponseBody String search(@RequestParam("word") String word){
        List<GoodsResult> list = goodsService.getShowGoodsList(word);

        if(!list.isEmpty()) {
            try {
                return objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
