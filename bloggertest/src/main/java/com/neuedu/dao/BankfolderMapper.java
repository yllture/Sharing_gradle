package com.neuedu.dao;

import com.neuedu.entity.Bankfolder;
import com.neuedu.entity.BankfolderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BankfolderMapper {
    int countByExample(BankfolderExample example);

    int deleteByExample(BankfolderExample example);

    int deleteByPrimaryKey(Integer folderid);

    int insert(Bankfolder record);

    int insertSelective(Bankfolder record);

    List<Bankfolder> selectByExample(BankfolderExample example);

    Bankfolder selectByPrimaryKey(Integer folderid);

    int updateByExampleSelective(@Param("record") Bankfolder record, @Param("example") BankfolderExample example);

    int updateByExample(@Param("record") Bankfolder record, @Param("example") BankfolderExample example);

    int updateByPrimaryKeySelective(Bankfolder record);

    int updateByPrimaryKey(Bankfolder record);
    
    List<Bankfolder> getAllbyUserid(Integer userid);
    
    List<Bankfolder> getAllbyFolderid(Integer folderid);
    
}