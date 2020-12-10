package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_singlechoiceMapper;
import com.neuedu.entity.Bank_singlechoice;
import com.neuedu.service.Bank_singlechoiceService;
@Service
public class Bank_singlechoiceServiceImpl implements Bank_singlechoiceService {

	@Autowired
	Bank_singlechoiceMapper bank_singlechoiceMapper;
	
	@Override
	public int updateBank_singlechoice(Bank_singlechoice bsc) {
		// TODO Auto-generated method stub
		int i = bank_singlechoiceMapper.updateByPrimaryKeySelective(bsc);
		
		return i;
	}

	@Override
	public int deleteBank_singlechoice(Bank_singlechoice bsc) {
		// TODO Auto-generated method stub
		int i = bank_singlechoiceMapper.deleteByPrimaryKey(bsc.getChoiceid());
		 
		return i;
	}

	@Override
	public int addBank_singlechoice(Bank_singlechoice choice) {
		int i = bank_singlechoiceMapper.insert(choice);
		
		return i;
	}

	@Override
	public List<Bank_singlechoice> selectByqid(Bank_singlechoice choice) {
		// TODO Auto-generated method stub
		List<Bank_singlechoice> selectByqid = bank_singlechoiceMapper.selectByqid(choice.getqId());
		
		return selectByqid;
	}

}
