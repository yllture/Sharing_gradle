package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_multipleMapper;
import com.neuedu.dao.Bank_multiplechoiceMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_multiple;
import com.neuedu.entity.Bank_multiplechoice;
import com.neuedu.entity.Bank_multiple;
import com.neuedu.service.Bank_multipleService;

@Service
public class Bank_multipleServiceImpl implements Bank_multipleService{

	@Autowired
	Bank_multipleMapper bank_multipleMapper;
	@Autowired
	Bank_multiplechoiceMapper bank_multiplechoiceMapper;
	
	@Override
	public List<Bank_multiple> getAllbyBankid(Bank b) {
		// TODO Auto-generated method stub
		List<Bank_multiple> getallByBankid = bank_multipleMapper.getAllbyBankid(b.getBankid());
		
		return getallByBankid;
	}

	@Override
	public int addBank_multiple(Bank_multiple bm) {
		// TODO Auto-generated method stub
		
		int i = bank_multipleMapper.insert(bm);
		
		return i;
	}

	@Override
	public int updateBank_multiple(Bank_multiple bm) {
		// TODO Auto-generated method stub
		int i = bank_multipleMapper.updateByPrimaryKeySelective(bm);
		
		return i;
	}

	@Override
	public int deleteBank_multiple(Bank_multiple bm) {
		// TODO Auto-generated method stub
		
		int i = bank_multipleMapper.deleteByPrimaryKey(bm.getqId());
		return i;
	}
	@Override
	public Bank_multiple selectBank_multiple(Bank_multiple bf) {
		Bank_multiple b=bank_multipleMapper.selectByPrimaryKey(bf.getqId());
		
		List<Bank_multiplechoice> selectByqid = bank_multiplechoiceMapper.selectByqid(bf.getqId());
		
		b.setMultiplelist(selectByqid);
		return b;
	}
	
}
