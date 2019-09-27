package com.ssm.service;

import com.ssm.common.ServerResponse;
import com.ssm.pojo.User;
import com.ssm.vo.UserInfoVo;

public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

//    更新UserInfoVo对象中的字段
    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

//    admin
    ServerResponse<String> checkAdminRole(User user);


}
