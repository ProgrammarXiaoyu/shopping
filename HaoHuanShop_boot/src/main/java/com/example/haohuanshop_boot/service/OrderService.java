package com.example.haohuanshop_boot.service;

import com.example.haohuanshop_boot.model.OrderResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService {
    List<OrderResult> queryOrder(String phoneNo);

    boolean purchaseGoods(HttpServletRequest request);
}