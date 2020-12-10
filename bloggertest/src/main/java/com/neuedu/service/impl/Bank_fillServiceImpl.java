package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.BankMapper;
import com.neuedu.dao.Bank_fillMapper;
import com.neuedu.dao.Bank_fillchoiceMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.service.Bank_fillService;
@Service
public class Bank_fillServiceImpl implements Bank_fillService {

	@Autowired
	Bank_fillMapper bank_fillMapper;
	@Autowired
	Bank_fillchoiceMapper bank_fillchoiceMapper;
	
	@Override
	public List<Bank_fill> getAllbyBankid(Bank bf) {
		// TODO Auto-generated method stub

		
		List<Bank_fill> allbyBankid = bank_fillMapper.getAllbyBankid(bf.getBankid());
//		List<Bank_fill> allbyBankid=new ArrayList<Bank_fill>();
		return allbyBankid;
	}

	@Override
	public int addBank_fill(Bank_fill bf) {
		int i = bank_fillMapper.insert(bf);
		return i;
	}

	@Override
	public int updateBank_fill(Bank_fill bf) {
		int i = bank_fillMapper.updateByPrimaryKeySelective(bf);
		return 0;
	}

	@Override
	public int deleteBank_fill(Bank_fill bf) {
		// TODO Auto-generated method stub
		int i = bank_fillMapper.deleteByPrimaryKey(bf.getqId());
		return i;
	}

	@Override
	public Bank_fill selectBank_fill(Bank_fill bf) {
		Bank_fill b=bank_fillMapper.selectByPrimaryKey(bf.getqId());
		List<Bank_fillchoice> selectByqid = bank_fillchoiceMapper.selectByqid(bf.getqId());
		b.setFilllsit(selectByqid);
		
		return b;
	}

	

}
