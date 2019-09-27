package com.ssm.dao;

import com.ssm.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

//    更新角色信息
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


}