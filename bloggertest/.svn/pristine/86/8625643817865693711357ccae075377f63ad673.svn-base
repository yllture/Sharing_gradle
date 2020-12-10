package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_singleMapper;
import com.neuedu.dao.Bank_singlechoiceMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_single;
import com.neuedu.entity.Bank_singlechoice;
import com.neuedu.entity.Bank_single;
import com.neuedu.service.Bank_singleService;

@Service
public class Bank_singleServiceImpl implements Bank_singleService{

	@Autowired
	Bank_singleMapper bank_singleMapper;
	@Autowired
	Bank_singlechoiceMapper bank_singlechoiceMapper;
	
	
	@Override
	public List<Bank_single> getAllbyBankid(Bank b) {
		// TODO Auto-generated method stub
		List<Bank_single> allbyBankid = bank_singleMapper.getAllbyBankid(b.getBankid());
		
		return allbyBankid;
	}


	@Override
	public int addBank_single(Bank_single bs) {
		// TODO Auto-generated method stub
		int i = bank_singleMapper.insert(bs);
		return i;
	}


	@Override
	public int updateBank_single(Bank_single bs) {
		// TODO Auto-generated method stub
		int i = bank_singleMapper.updateByPrimaryKeySelective(bs);
		return i;
	}


	@Override
	public int deleteBank_single(Bank_single bs) {
		// TODO Auto-generated method stub
		int i = bank_singleMapper.deleteByPrimaryKey(bs.getqId());
		return i;
	}
	@Override
	public Bank_single selectBank_single(Bank_single bf) {
		Bank_single b=bank_singleMapper.selectByPrimaryKey(bf.getqId());
		List<Bank_singlechoice> selectByqid = bank_singlechoiceMapper.selectByqid(bf.getqId());
		b.setSinglelist(selectByqid);
		return b;
	}

}
