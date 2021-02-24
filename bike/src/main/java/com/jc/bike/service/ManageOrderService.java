package com.jc.bike.service;

import com.jc.bike.mapper.OrderMapper;
import com.jc.bike.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.service
 * @className: ManageOrderService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/24 18:12
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/24 18:12     lijp6      v1.1.0              修改原因
 **/
@Service
public class ManageOrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> getAllOrders(Integer status) {
        return orderMapper.getAllOrdersByManagment(status);
    }

    public Order getOrderById(Integer id,Integer status) {
        return orderMapper.getOrderById(id,status);
    }

    public Integer acceptOrder(Integer id,Integer status) {
//        //所减库存
//        int count = orderMapper.quertCount(id);
        return orderMapper.acceptOrder(id,status);
    }
}