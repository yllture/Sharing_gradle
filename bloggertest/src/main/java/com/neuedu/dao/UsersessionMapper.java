package com.neuedu.dao;

import com.neuedu.entity.Usersession;
import com.neuedu.entity.UsersessionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersessionMapper {
    int countByExample(UsersessionExample example);

    int deleteByExample(UsersessionExample example);

    int deleteByPrimaryKey(Integer usersessionid);

    int insert(Usersession record);

    int insertSelective(Usersession record);

    List<Usersession> selectByExample(UsersessionExample example);

    Usersession selectByPrimaryKey(Integer usersessionid);

    int updateByExampleSelective(@Param("record") Usersession record, @Param("example") UsersessionExample example);

    int updateByExample(@Param("record") Usersession record, @Param("example") UsersessionExample example);

    int updateByPrimaryKeySelective(Usersession record);

    int updateByPrimaryKey(Usersession record);
    
    Usersession selectbyUserid(Integer userid);
}