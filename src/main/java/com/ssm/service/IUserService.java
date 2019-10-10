package com.ssm.service;

import com.ssm.common.ServerResponse;
import com.ssm.pojo.Health;
import com.ssm.pojo.Role;
import com.ssm.pojo.User;
import com.ssm.pojo.UserInfo;
import com.ssm.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    ServerResponse<User> login(@Param("username") String username, @Param("password") String password);

//    ServerResponse<String> register(User user);
//
//    ServerResponse<String> checkValid(String str,String type);
//
//    ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken);
//
//    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
//
////    更新User对象中的字段
//    ServerResponse<User> updateInformation(User user);
//
////    更新Role角色信息(管理员可以更新角色信息)
//    ServerResponse<Role> updateRole(Role role);
//
////    更新头像
//    ServerResponse<UserInfo> updateAvatar(UserInfo userInfo);
//
////    获得所有信息
//    ServerResponse<User> getInformation(Long userId);
//
////    检验admin
//    ServerResponse<String> checkAdminRole(Role role);


}
