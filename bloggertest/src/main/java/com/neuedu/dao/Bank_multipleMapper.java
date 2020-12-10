package com.neuedu.dao;

import com.neuedu.entity.Bank_multiple;
import com.neuedu.entity.Bank_multipleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_multipleMapper {
    int countByExample(Bank_multipleExample example);

    int deleteByExample(Bank_multipleExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Bank_multiple record);

    int insertSelective(Bank_multiple record);

    List<Bank_multiple> selectByExample(Bank_multipleExample example);

    Bank_multiple selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Bank_multiple record, @Param("example") Bank_multipleExample example);

    int updateByExample(@Param("record") Bank_multiple record, @Param("example") Bank_multipleExample example);

    int updateByPrimaryKeySelective(Bank_multiple record);

    int updateByPrimaryKey(Bank_multiple record);
    
    List<Bank_multiple> getAllbyBankid(Integer bankid);
}