package com.jc.bike.mapper;

import com.jc.bike.model.Rent;

public interface RentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);
}