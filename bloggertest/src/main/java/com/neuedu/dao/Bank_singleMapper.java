package com.neuedu.dao;

import com.neuedu.entity.Bank_single;
import com.neuedu.entity.Bank_singleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_singleMapper {
    int countByExample(Bank_singleExample example);

    int deleteByExample(Bank_singleExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Bank_single record);

    int insertSelective(Bank_single record);

    List<Bank_single> selectByExample(Bank_singleExample example);

    Bank_single selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Bank_single record, @Param("example") Bank_singleExample example);

    int updateByExample(@Param("record") Bank_single record, @Param("example") Bank_singleExample example);

    int updateByPrimaryKeySelective(Bank_single record);

    int updateByPrimaryKey(Bank_single record);
    
    List<Bank_single> getAllbyBankid(Integer bankid);
}