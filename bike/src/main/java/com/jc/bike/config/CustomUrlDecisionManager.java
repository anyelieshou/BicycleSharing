package com.jc.bike.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import sun.security.x509.AccessDescription;

import java.util.Collection;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.config
 * @className: MyDesicionManager
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/19 13:57
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/19 13:57     lijp6      v1.1.0              修改原因
 **/
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute:configAttributes) {
            String needRole = configAttribute.getAttribute();
            if("ROLE_LOGIN".equals(needRole)){
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw  new AccessDeniedException("尚未登录，请登录！");
                }else {
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority:authorities) {
                if(authority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}