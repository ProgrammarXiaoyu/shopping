package com.example.haohuanshop_boot.service.impl;

import com.example.haohuanshop_boot.entity.Order;
import com.example.haohuanshop_boot.entity.User;
import com.example.haohuanshop_boot.mapper.OrderMapper;
import com.example.haohuanshop_boot.mapper.UserMapper;
import com.example.haohuanshop_boot.model.OrderResult;
import com.example.haohuanshop_boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<OrderResult> queryOrder(String phoneNo) {
        List<OrderResult> orders = orderMapper.selectAllOrdersByUserId(phoneNo);    //  订单展示model

        return orders;
    }

    @Override
    public boolean purchaseGoods(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("key");

        String userId = user.getPhoneno();
        String goodsId = request.getParameter("goodsId");
        String way = request.getParameter("way");
        Integer price = Integer.parseInt(request.getParameter("price"));

        if(user.getBalance() >= price){    //  钱足够支付
            //  更新用户数据
            user.setBalance(user.getBalance() - price);
            userMapper.updateBalanceByPhoneNo(userId,user.getBalance());

            //  更新订单数据
            Order order = new Order(userId,Integer.parseInt(goodsId),way);
            orderMapper.insert(order);

            //  更新网页显示
            session.setAttribute("key",user);
            return true;
        }

        return false;
    }
}