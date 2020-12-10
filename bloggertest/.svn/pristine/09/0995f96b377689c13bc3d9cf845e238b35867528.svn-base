package com.neuedu.dao;

import com.neuedu.entity.Bank;
import com.neuedu.entity.BankExample;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Bank_multiple;
import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_single;
import com.neuedu.entity.Bankfolder;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BankMapper {
    int countByExample(BankExample example);

    int deleteByExample(BankExample example);

    int deleteByPrimaryKey(Integer bankid);

    int insert(Bank record);

    int insertSelective(Bank record);

    List<Bank> selectByExample(BankExample example);

    Bank selectByPrimaryKey(Integer bankid);

    int updateByExampleSelective(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByExample(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
    
    List<Bank> selectAllBank(Integer userid);
    
    List<Bank> getAllByFolderid(Integer folderid);
    
    int deleteFillByknowledge(Bank_fill bf);
	int deleteSingleByknowledge(Bank_single bs);
	int deleteMultipleByknowledge(Bank_multiple bm);
	int deleteJudgeByknowledge(Bank_judge bj);
	int deleteShortanswerByknowledge(Bank_shortanswer bs);
}