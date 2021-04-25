package com.jc.bike.mapper;

import com.jc.bike.model.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void deleteByUserid(Integer userid);

    Integer addUserRole(@Param("userid") Integer userid, @Param("rids") Integer[] rids);
}