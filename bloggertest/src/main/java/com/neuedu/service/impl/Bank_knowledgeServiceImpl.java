package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_knowledgeMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_knowledge;
import com.neuedu.service.Bank_knowledgeService;
@Service
public class Bank_knowledgeServiceImpl implements Bank_knowledgeService {
	@Autowired
	Bank_knowledgeMapper bank_knowledgeMapper;

	@Override
	public int addBank_knowlede(Bank_knowledge bk) {
		// TODO Auto-generated method stub
		int i = bank_knowledgeMapper.insert(bk);
		
		return i;
	}

	@Override
	public List<Bank_knowledge> selectAllbyBankid(Bank b) {
		// TODO Auto-generated method stub
		List<Bank_knowledge> allbyBankid = bank_knowledgeMapper.getAllbyBankid(b.getBankid());
		
		
		return allbyBankid;
	}

}
