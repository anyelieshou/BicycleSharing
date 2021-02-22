package com.jc.bike.mapper;

import com.jc.bike.model.ShopCart;

public interface ShopCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
}