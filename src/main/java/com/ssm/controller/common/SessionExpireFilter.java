package com.ssm.controller.common;

import com.ssm.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//重置 登录token 的时间
public class SessionExpireFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;

//        取得token
        String loginToken= CookieUtil.readLoginToken(httpServletRequest);
//
//        if (StringUtils.isNotEmpty(loginToken)){
//
//        }
    }

    @Override
    public void destroy() {

    }
}
