package com.jc.bike.controller;

import com.jc.bike.model.RespBean;
import com.jc.bike.model.User;
import com.jc.bike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: UserController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/19 17:40
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/19 17:40     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/")
    public RespBean addUser(@RequestBody User user){
        if(userService.addUser(user)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updateUser(@RequestBody User user){
        if(userService.updateUser(user)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deletdUserById(@PathVariable Integer id){
        if(userService.deletdUserById(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deletdUserByIds(Integer[] ids){
        if(userService.deletdUserByIds(ids)==ids.length){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}