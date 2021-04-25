package com.jc.bike.config;

import com.jc.bike.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.config
 * @className: UserUtils
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/4/22 21:48
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/4/22 21:48     lijp6      v1.1.0              修改原因
 **/
public class UserUtils {
    public static User getCurrentUser(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}