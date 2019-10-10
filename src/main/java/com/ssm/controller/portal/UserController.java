package com.ssm.controller.portal;

import com.ssm.common.Const;
import com.ssm.common.ResponseCode;
import com.ssm.common.ServerResponse;
import com.ssm.pojo.User;
import com.ssm.pojo.UserInfo;
import com.ssm.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;


    /**
     * 用户登录
     * @param username      用户名
     * @param password      用户密码
     * @param session       会话
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        ServerResponse<User> response=iUserService.login(username, password);

        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        log.info("login-response",response);
        return response;
    }

    @GetMapping(value = "test.do")
    @ResponseBody
    public int getTest(){
        return 1;
    }
//
//    /**
//     * 未登录状态的重置密码
//     * @param username      用户名
//     * @param passwordNew   新密码
//     * @param forgetToken   重置token
//     * @return
//     */
//    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken){
//        return iUserService.forgetRestPassword(username, passwordNew, forgetToken);
//    }
//
//
//    /**
//     * 登录状态的重置密码
//     * @param session       会话
//     * @param passwordOld   旧密码
//     * @param passwordNew   新密码
//     * @return
//     */
//    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
////        判断登录状态
//        User user= (User) session.getAttribute(Const.CURRENT_USER);
//        if (user==null){
//            return ServerResponse.createByErrorMessage("用户未登录！");
//        }
//        return iUserService.resetPassword(passwordOld,passwordNew,user);
//    }
//
//    /**
//     * 更新更新用户个人信息
//     * @param session   会话
//     * @param user      更新对象
//     * @return
//     */
//    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<User> updateInformation(HttpSession session,User user){
////        判断登录状态
//        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentUser==null){
//            return ServerResponse.createByErrorMessage("用户未登录！");
//        }
//
//        user.setId(currentUser.getId());
//        user.setUserName(currentUser.getUserName());
//
//        ServerResponse<User> response=iUserService.updateInformation(user);
//        if (response.isSuccess()){
//            session.setAttribute(Const.CURRENT_USER,response.getData());
//        }
//        return response;
//    }
//
//    /**
//     * 更新头像
//     * @param session   会话
//     * @param userInfo  头像信息
//     * @return
//     */
//    @RequestMapping(value = "update_avatar.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<UserInfo> updateAvatar(HttpSession session,UserInfo userInfo){
//        //        判断登录状态
//        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentUser==null){
//            return ServerResponse.createByErrorMessage("用户未登录！");
//        }
//        userInfo.setUserId(currentUser.getId());
//        userInfo.setHeadImage(currentUser.getUserInfo().getHeadImage());
//
//        ServerResponse<UserInfo> response=iUserService.updateAvatar(userInfo);
//        if (response.isSuccess()){
//            return ServerResponse.createBySuccess(userInfo);
//        }
//        return response;
//    }
//
//    /**
//     * 获取用户详细信息
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<User> getInformation(HttpSession session){
//        //        判断登录状态
//        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentUser==null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录，需要强制登陆！");
//        }
//
//        return iUserService.getInformation(currentUser.getId());
//    }

}
