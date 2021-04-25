package com.jc.bike.controller;

import com.jc.bike.config.VerificationCode;
import com.jc.bike.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 * @package: com.jc.bike.controller
 * @className: LoginController
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/5 13:03
 *
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/5 13:03     lijp6      v1.1.0              修改原因
 **/
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
         return  RespBean.error("尚未登录，请登录！");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}