package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_shortanswer_movMapper;
import com.neuedu.entity.Bank_shortanswer_mov;
import com.neuedu.entity.Bank_shortanswer_movKey;
import com.neuedu.service.Bank_shortanswer_movService;
@Service
public class Bank_shortanswer_movServiceImpl implements Bank_shortanswer_movService {
	@Autowired
	Bank_shortanswer_movMapper bank_shortanswer_movMapper;
	
	
	
	@Override
	public int updateBank_shortanswer_mov(Bank_shortanswer_mov bsm) {
		// TODO Auto-generated method stub
		int i = bank_shortanswer_movMapper.updateByPrimaryKeySelective(bsm);
		return i;
	}

	@Override
	public int deleteBank_shortanswer_mov(Bank_shortanswer_mov bsm) {
		// TODO Auto-generated method stub
		int i = bank_shortanswer_movMapper.deleteByPrimaryKey(bsm);
		return i;
	}

	@Override
	public int addBank_shortanswer_mov(Bank_shortanswer_mov bsm) {
		// TODO Auto-generated method stub
		int i = bank_shortanswer_movMapper.insert(bsm);
		return i;
	}

	@Override
	public List<Bank_shortanswer_mov> getAllByid(Bank_shortanswer_mov bsm) {
		// TODO Auto-generated method stub
		List<Bank_shortanswer_mov> allByid = bank_shortanswer_movMapper.getAllByid(bsm.getqId());
		return allByid;
	}



	
}
