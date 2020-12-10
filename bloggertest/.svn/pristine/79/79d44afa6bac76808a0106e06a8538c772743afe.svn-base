package com.neuedu.dao;

import com.neuedu.entity.Payrecord;
import com.neuedu.entity.PayrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayrecordMapper {
    int countByExample(PayrecordExample example);

    int deleteByExample(PayrecordExample example);

    int deleteByPrimaryKey(Integer recordid);

    int insert(Payrecord record);

    int insertSelective(Payrecord record);

    List<Payrecord> selectByExample(PayrecordExample example);

    Payrecord selectByPrimaryKey(Integer recordid);

    int updateByExampleSelective(@Param("record") Payrecord record, @Param("example") PayrecordExample example);

    int updateByExample(@Param("record") Payrecord record, @Param("example") PayrecordExample example);

    int updateByPrimaryKeySelective(Payrecord record);

    int updateByPrimaryKey(Payrecord record);
}