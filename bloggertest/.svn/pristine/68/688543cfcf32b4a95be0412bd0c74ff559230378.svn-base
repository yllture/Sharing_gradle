package com.neuedu.dao;

import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_judgeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_judgeMapper {
    int countByExample(Paper_judgeExample example);

    int deleteByExample(Paper_judgeExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Paper_judge record);

    int insertSelective(Paper_judge record);

    List<Paper_judge> selectByExample(Paper_judgeExample example);

    Paper_judge selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Paper_judge record, @Param("example") Paper_judgeExample example);

    int updateByExample(@Param("record") Paper_judge record, @Param("example") Paper_judgeExample example);

    int updateByPrimaryKeySelective(Paper_judge record);

    int updateByPrimaryKey(Paper_judge record);
    
    List<Paper_judge> getAllbyPaperid(Integer paperid);
}