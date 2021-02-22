package com.jc.bike.config;

import com.jc.bike.model.Menu;
import com.jc.bike.model.Role;
import com.jc.bike.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.config
 * @className: MyFilter
 * @description 这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/19 13:27
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/19 13:27     lijp6      v1.1.0              修改原因
 **/
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu:menus
             ) {
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] str=new String[roles.size()];
                for (int i = 0; i <roles.size() ; i++) {
                    str[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        //role_login仅仅是标记
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}