package com.jc.bike.mapper;

import com.jc.bike.model.BikeRent;

public interface BikeRentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BikeRent record);

    int insertSelective(BikeRent record);

    BikeRent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BikeRent record);

    int updateByPrimaryKey(BikeRent record);
}