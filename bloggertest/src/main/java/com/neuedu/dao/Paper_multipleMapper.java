package com.neuedu.dao;

import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_multipleExample;
import com.neuedu.entity.Paper_multiplechoice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_multipleMapper {
    int countByExample(Paper_multipleExample example);

    int deleteByExample(Paper_multipleExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Paper_multiple record);

    int insertSelective(Paper_multiple record);

    List<Paper_multiple> selectByExample(Paper_multipleExample example);

    Paper_multiple selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Paper_multiple record, @Param("example") Paper_multipleExample example);

    int updateByExample(@Param("record") Paper_multiple record, @Param("example") Paper_multipleExample example);

    int updateByPrimaryKeySelective(Paper_multiple record);

    int updateByPrimaryKey(Paper_multiple record);
    
    List<Paper_multiple> getAllbyPaperid(Integer paperid);
}