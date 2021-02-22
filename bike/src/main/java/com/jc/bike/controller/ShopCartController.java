package com.jc.bike.controller;

import com.jc.bike.config.SecurityConfig;
import com.jc.bike.model.RespBean;
import com.jc.bike.model.ShopCart;
import com.jc.bike.model.User;
import com.jc.bike.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: ShopCartController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/22 16:22
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/22 16:22     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/lease/shopcart")
public class ShopCartController {
    @Autowired
    ShopCartService shopCartService;

    @PostMapping("/")
    public RespBean addBikeInShopCart(@RequestBody ShopCart shopCart){
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        shopCart.setUserid(user.getId());
        if(shopCartService.addBikeInShopCart(shopCart)==1){
            return RespBean.ok("已添加至购物车!");
        }
        return RespBean.error("添加失败!");
    }

    @GetMapping("/")
    public List<ShopCart> getShops(){
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return shopCartService.getShops(user.getId());
    }

    @DeleteMapping("/{id}")
    public RespBean deleteShopById(@PathVariable Integer id){
        if(shopCartService.deleteShopById(id)==1){
            return RespBean.ok("删除成功！");
        }
        return  RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteShopByIds(Integer[] ids){
        if(shopCartService.deleteShopByIds(ids)==ids.length){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}