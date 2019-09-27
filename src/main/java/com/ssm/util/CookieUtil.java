package com.ssm.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Slf4j
public class CookieUtil {

    private final static String COOKIE_DOMAIN="happyssm.text";
    private final static String COOKIE_NAME="ssm_login_token";

    /**
     * 写入cookie
     * @param response  HttpServletResponse
     * @param token     cookie的值
     */
    public static void writeLoginToken(HttpServletResponse response,String token){
        Cookie ck=new Cookie(COOKIE_NAME,token);
        ck.setDomain(COOKIE_DOMAIN);
        ck.setPath("/");            //代表设置在根目录
        ck.setHttpOnly(true);       //不允许通过脚本读取
        ck.setMaxAge(60*60*24*365); //单位：s  -1永久有效 0删除cookie,如果不赋值，则不会写入硬盘，只在当前页面有效
//        log.info
        response.addCookie(ck);
    }


    /**
     * 读取Cookie
     * @param request   HttpServletRequest
     */
    public static String readLoginToken(HttpServletRequest request){
        Cookie[] cks=request.getCookies();
        if (cks!=null){
            for (Cookie ck : cks) {
                if (StringUtils.equals(ck.getName(),COOKIE_NAME)){
                    return ck.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 删除cookie
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     */
    public static void delLoginToken(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cks=request.getCookies();

        if (cks!=null){
            for (Cookie ck:cks){
                if (StringUtils.equals(ck.getName(),COOKIE_NAME)){
                    ck.setDomain(COOKIE_DOMAIN);
                    ck.setPath("/");
                    ck.setMaxAge(0);    //设置为0，删除cookie

                    response.addCookie(ck);
                    return;
                }
            }
        }
    }
}
