package com.neuedu.dao;

import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Bank_judgeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_judgeMapper {
    int countByExample(Bank_judgeExample example);

    int deleteByExample(Bank_judgeExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Bank_judge record);

    int insertSelective(Bank_judge record);

    List<Bank_judge> selectByExample(Bank_judgeExample example);

    Bank_judge selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Bank_judge record, @Param("example") Bank_judgeExample example);

    int updateByExample(@Param("record") Bank_judge record, @Param("example") Bank_judgeExample example);

    int updateByPrimaryKeySelective(Bank_judge record);

    int updateByPrimaryKey(Bank_judge record);
    
    List<Bank_judge> getAllbyBankid(int bankid);
}