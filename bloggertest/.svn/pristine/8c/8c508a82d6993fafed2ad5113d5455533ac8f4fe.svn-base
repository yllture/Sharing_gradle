package com.neuedu.dao;

import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.entity.Paper_multiplechoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_multiplechoiceMapper {
    int countByExample(Paper_multiplechoiceExample example);

    int deleteByExample(Paper_multiplechoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Paper_multiplechoice record);

    int insertSelective(Paper_multiplechoice record);

    List<Paper_multiplechoice> selectByExample(Paper_multiplechoiceExample example);

    Paper_multiplechoice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Paper_multiplechoice record, @Param("example") Paper_multiplechoiceExample example);

    int updateByExample(@Param("record") Paper_multiplechoice record, @Param("example") Paper_multiplechoiceExample example);

    int updateByPrimaryKeySelective(Paper_multiplechoice record);

    int updateByPrimaryKey(Paper_multiplechoice record);
    
    List<Paper_multiplechoice> selectByqid(Integer qid);
}