package com.neuedu.dao;

import com.neuedu.entity.Groupmember;
import com.neuedu.entity.GroupmemberExample;
import com.neuedu.entity.GroupmemberKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GroupmemberMapper {
    int countByExample(GroupmemberExample example);

    int deleteByExample(GroupmemberExample example);

    int deleteByPrimaryKey(GroupmemberKey key);

    int insert(Groupmember record);

    int insertSelective(Groupmember record);

    List<Groupmember> selectByExample(GroupmemberExample example);

    Groupmember selectByPrimaryKey(GroupmemberKey key);

    int updateByExampleSelective(@Param("record") Groupmember record, @Param("example") GroupmemberExample example);

    int updateByExample(@Param("record") Groupmember record, @Param("example") GroupmemberExample example);

    int updateByPrimaryKeySelective(Groupmember record);

    int updateByPrimaryKey(Groupmember record);
}