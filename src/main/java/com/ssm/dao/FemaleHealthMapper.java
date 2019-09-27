package com.ssm.dao;

import com.ssm.pojo.FemaleHealth;
import org.springframework.stereotype.Repository;

@Repository
public interface FemaleHealthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FemaleHealth record);

    int insertSelective(FemaleHealth record);

    FemaleHealth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FemaleHealth record);

    int updateByPrimaryKey(FemaleHealth record);
}