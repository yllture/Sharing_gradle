package com.neuedu.dao;

import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_bankExample;
import com.neuedu.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Shop_bankMapper {
    int countByExample(Shop_bankExample example);

    int deleteByExample(Shop_bankExample example);

    int deleteByPrimaryKey(Integer bankid);

    int insert(Shop_bank record);

    int insertSelective(Shop_bank record);

    List<Shop_bank> selectByExample(Shop_bankExample example);

    Shop_bank selectByPrimaryKey(Integer bankid);

    int updateByExampleSelective(@Param("record") Shop_bank record, @Param("example") Shop_bankExample example);

    int updateByExample(@Param("record") Shop_bank record, @Param("example") Shop_bankExample example);

    int updateByPrimaryKeySelective(Shop_bank record);

    int updateByPrimaryKey(Shop_bank record);
    
    List<Shop_bank> selectByType(Shop_bank bank);

	List<Shop_bank> selectByLabel(Shop_bank bank);

	List<Shop_bank> selectByTime();

	List<Shop_bank> selectByHeat();

	List<Shop_bank> selectFreeBank();

	List<Shop_bank> selectChargeBank();

	Shop_bank selectByBankid(Shop_bank shopbank);

	List<Shop_bank> bankshopSearch(Shop_bank bank);

	List<Shop_bank> selectByUser(User user);
}