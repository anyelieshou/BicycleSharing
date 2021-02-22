package com.jc.bike.service;

import com.jc.bike.mapper.ShopCartMapper;
import com.jc.bike.model.ShopCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.service
 * @className: ShopCartService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/22 16:24
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/22 16:24     lijp6      v1.1.0              修改原因
 **/
@Service
public class ShopCartService {
    @Autowired
    ShopCartMapper shopCartMapper;

    public Integer addBikeInShopCart(ShopCart record){
        return shopCartMapper.insert(record);
    }

    public List<ShopCart> getShops(Integer userId){
        return shopCartMapper.selectShopByUserId(userId);
    }

    public Integer deleteShopById(Integer id) {
        return shopCartMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteShopByIds(Integer[] ids) {
        return shopCartMapper.deleteShopByIds(ids);
    }
}