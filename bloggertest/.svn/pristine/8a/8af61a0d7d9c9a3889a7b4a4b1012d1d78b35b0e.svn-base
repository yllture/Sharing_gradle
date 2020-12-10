package com.neuedu.dao;

import com.neuedu.entity.Paper_fillchoice;
import com.neuedu.entity.Paper_fillchoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Paper_fillchoiceMapper {
    int countByExample(Paper_fillchoiceExample example);

    int deleteByExample(Paper_fillchoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Paper_fillchoice record);

    int insertSelective(Paper_fillchoice record);

    List<Paper_fillchoice> selectByExample(Paper_fillchoiceExample example);

    Paper_fillchoice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Paper_fillchoice record, @Param("example") Paper_fillchoiceExample example);

    int updateByExample(@Param("record") Paper_fillchoice record, @Param("example") Paper_fillchoiceExample example);

    int updateByPrimaryKeySelective(Paper_fillchoice record);

    int updateByPrimaryKey(Paper_fillchoice record);
    
    List<Paper_fillchoice> selectByqid(Integer qid);
    
}