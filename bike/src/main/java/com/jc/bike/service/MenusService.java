package com.jc.bike.service;

import com.jc.bike.mapper.MenuMapper;
import com.jc.bike.mapper.MenuRoleMapper;
import com.jc.bike.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.service
 * @className: MenusService
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/27 19:54
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/27 19:54     lijp6      v1.1.0              修改原因
 **/
@Service
public class MenusService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        return result==mids.length;
    }
}