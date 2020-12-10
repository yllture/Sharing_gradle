package com.neuedu.dao;

import com.neuedu.entity.Papermapping;
import com.neuedu.entity.PapermappingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PapermappingMapper {
    int countByExample(PapermappingExample example);

    int deleteByExample(PapermappingExample example);

    int deleteByPrimaryKey(Integer userpaperid);

    int insert(Papermapping record);

    int insertSelective(Papermapping record);

    List<Papermapping> selectByExample(PapermappingExample example);

    Papermapping selectByPrimaryKey(Integer userpaperid);

    int updateByExampleSelective(@Param("record") Papermapping record, @Param("example") PapermappingExample example);

    int updateByExample(@Param("record") Papermapping record, @Param("example") PapermappingExample example);

    int updateByPrimaryKeySelective(Papermapping record);

    int updateByPrimaryKey(Papermapping record);
    
    Papermapping getMappingexcit(Papermapping pm);
}