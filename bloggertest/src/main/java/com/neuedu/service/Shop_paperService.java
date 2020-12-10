package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.Shop_paperExample;
import com.neuedu.entity.User;

public interface Shop_paperService {

	List<Shop_paper> selectByType(Shop_paper paper);

	List<Shop_paper> selectByLabel(Shop_paper paper);

	List<Shop_paper> selectByTime();

	List<Shop_paper> selectByHeat();

	List<Shop_paper> selectFreepaper();

	List<Shop_paper> selectChargepaper();
	
	List<Shop_paper>  selectByCheckFlag(int i);
	
	int updateCheckFlag(Shop_paper bank);

	Shop_paper selectbypaperid(Shop_paper shoppaper);

	List<Shop_paper> papershopSearch(Shop_paper paper);

	List<Shop_paper> selectByUser(User user);

	int addShop_paper(Shop_paper shop_Paper);
    int deleteShop_paper(Shop_paper shop_paper);

	int countByExample(Shop_paperExample shop_paper);

	List<Shop_paper> selectByExample(Shop_paperExample shop_paper);
}
