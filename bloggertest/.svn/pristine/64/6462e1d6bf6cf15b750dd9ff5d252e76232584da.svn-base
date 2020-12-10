package com.neuedu.dao;

import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_fillExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_fillMapper {
    int countByExample(Paper_fillExample example);

    int deleteByExample(Paper_fillExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Paper_fill record);

    int insertSelective(Paper_fill record);

    List<Paper_fill> selectByExample(Paper_fillExample example);

    Paper_fill selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Paper_fill record, @Param("example") Paper_fillExample example);

    int updateByExample(@Param("record") Paper_fill record, @Param("example") Paper_fillExample example);

    int updateByPrimaryKeySelective(Paper_fill record);

    int updateByPrimaryKey(Paper_fill record);
    
    List<Paper_fill> getAllbyPaperid(Integer paperid);
}