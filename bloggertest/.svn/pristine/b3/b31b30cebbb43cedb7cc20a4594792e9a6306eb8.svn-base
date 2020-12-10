package com.neuedu.dao;

import com.neuedu.entity.Paper_singlechoice;
import com.neuedu.entity.Paper_singlechoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_singlechoiceMapper {
    int countByExample(Paper_singlechoiceExample example);

    int deleteByExample(Paper_singlechoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Paper_singlechoice record);

    int insertSelective(Paper_singlechoice record);

    List<Paper_singlechoice> selectByExample(Paper_singlechoiceExample example);

    Paper_singlechoice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Paper_singlechoice record, @Param("example") Paper_singlechoiceExample example);

    int updateByExample(@Param("record") Paper_singlechoice record, @Param("example") Paper_singlechoiceExample example);

    int updateByPrimaryKeySelective(Paper_singlechoice record);

    int updateByPrimaryKey(Paper_singlechoice record);
    
    List<Paper_singlechoice> selectByqid(Integer qid);
}