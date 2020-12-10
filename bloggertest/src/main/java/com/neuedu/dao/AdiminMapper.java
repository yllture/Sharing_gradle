package com.neuedu.dao;

import com.neuedu.entity.Adimin;
import com.neuedu.entity.AdiminExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdiminMapper {
    int countByExample(AdiminExample example);

    int deleteByExample(AdiminExample example);

    int deleteByPrimaryKey(Integer adminid);

    int insert(Adimin record);

    int insertSelective(Adimin record);

    List<Adimin> selectByExample(AdiminExample example);

    Adimin selectByPrimaryKey(Integer adminid);

    int updateByExampleSelective(@Param("record") Adimin record, @Param("example") AdiminExample example);

    int updateByExample(@Param("record") Adimin record, @Param("example") AdiminExample example);

    int updateByPrimaryKeySelective(Adimin record);

    int updateByPrimaryKey(Adimin record);
}