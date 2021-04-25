package com.jc.bike.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jc.bike.model.RespBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright: Copyright (c) 2020 jc
 *
 * @package: com.jc.bike.config
 * @className: VerificationCodeFilter
 * @description TODO
 * @version: 1.0
 * @author: lijp6
 * @date: 2021/2/26 15:35
 * <p>
 * Modification History:
 * Date                Author        Version           Description
 * ---------------------------------------------------------------
 * 2021/2/26 15:35     lijp6      v1.1.0              修改原因
 **/
@Component
public class VerificationCodeFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        if("POST".equals(req.getMethod()) && "/doLogin".equals(req.getServletPath())){
            //登录请求
            String code= req.getParameter("code");
            String verify_code= (String) req.getSession().getAttribute("verify_code");
            if (code == null  || "".equals(code) || !verify_code.toLowerCase().equals(code.toLowerCase())) {
                //验证码不正确
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out=resp.getWriter();
                out.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码填写错误")));
                out.flush();
                out.close();
                return;
            }else {
                filterChain.doFilter(req,resp);
            }
        }else {
            filterChain.doFilter(req,resp);
        }
    }
}