package com.jc.bike.service;

import com.jc.bike.mapper.OrderMapper;
import com.jc.bike.mapper.ShopCartMapper;
import com.jc.bike.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.service
 * @className: OrderService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/23 21:15
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/23 21:15     lijp6      v1.1.0              修改原因
 **/
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public Integer addOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    //根据用户id查询所有订单
    public List<Order> getAllOrdersByUserId(Integer userid){
        return orderMapper.getAllOrdersByUserId(userid);
    }

    public Integer deleteOrderById(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteOrderByIds(Integer[] ids) {
        return orderMapper.deleteOrderByIds(ids);
    }
}