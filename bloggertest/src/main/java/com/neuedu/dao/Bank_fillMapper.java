package com.neuedu.dao;

import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_fillExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_fillMapper {
    int countByExample(Bank_fillExample example);

    int deleteByExample(Bank_fillExample example);

    int deleteByPrimaryKey(Integer qId);

    int insert(Bank_fill record);

    int insertSelective(Bank_fill record);

    List<Bank_fill> selectByExample(Bank_fillExample example);

    Bank_fill selectByPrimaryKey(Integer qId);

    int updateByExampleSelective(@Param("record") Bank_fill record, @Param("example") Bank_fillExample example);

    int updateByExample(@Param("record") Bank_fill record, @Param("example") Bank_fillExample example);

    int updateByPrimaryKeySelective(Bank_fill record);

    int updateByPrimaryKey(Bank_fill record);
    
    List<Bank_fill> getAllbyBankid(Integer bankid);
    
}