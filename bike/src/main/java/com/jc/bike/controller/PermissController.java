package com.jc.bike.controller;

import com.jc.bike.model.Menu;
import com.jc.bike.model.RespBean;
import com.jc.bike.model.Role;
import com.jc.bike.service.MenusService;
import com.jc.bike.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: PermissController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/27 19:18
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/27 19:18     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/sys/role")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenusService menusService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menusService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menusService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if(menusService.updateMenuRole(rid,mids)){
            return  RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/add")
    public RespBean addRole(@RequestBody Role role){
        if(roleService.addRole(role)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/delete/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if(roleService.deleteRoleById(rid)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败");
    }
}