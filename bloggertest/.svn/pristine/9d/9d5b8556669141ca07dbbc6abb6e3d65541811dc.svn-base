package com.neuedu.dao;

import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Paper_singleExample;
import com.neuedu.entity.Paper_singlechoice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_singleMapper {
    int countByExample(Paper_singleExample example);

    int deleteByExample(Paper_singleExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Paper_single record);

    int insertSelective(Paper_single record);

    List<Paper_single> selectByExample(Paper_singleExample example);

    Paper_single selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Paper_single record, @Param("example") Paper_singleExample example);

    int updateByExample(@Param("record") Paper_single record, @Param("example") Paper_singleExample example);

    int updateByPrimaryKeySelective(Paper_single record);

    int updateByPrimaryKey(Paper_single record);
    
    List<Paper_single> getAllbyPaperid(Integer paperid);
}