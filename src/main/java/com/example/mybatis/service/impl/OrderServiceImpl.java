package com.example.mybatis.service.impl;

import com.example.mybatis.entity.Order;
import com.example.mybatis.mapper.OrderMapper;
import com.example.mybatis.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public void insert( Order order ) {
        orderMapper.insert(order);
    }

    @Override
    public Order find( Long id ) {
        return orderMapper.find(id);
    }

    @Override
    public Page<Order> getOrdersByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return orderMapper.getOrdersByPage();
    }
}
