package com.neuedu.dao;

import com.neuedu.entity.Garbage_bank;
import com.neuedu.entity.Garbage_bankExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Garbage_bankMapper {
    int countByExample(Garbage_bankExample example);

    int deleteByExample(Garbage_bankExample example);

    int deleteByPrimaryKey(Integer bankid);

    int insert(Garbage_bank record);

    int insertSelective(Garbage_bank record);

    List<Garbage_bank> selectByExample(Garbage_bankExample example);

    Garbage_bank selectByPrimaryKey(Integer bankid);

    int updateByExampleSelective(@Param("record") Garbage_bank record, @Param("example") Garbage_bankExample example);

    int updateByExample(@Param("record") Garbage_bank record, @Param("example") Garbage_bankExample example);

    int updateByPrimaryKeySelective(Garbage_bank record);

    int updateByPrimaryKey(Garbage_bank record);
    
    List<Garbage_bank> getAllByUserid(Integer userid);
    List<Garbage_bank> getAllByFolderid(Integer folderid);
}