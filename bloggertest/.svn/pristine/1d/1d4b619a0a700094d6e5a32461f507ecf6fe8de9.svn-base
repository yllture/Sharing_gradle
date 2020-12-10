package com.neuedu.dao;

import com.neuedu.entity.Usersign;
import com.neuedu.entity.UsersignExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersignMapper {
    int countByExample(UsersignExample example);

    int deleteByExample(UsersignExample example);

    int deleteByPrimaryKey(Integer signinid);

    int insert(Usersign record);

    int insertSelective(Usersign record);

    List<Usersign> selectByExample(UsersignExample example);

    Usersign selectByPrimaryKey(Integer signinid);

    int updateByExampleSelective(@Param("record") Usersign record, @Param("example") UsersignExample example);

    int updateByExample(@Param("record") Usersign record, @Param("example") UsersignExample example);

    int updateByPrimaryKeySelective(Usersign record);

    int updateByPrimaryKey(Usersign record);
}