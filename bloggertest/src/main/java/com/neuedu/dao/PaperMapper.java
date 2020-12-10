package com.neuedu.dao;

import com.neuedu.entity.Paper;
import com.neuedu.entity.PaperExample;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaperMapper {
    int countByExample(PaperExample example);

    int deleteByExample(PaperExample example);

    int deleteByPrimaryKey(Integer paperid);

    int insert(Paper record);

    int insertSelective(Paper record);

    List<Paper> selectByExample(PaperExample example);

    Paper selectByPrimaryKey(Integer paperid);

    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
    
    List<Paper> selectAllPaper(Integer userid);
    
    List<Paper> selectAllPaperByTeacher(Integer userid);
    
    int deleteFillByknowledge(Paper_fill pf);
	int deleteSingleByknowledge(Paper_single ps);
	int deleteMultipleByknowledge(Paper_multiple pm);
	int deleteJudgeByknowledge(Paper_judge pj);
	int deleteShortanswerByknowledge(Paper_shortanswer ps);
}