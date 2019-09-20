package com.example.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.example.mybatis.entity.Order;
import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrderController {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String getOrders(){
        logger.info("======这是一个简单地查询操作=======");
        List<Order> orders = null;
        try {
            orders = orderService.getOrders();
        }catch (Exception e){
            logger.debug("",e);
           // return "fail";
        }
        return JSON.toJSONString(orders);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public void save(Order order){
        logger.info("=====================插入数据===========");
        orderService.insert(order);
    }

    @RequestMapping(value = "/id")
    public Order find(Long id){
        logger.debug("=========更具ID查询单条记录 =============");
        Order order = orderService.find(id);
        return  order;
    }

    /**
     * http://localhost:8080/orders/page?pageNo=2&pageSize=2
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/page", produces = "application/json;charset=UTF-8")
    public String getOrdersByPage(Integer pageNo, Integer pageSize){
        logger.debug("=============分页查询操作===========");
        Page<Order> orders = orderService.getOrdersByPage(pageNo, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return JSON.toJSONString(pageInfo);
    }
}
