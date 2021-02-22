package com.jc.bike.mapper;

import com.jc.bike.model.Role;
import com.jc.bike.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);

    List<User> getAllUser();

    Integer deletdUserByIds(@Param("ids") Integer[] ids);
}