package com.neuedu.dao;

import com.neuedu.entity.Groupapply;
import com.neuedu.entity.GroupapplyExample;
import com.neuedu.entity.GroupapplyKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GroupapplyMapper {
    int countByExample(GroupapplyExample example);

    int deleteByExample(GroupapplyExample example);

    int deleteByPrimaryKey(GroupapplyKey key);

    int insert(Groupapply record);

    int insertSelective(Groupapply record);

    List<Groupapply> selectByExample(GroupapplyExample example);

    Groupapply selectByPrimaryKey(GroupapplyKey key);

    int updateByExampleSelective(@Param("record") Groupapply record, @Param("example") GroupapplyExample example);

    int updateByExample(@Param("record") Groupapply record, @Param("example") GroupapplyExample example);

    int updateByPrimaryKeySelective(Groupapply record);

    int updateByPrimaryKey(Groupapply record);
}