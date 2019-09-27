package com.ssm.service.impl;

import com.ssm.common.Const;
import com.ssm.common.ServerResponse;
import com.ssm.common.TokenCache;
import com.ssm.dao.RoleMapper;
import com.ssm.dao.UserInfoMapper;
import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;
import com.ssm.util.MD5Util;
import com.ssm.vo.UserLoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper=null;

    @Autowired
    private UserInfoMapper userInfoMapper=null;

    @Autowired
    private RoleMapper roleMapper=null;

    /**
     * 登录校验
     * @param username      输入的username
     * @param password      输入的password
     * @return              返回登陆信息
     */
    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount=userMapper.checkUserName(username);

        if (resultCount==0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        String md5Password= MD5Util.MD5EncodeUtf8(password);
        User user= userMapper.selectLogin(username,md5Password);
        if (user==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);//密码置空

        return  ServerResponse.createBySuccess("登陆成功");
    }

    /**
     * 用户注册
     * @param user    用户输入的信息
     * @return          注册信息
     */
    @Override
    public ServerResponse<String> register(User user) {
        /**
         * 1、需要判断输入的必填字段是否已经填写
         *      必填字段：username,email,password
         * 2、需要判断用户是否已经注册
         *      已经注册就返回“该用户已注册”
         *      未注册就返回“注册信息”
         *          注册信息包括：注册成功，注册失败
         */

//        调用验证方法,判断username是否存在
        ServerResponse validResponse=this.checkValid(user.getUserName(), Const.USERNAME);
        if (!validResponse.isSuccess()){
            return validResponse;
        }

//        判断email是否已经存在
        validResponse=this.checkValid(user.getEmail(),Const.EMAIL);
        if (!validResponse.isSuccess()){
            return validResponse;
        }

//        MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCount=userMapper.insert(user);

        if (resultCount==0){
            return ServerResponse.createByErrorMessage("注册失败！");
        }

        return ServerResponse.createBySuccess("注册成功");
    }

    /**
     * 具体校验方法
     * @param str   需要校验的字符串
     * @param type  需要校验的类型
     * @return      返回校验信息
     */
    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)){
//            开始校验
            if (Const.USERNAME.equals(type)){
//                判断name是否存在
                int resultCount=userMapper.checkUserName(str);
                if (resultCount>0){
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }

            if (Const.EMAIL.equals(type)){
//                判断email是否存在
                int resultCount=userMapper.checkEmail(str);
                if (resultCount>0){
                    return ServerResponse.createByErrorMessage("email已经存在");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccess("校验成功");
    }

    /**
     * 忘记密码
     * @param username      用户名
     * @param passwordNew   新的密码
     * @param forgetToken   通关密码
     * @return
     */
    @Override
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken) {
        if (StringUtils.isBlank(forgetToken)){
            return ServerResponse.createByErrorMessage("参数错误，token需要传递");
        }

        ServerResponse validResponse=this.checkValid(username,Const.USERNAME);
            if (validResponse.isSuccess()){
                return ServerResponse.createByErrorMessage("用户不存在!");
            }

            String token= TokenCache.getKey(TokenCache.TOKEN_PREFIX+username);

//            判断token是否存在或过期
            if (StringUtils.isBlank(token)){
                return ServerResponse.createByErrorMessage("token 无效或者过期");
            }

            if (StringUtils.equals(forgetToken,token)){
                String md5Password=MD5Util.MD5EncodeUtf8(passwordNew);

                int rowCount=userMapper.updatePasswordByUserName(username,md5Password);

                if (rowCount>0){
                    return ServerResponse.createBySuccess("修改密码成功！");
                }
            }else {
                return ServerResponse.createByErrorMessage("token错误，请重新获取重置密码的token");
            }

        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    /**
     * 重置密码
     * @param passwordOld      用户名
     * @param passwordNew   新密码
     * @param user          user对象
     * @return              重置信息
     */
    @Override
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
//        防止横向越权，校验用户的旧密码，一定是指向这个用户
        int resultCount=userMapper.checkPasswordByUserId(user.getId(),MD5Util.MD5EncodeUtf8(passwordOld));
        if (resultCount==0){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }

        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));

        int updateCount=userMapper.updateByPrimaryKeySelective(user);
        if (updateCount>0){
            return ServerResponse.createBySuccess("密码更新成功");
        }

        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    /**
     * 更新用户个人信息
     * @param user    新的用户对象
     * @return        更新信息
     */
    @Override
    public ServerResponse<User> updateInformation(User user) {
//        判断email是否重复
        int resultCount=userMapper.checkEmailByUserId(user.getId(),user.getEmail());
        if (resultCount>0){
            return ServerResponse.createByErrorMessage("email已存在，请更换email再尝试更新");
        }


        return null;
    }

    @Override
    public ServerResponse<User> getInformation(Integer userId) {
        return null;
    }

    @Override
    public ServerResponse<String> checkAdminRole(User user) {
        return null;
    }



//    User->UserLoginVo
    private UserLoginVo assembleUserVo(User user){
       UserLoginVo userLoginVo=new UserLoginVo();

       userLoginVo.setUserName(user.getUserName());
       userLoginVo.setEmail(user.getEmail());

        return userLoginVo;
    }

}
