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

    //修改密码
    Integer updatePassword(@Param("id")Integer id,@Param("encodePass") String encodePass);

    //更新用户头像
    Integer updateUserface(@Param("url")String url,@Param("id") Integer id);

    List<User> getAllUsers(@Param("userid") Integer userid,@Param("keywords") String keywords);
}