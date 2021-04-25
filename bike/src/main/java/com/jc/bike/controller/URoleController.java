package com.jc.bike.controller;

import com.jc.bike.config.UserUtils;
import com.jc.bike.model.RespBean;
import com.jc.bike.model.Role;
import com.jc.bike.model.User;
import com.jc.bike.service.RoleService;
import com.jc.bike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller.test
 * @className: URoleController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/4/22 21:42
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/4/22 21:42     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/sys/urole")
public class URoleController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<User> getAllUsers(String keywords){
        return userService.getAllUsers(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody User user) {
        if (userService.updateUser(user) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer userid, Integer[] rids) {
        if (userService.updateUserRole(userid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

//    @DeleteMapping("/{id}")
//    public RespBean deleteHrById(@PathVariable Integer id) {
//        if (hrService.deleteHrById(id) == 1) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
}