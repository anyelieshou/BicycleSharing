package com.jc.bike.mapper;

import com.jc.bike.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int acceptOrder(Order order);

    //根据用户id查询订单
    List<Order> getAllOrdersByUserId(@Param("userid") Integer userid,@Param("status") Integer status);

    //管理员查询所有订单
    List<Order> getAllOrdersByManagment(@Param("status") Integer status);

    //根据id查询订单详情
    Order getOrderById(@Param("id") Integer id,@Param("status") Integer status);

    Integer deleteOrderByIds(@Param("ids")Integer[] ids);

    int quertCount(Integer id);
}