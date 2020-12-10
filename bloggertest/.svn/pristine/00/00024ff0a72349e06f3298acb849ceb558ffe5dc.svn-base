package com.neuedu.dao;

import com.neuedu.entity.Bank_multiplechoice;
import com.neuedu.entity.Bank_multiplechoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_multiplechoiceMapper {
    int countByExample(Bank_multiplechoiceExample example);

    int deleteByExample(Bank_multiplechoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Bank_multiplechoice record);

    int insertSelective(Bank_multiplechoice record);

    List<Bank_multiplechoice> selectByExample(Bank_multiplechoiceExample example);

    Bank_multiplechoice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Bank_multiplechoice record, @Param("example") Bank_multiplechoiceExample example);

    int updateByExample(@Param("record") Bank_multiplechoice record, @Param("example") Bank_multiplechoiceExample example);

    int updateByPrimaryKeySelective(Bank_multiplechoice record);

    int updateByPrimaryKey(Bank_multiplechoice record);
    
    List<Bank_multiplechoice> selectByqid(Integer qid);
}