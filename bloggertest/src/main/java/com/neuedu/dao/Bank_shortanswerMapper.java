package com.neuedu.dao;

import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_shortanswerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_shortanswerMapper {
    int countByExample(Bank_shortanswerExample example);

    int deleteByExample(Bank_shortanswerExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Bank_shortanswer record);

    int insertSelective(Bank_shortanswer record);

    List<Bank_shortanswer> selectByExample(Bank_shortanswerExample example);

    Bank_shortanswer selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Bank_shortanswer record, @Param("example") Bank_shortanswerExample example);

    int updateByExample(@Param("record") Bank_shortanswer record, @Param("example") Bank_shortanswerExample example);

    int updateByPrimaryKeySelective(Bank_shortanswer record);

    int updateByPrimaryKey(Bank_shortanswer record);
    
    List<Bank_shortanswer> getAllbyBankid(Integer bankid);
}