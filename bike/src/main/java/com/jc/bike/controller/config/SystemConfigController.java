package com.jc.bike.controller.config;

import com.jc.bike.model.Menu;
import com.jc.bike.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 * @package: com.jc.bike.controller
 * @className: SystemConfigController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/5 18:51
 *
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/5 18:51     lijp6      v1.1.0              修改原因
 **/
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public List<Menu> getMenusByUserId(){
        return menuService.getMenusByUserId();
    }
}