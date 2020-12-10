package com.neuedu.service;
import java.util.List;

import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_bankExample;
import com.neuedu.entity.User;

public interface Shop_bankService {

	List<Shop_bank> selectByType(Shop_bank bank);

	List<Shop_bank> selectByLabel(Shop_bank bank);

	List<Shop_bank> selectByTime();

	List<Shop_bank> selectByHeat();

	List<Shop_bank> selectFreeBank();

	List<Shop_bank> selectChargeBank();   
	List<Shop_bank>  selectByCheckFlag(int i);

	Shop_bank selectbyBankid(Shop_bank shopbank);
	
    int updateCheckFlag(Shop_bank bank);

	List<Shop_bank> bankshopSearch(Shop_bank bank);

	List<Shop_bank> selectByUser(User user);
	
	int addShop_bank(Shop_bank shop_bank);
	int deleteShop_bank(Shop_bank shop_bank);

	List<Shop_bank> selectByExample(Shop_bankExample shop_bank);

	int countByExample(Shop_bankExample shop_bank);
	int updateShop_bank(Shop_bank shop_bank);
}
