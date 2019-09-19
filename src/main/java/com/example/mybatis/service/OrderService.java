package com.example.mybatis.service;

import com.example.mybatis.entity.Order;
import com.github.pagehelper.Page;

import java.util.List;


public interface OrderService {

    List<Order> getOrders();

    Page<Order> getOrdersByPage(Integer pageNo, Integer pageSize);

    void insert(Order order);

    Order find(Long id);
}
