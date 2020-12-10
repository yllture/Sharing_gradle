package com.neuedu.dao;

import com.neuedu.entity.Examrecord;
import com.neuedu.entity.ExamrecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ExamrecordMapper {
    int countByExample(ExamrecordExample example);

    int deleteByExample(ExamrecordExample example);

    int deleteByPrimaryKey(Integer recordid);

    int insert(Examrecord record);

    int insertSelective(Examrecord record);

    List<Examrecord> selectByExample(ExamrecordExample example);

    Examrecord selectByPrimaryKey(Integer recordid);

    int updateByExampleSelective(@Param("record") Examrecord record, @Param("example") ExamrecordExample example);

    int updateByExample(@Param("record") Examrecord record, @Param("example") ExamrecordExample example);

    int updateByPrimaryKeySelective(Examrecord record);

    int updateByPrimaryKey(Examrecord record);
}