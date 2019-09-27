package com.ssm.dao;

import com.ssm.pojo.MaleHealth;
import org.springframework.stereotype.Repository;

@Repository
public interface MaleHealthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MaleHealth record);

    int insertSelective(MaleHealth record);

    MaleHealth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaleHealth record);

    int updateByPrimaryKey(MaleHealth record);
}