package com.jc.bike.service;

import com.jc.bike.mapper.MenuMapper;
import com.jc.bike.model.Menu;
import com.jc.bike.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 * @package: com.jc.bike.service
 * @className: MenuService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/5 18:55
 *
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/5 18:55     lijp6      v1.1.0              修改原因
 **/
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getMenusByUserId() {
        List<Menu> menus = menuMapper.getMenusByUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return menus;
    }

    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }
}