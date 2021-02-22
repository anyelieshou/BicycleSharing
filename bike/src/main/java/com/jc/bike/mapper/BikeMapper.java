package com.jc.bike.mapper;

import com.jc.bike.model.Bike;

import java.util.List;

public interface BikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bike record);

    int insertSelective(Bike record);

    Bike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bike record);

    int updateByPrimaryKey(Bike record);

    List<Bike> getAllBikes();
}