package com.jc.bike.controller;

import com.jc.bike.model.Order;
import com.jc.bike.model.RespBean;
import com.jc.bike.service.ManageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: ManageOrderController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/24 18:11
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/24 18:11     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/lease/ordermanagement")
public class ManageOrderController {
    @Autowired
    ManageOrderService manageOrderService;

    @GetMapping("/")
    public List<Order> getAllOrders(@RequestParam("status") Integer status){
        return manageOrderService.getAllOrders(status);
    }
    @GetMapping("/{id}&{status}")
    public Order getOrderById(@PathVariable Integer id ,@PathVariable Integer status){
        return manageOrderService.getOrderById(id,status);
    }

    @PutMapping("/")
    public RespBean acceptOrder(@RequestBody Order order){
        if(order.getStatus()==3){
            order.setBacktime(new Date());
            if(manageOrderService.acceptOrder(order)==1){
                return RespBean.ok("还车成功！");
            }
            return RespBean.error("还车失败");
        }
        if(order.getStatus()==2){
            if(manageOrderService.acceptOrder(order)==1){
                return RespBean.ok("订单已接收！");
            }
            return RespBean.error("订单接收失败");
        }
        return RespBean.error("错误异常");
    }
}