package com.ssm.dao;

import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

//    只包含User对象里面的字段
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    检查用户姓名，邮箱是否已经存在
    int checkUserName(String userName);

    int checkEmail(String email);

//    用户登录
    User selectLogin(@Param("username")String userName,@Param("password")String password);

//    修改密码(通过userName)
    int updatePasswordByUserName(@Param("username")String userName,@Param("password")String password);

//    检查密码（userId）
    int checkPasswordByUserId(@Param("userId")Long userId,@Param("password")String password);

//    检查邮箱（userId）
    int checkEmailByUserId(@Param("userId")Long id,@Param("email")String email);


}