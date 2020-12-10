package com.neuedu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Shop_bankMapper;
import com.neuedu.dao.UserMapper;
import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_bankExample;
import com.neuedu.entity.User;
import com.neuedu.entity.AdiminExample.Criteria;
import com.neuedu.service.Shop_bankService;
@Service
public class Shop_bankServiceImpl implements Shop_bankService {

	@Autowired
	Shop_bankMapper shop_bankmapper;
	@Autowired
	UserMapper usermapper;
	@Autowired
	Shop_bankExample  shop_bankExample;
	
	
	@Override
	public List<Shop_bank> selectByType(Shop_bank bank) {
		// TODO Auto-generated method stub
		 List<Shop_bank> banks=shop_bankmapper.selectByType(bank);
		return banks;
	}



	@Override
	public List<Shop_bank> selectByLabel(Shop_bank bank) {
		List<Shop_bank> banks=shop_bankmapper.selectByLabel(bank);  
		return banks;
	}



	

	

	@Override
	public List<Shop_bank> selectByCheckFlag(int i) {
		shop_bankExample=new Shop_bankExample();
		com.neuedu.entity.Shop_bankExample.Criteria c1=shop_bankExample.createCriteria();
		c1.andCheckflagEqualTo(i);
		List<Shop_bank> list = shop_bankmapper.selectByExample(shop_bankExample);
		return list;
		
	}



	@Override 
	public List<Shop_bank> selectByTime() {
		List<Shop_bank> banks=shop_bankmapper.selectByTime();
		return banks;
	}

	@Override
	public List<Shop_bank> selectByHeat() {
		List<Shop_bank> banks=shop_bankmapper.selectByHeat(); 
		return banks;
	}

	@Override
	public List<Shop_bank> selectFreeBank() {
		List<Shop_bank> banks=shop_bankmapper.selectFreeBank();   
		return banks;
	}

	@Override
	public List<Shop_bank> selectChargeBank() {
		List<Shop_bank> banks=shop_bankmapper.selectChargeBank(); 
		return banks;
	}

	@Override
	public Shop_bank selectbyBankid(Shop_bank shopbank) {
		Shop_bank bank=shop_bankmapper.selectByBankid(shopbank);
		return bank;
	}

	@Override
	public int updateCheckFlag(Shop_bank shop_bank) {
		
	
		 
		 int i = shop_bankmapper.updateByPrimaryKeySelective(shop_bank);
		 return i;
	}



	@Override
	public List<Shop_bank> bankshopSearch(Shop_bank bank) {
		List<Shop_bank> banks=shop_bankmapper.bankshopSearch(bank);
		return banks;
	}



	@Override
	public List<Shop_bank> selectByUser(User user) {
		List<Shop_bank> banks=shop_bankmapper.selectByUser(user);
		return banks;
	}



	@Override
	public int addShop_bank(Shop_bank shop_bank) {
		int i=shop_bankmapper.insert(shop_bank);
		return i;
	}



	@Override
	public int deleteShop_bank(Shop_bank shop_bank) {
		int i=shop_bankmapper.deleteByPrimaryKey(shop_bank.getBankid());
		return i;
	}



	@Override
	public List<Shop_bank> selectByExample(Shop_bankExample shop_bank) {
		List<Shop_bank> banks = shop_bankmapper.selectByExample(shop_bank);
		for(int i=0;i<banks.size();i++)
		{
			Shop_bank shop_bank2 = banks.get(i);
			int userid =shop_bank2.getUser().getUserid();
			User user = usermapper.selectByPrimaryKey(userid);
			shop_bank2.setUser(user);
			
		}
		return banks;
	}



	@Override
	public int countByExample(Shop_bankExample shop_bank) {
		int count=shop_bankmapper.countByExample(shop_bank);
		
		return count;
	}



	@Override
	public int updateShop_bank(Shop_bank shop_bank) {
		// TODO Auto-generated method stub
		int i = shop_bankmapper.updateByPrimaryKeySelective(shop_bank);
		return i;
	}



	


}
