package com.jc.bike.mapper;

import com.jc.bike.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getAllOrdersByUserId(Integer userid);

    Integer deleteOrderByIds(@Param("ids")Integer[] ids);
}