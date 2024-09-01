package com.example.haohuanshop_boot.web;

import com.example.haohuanshop_boot.entity.User;
import com.example.haohuanshop_boot.model.OrderResult;
import com.example.haohuanshop_boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("key")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/user/orders")
    public String toOrders(Model model, HttpSession session){
        User user = (User) session.getAttribute("key");

        List<OrderResult> orders = orderService.queryOrder(user.getPhoneno());

        model.addAttribute("orderList",orders);

        return "orderList";
    }

    @RequestMapping(value = "/goods")
    public String toDetail(@RequestParam("url") String url){
        return url;
    }

    @RequestMapping(value = "/purchase")
    public String purchase(HttpServletRequest request){
        boolean flag = orderService.purchaseGoods(request);

        if(flag)    //  购买成功
            return "purchaseSuccess";
        else
            return "purchaseFail";
    }
}
