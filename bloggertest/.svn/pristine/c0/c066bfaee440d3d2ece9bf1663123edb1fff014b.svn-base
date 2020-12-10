package com.neuedu.dao;

import com.neuedu.entity.Bank_singlechoice;
import com.neuedu.entity.Bank_singlechoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Bank_singlechoiceMapper {
    int countByExample(Bank_singlechoiceExample example);

    int deleteByExample(Bank_singlechoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Bank_singlechoice record);

    int insertSelective(Bank_singlechoice record);

    List<Bank_singlechoice> selectByExample(Bank_singlechoiceExample example);

    Bank_singlechoice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Bank_singlechoice record, @Param("example") Bank_singlechoiceExample example);

    int updateByExample(@Param("record") Bank_singlechoice record, @Param("example") Bank_singlechoiceExample example);

    int updateByPrimaryKeySelective(Bank_singlechoice record);

    int updateByPrimaryKey(Bank_singlechoice record);
    
    List<Bank_singlechoice> selectByqid(Integer qid);
}