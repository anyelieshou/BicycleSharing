package com.jc.bike.controller;

import com.jc.bike.model.Order;
import com.jc.bike.model.RespBean;
import com.jc.bike.model.User;
import com.jc.bike.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: OrderController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/23 21:07
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/23 21:07     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/lease/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public RespBean addOrder(@RequestBody Order order){
        order.setStatus(1);
        order.setCreatetime(new Date());
        System.out.println(order.getCreatetime());
        if(orderService.addOrder(order)==1){
            return RespBean.ok("下单成功！");
        }
        return RespBean.error("下单失败！");
    }

    @GetMapping("/")
    public List<Order> getAllOrdersByUserId(@RequestParam("status") Integer status){
        //获取用户id
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.getAllOrdersByUserId(user.getId(),status);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteOrderById(@PathVariable Integer id){
        if(orderService.deleteOrderById(id)==1){
            return RespBean.ok("取消订单成功！");
        }
        return  RespBean.error("取消订单失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteShopByIds(Integer[] ids){
        if(orderService.deleteOrderByIds(ids)==ids.length){
            return RespBean.ok("取消订单成功！");
        }
        return RespBean.error("取消订单失败！");
    }
}