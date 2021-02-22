package com.jc.bike.service;

import com.jc.bike.mapper.UserMapper;
import com.jc.bike.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 * @package: com.jc.bike.service
 * @className: UserService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/5 1:07
 *
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/5 1:07     lijp6      v1.1.0              修改原因
 **/
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if(user==null){
           throw new UsernameNotFoundException("用户名不存在");
       }
       user.setRoles(userMapper.getUserRolesById(user.getId()));
        return user;
    }

    //获取所有学生用户信息列表
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
    //增加学生用户信息
    public Integer addUser(User user) {
        user.setEnabled(true);
        return userMapper.insertSelective(user);
    }

    //更新学生用户信息
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer deletdUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public Integer deletdUserByIds(Integer[] ids) {
        return userMapper.deletdUserByIds(ids);
    }
}