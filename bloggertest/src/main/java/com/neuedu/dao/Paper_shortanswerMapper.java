package com.neuedu.dao;

import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_shortanswerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_shortanswerMapper {
    int countByExample(Paper_shortanswerExample example);

    int deleteByExample(Paper_shortanswerExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Paper_shortanswer record);

    int insertSelective(Paper_shortanswer record);

    List<Paper_shortanswer> selectByExample(Paper_shortanswerExample example);

    Paper_shortanswer selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Paper_shortanswer record, @Param("example") Paper_shortanswerExample example);

    int updateByExample(@Param("record") Paper_shortanswer record, @Param("example") Paper_shortanswerExample example);

    int updateByPrimaryKeySelective(Paper_shortanswer record);

    int updateByPrimaryKey(Paper_shortanswer record);
    
    List<Paper_shortanswer> getAllbyid(Integer paperid);
}