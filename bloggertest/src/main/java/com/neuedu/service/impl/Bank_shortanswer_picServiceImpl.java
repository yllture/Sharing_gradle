package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_shortanswer_picMapper;
import com.neuedu.entity.Bank_shortanswer_pic;
import com.neuedu.entity.Bank_shortanswer_picKey;
import com.neuedu.service.Bank_shortanswer_picService;
@Service
public class Bank_shortanswer_picServiceImpl implements Bank_shortanswer_picService {

	@Autowired
	Bank_shortanswer_picMapper  bank_shortanswer_picMapper;
	
	
	@Override
	public int updateBank_shortanswer_pic(Bank_shortanswer_pic bsp) {
		// TODO Auto-generated method stub
		int i = bank_shortanswer_picMapper.updateByPrimaryKeySelective(bsp);
		
		return i;
	}

	@Override
	public int deleteBank_shortanswer_pic(Bank_shortanswer_pic bsp) {
		// TODO Auto-generated method stub
		
		int i = bank_shortanswer_picMapper.deleteByPrimaryKey(bsp);
		return i;
	}

	@Override
	public int addBank_shortanswer_pic(Bank_shortanswer_pic bsp) {
		// TODO Auto-generated method stub
		
		int i= bank_shortanswer_picMapper.insert(bsp);
		return i;
	}

	@Override
	public List<Bank_shortanswer_pic> getAllByid(Bank_shortanswer_pic bsp) {
		// TODO Auto-generated method stub
		List<Bank_shortanswer_pic> allByid = bank_shortanswer_picMapper.getAllByid(bsp.getqId());
		return allByid;
	}

	


}
