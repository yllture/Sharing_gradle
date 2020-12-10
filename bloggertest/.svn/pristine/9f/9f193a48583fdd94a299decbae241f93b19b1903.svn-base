package com.neuedu.dao;

import com.neuedu.entity.Bank_knowledge;
import com.neuedu.entity.Bank_knowledgeExample;
import com.neuedu.entity.Bank_knowledgeKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_knowledgeMapper {
    int countByExample(Bank_knowledgeExample example);

    int deleteByExample(Bank_knowledgeExample example);

    int deleteByPrimaryKey(Bank_knowledgeKey key);

    int insert(Bank_knowledge record);

    int insertSelective(Bank_knowledge record);

    List<Bank_knowledge> selectByExample(Bank_knowledgeExample example);

    Bank_knowledge selectByPrimaryKey(Bank_knowledgeKey key);

    int updateByExampleSelective(@Param("record") Bank_knowledge record, @Param("example") Bank_knowledgeExample example);

    int updateByExample(@Param("record") Bank_knowledge record, @Param("example") Bank_knowledgeExample example);

    int updateByPrimaryKeySelective(Bank_knowledge record);

    int updateByPrimaryKey(Bank_knowledge record);
    
    List<Bank_knowledge> getAllbyBankid(Integer bankid);
}