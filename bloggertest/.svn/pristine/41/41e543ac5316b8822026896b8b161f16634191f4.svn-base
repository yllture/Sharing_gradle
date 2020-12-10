package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_multiplechoiceMapper;
import com.neuedu.entity.Bank_multiplechoice;
import com.neuedu.service.Bank_multiplechoiceService;
@Service
public class Bank_multiplechoiceServiceImpl implements Bank_multiplechoiceService{

	@Autowired
	Bank_multiplechoiceMapper bank_multiplechoiceMapper;
	
	@Override
	public int updateBank_multiplechoice(Bank_multiplechoice bmc) {
		// TODO Auto-generated method stub
		int i = bank_multiplechoiceMapper.updateByPrimaryKeySelective(bmc);

		return i;
	}

	@Override
	public int deleteBank_multiplechoice(Bank_multiplechoice bmc) {
		// TODO Auto-generated method stub
		int i = bank_multiplechoiceMapper.deleteByPrimaryKey(bmc.getChoiceid());
		
		return i;
	}

	@Override
	public int addBank_multiplechoice(Bank_multiplechoice choice) {
		// TODO Auto-generated method stub
		int i = bank_multiplechoiceMapper.insert(choice);
		return i;
	}

	@Override
	public List<Bank_multiplechoice> selectByqid(Bank_multiplechoice choice) {
		// TODO Auto-generated method stub
		
		List<Bank_multiplechoice> selectByqid = bank_multiplechoiceMapper.selectByqid(choice.getqId());
		
		return selectByqid;
	}
	

}
