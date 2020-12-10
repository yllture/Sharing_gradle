package com.neuedu.dao;


import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.Shop_paperExample;
import com.neuedu.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Shop_paperMapper {
    int countByExample(Shop_paperExample example);

    int deleteByExample(Shop_paperExample example);

    int deleteByPrimaryKey(Integer paperid);

    int insert(Shop_paper record);

    int insertSelective(Shop_paper record);

    List<Shop_paper> selectByExample(Shop_paperExample example);

    Shop_paper selectByPrimaryKey(Integer paperid);

    int updateByExampleSelective(@Param("record") Shop_paper record, @Param("example") Shop_paperExample example);

    int updateByExample(@Param("record") Shop_paper record, @Param("example") Shop_paperExample example);

    int updateByPrimaryKeySelective(Shop_paper record);

    int updateByPrimaryKey(Shop_paper record);
    
    List<Shop_paper> selectByType(Shop_paper paepr);

	List<Shop_paper> selectByLabel(Shop_paper paper);

	List<Shop_paper> selectByTime();

	List<Shop_paper> selectByHeat();

	List<Shop_paper> selectFreepaper();

	List<Shop_paper> selectChargepaper();

	

	Shop_paper selectbyPaperId(Shop_paper shoppaper);

	List<Shop_paper> papershopSearch(Shop_paper paper);



	List<Shop_paper> selectByUser(User user);

}