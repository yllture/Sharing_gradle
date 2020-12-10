package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_judgeMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Bank_judge;
import com.neuedu.service.Bank_judgeService;
@Service
public class Bank_judgeServiceImpl implements Bank_judgeService {

	@Autowired
	Bank_judgeMapper bank_judgeMapper;
	
	@Override
	public List<Bank_judge> getAllbyBankid(Bank b) {
		// TODO Auto-generated method stub
		List<Bank_judge> allbyBankid = bank_judgeMapper.getAllbyBankid(b.getBankid());
		
		
		return allbyBankid;
	}

	@Override
	public int addBank_judge(Bank_judge bj) {
		// TODO Auto-generated method stub
		int i = bank_judgeMapper.insert(bj);
		return i;
	}

	@Override
	public int updateBank_judge(Bank_judge bj) {
		// TODO Auto-generated method stub
		int i = bank_judgeMapper.updateByPrimaryKeySelective(bj);
		return i;
	}

	@Override
	public int deleteBank_judge(Bank_judge bj) {
		// TODO Auto-generated method stub
		int i = bank_judgeMapper.deleteByPrimaryKey(bj.getqId());
		return i;
	}
	@Override
	public Bank_judge selectBank_judge(Bank_judge bf) {
		Bank_judge b=bank_judgeMapper.selectByPrimaryKey(bf.getqId());
		return b;
	}

}
