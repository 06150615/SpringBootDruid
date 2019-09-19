package com.example.mybatis.mapper;

import com.example.mybatis.entity.Order;
import com.github.pagehelper.Page;

import java.util.List;


public interface OrderMapper {
    List<Order> getOrders();

    Page<Order> getOrdersByPage();

    void  insert(Order order);

    Order find(Long id);
}
