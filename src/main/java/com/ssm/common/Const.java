package com.ssm.common;

/**
 * 常量
 */
public class Const {

//    登陆用户存入session的键值
    public static final String CURRENT_USER="currentUser";
    public static final String EMAIL="email";
    public static final String USERNAME="username";

//    角色
    public interface Role{
        String  ROLE_NORMAL="normal";  //普通用户
       String ROLE_ADMIN="admin";   //管理员
}
}
