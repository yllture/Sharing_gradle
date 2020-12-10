package com.neuedu.dao;

import com.neuedu.entity.Garbage_bankfolder;
import com.neuedu.entity.Garbage_bankfolderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Garbage_bankfolderMapper {
    int countByExample(Garbage_bankfolderExample example);

    int deleteByExample(Garbage_bankfolderExample example);

    int deleteByPrimaryKey(Integer folderid);

    int insert(Garbage_bankfolder record);

    int insertSelective(Garbage_bankfolder record);

    List<Garbage_bankfolder> selectByExample(Garbage_bankfolderExample example);

    Garbage_bankfolder selectByPrimaryKey(Integer folderid);

    int updateByExampleSelective(@Param("record") Garbage_bankfolder record, @Param("example") Garbage_bankfolderExample example);

    int updateByExample(@Param("record") Garbage_bankfolder record, @Param("example") Garbage_bankfolderExample example);

    int updateByPrimaryKeySelective(Garbage_bankfolder record);

    int updateByPrimaryKey(Garbage_bankfolder record);
    
    List<Garbage_bankfolder> getAllByuserid(Integer userid);
    
    List<Garbage_bankfolder> getAllByfoldermapping(Integer foldermapping);
}