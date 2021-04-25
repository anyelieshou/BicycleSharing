package com.jc.bike.controller;

import com.jc.bike.config.FastDFSUtils;
import com.jc.bike.model.RespBean;
import com.jc.bike.model.User;
import com.jc.bike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.controller
 * @className: UserInfoController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/27 18:18
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/27 18:18     lijp6      v1.1.0              修改原因
 **/
@RestController
public class UserInfoController {

    @Autowired
    UserService userService;

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    //获取用户登录信息
    @GetMapping("/user/info")
    public User getCurrentUser(Authentication authentication){
        return (User) authentication.getPrincipal();
    }

    //更新用户信息
    @PutMapping("/user/info")
    public RespBean updateUser(@RequestBody User user, Authentication authentication){
        if(userService.updateUser(user)==1){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PutMapping("/user/pass")
    public RespBean updateUserPassword(@RequestBody Map<String,Object> info){
        //旧密码
        String oldpass = (String) info.get("oldpass");
        //新密码
        String pass = (String) info.get("pass");
        //用户id
        Integer id = (Integer) info.get("id");
        if(userService.updateUserPassword(oldpass,pass,id)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/user/userface")
    public RespBean updateUserface(MultipartFile file,Integer id,Authentication authentication){
        String fileId = FastDFSUtils.upload(file);
        String url=nginxHost+fileId;
        if(userService.updateUserface(url,id)==1){
            User user=(User)authentication.getPrincipal();
            user.setUserface(url);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！",url);
        }
        return RespBean.error("更新失败");
    }
}