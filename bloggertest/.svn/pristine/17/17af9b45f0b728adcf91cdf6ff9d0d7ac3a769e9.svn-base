package com.neuedu.dao;

import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.entity.Bank_fillchoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_fillchoiceMapper {
    int countByExample(Bank_fillchoiceExample example);

    int deleteByExample(Bank_fillchoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Bank_fillchoice record);

    int insertSelective(Bank_fillchoice record);

    List<Bank_fillchoice> selectByExample(Bank_fillchoiceExample example);

    Bank_fillchoice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Bank_fillchoice record, @Param("example") Bank_fillchoiceExample example);

    int updateByExample(@Param("record") Bank_fillchoice record, @Param("example") Bank_fillchoiceExample example);

    int updateByPrimaryKeySelective(Bank_fillchoice record);

    int updateByPrimaryKey(Bank_fillchoice record);
    
    List<Bank_fillchoice> selectByqid(Integer qid);
    
}