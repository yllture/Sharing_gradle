package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_fillchoiceMapper;
import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.service.Bank_fillchoiceService;
@Service
public class Bank_fillchoiceServiceImpl implements Bank_fillchoiceService {

	@Autowired 
	Bank_fillchoiceMapper bank_fillchoiceMapper;
	
	@Override
	public int updateBankfillchoice(Bank_fillchoice bfc) {
		// TODO Auto-generated method stub
		
		int i = bank_fillchoiceMapper.updateByPrimaryKeySelective(bfc);
		return i;
	}

	@Override
	public int deleteBankfillchoice(Bank_fillchoice bfc) {
		// TODO Auto-generated method stub
		
		int i = bank_fillchoiceMapper.deleteByPrimaryKey(bfc.getChoiceid());
		return i;
	}

	@Override
	public int addBank_fillchoice(Bank_fillchoice choice) {
		int i=bank_fillchoiceMapper.insert(choice);
		return i;
	}

	@Override
	public List<Bank_fillchoice> selectByqid(Bank_fillchoice choice) {
		// TODO Auto-generated method stub
		
		List<Bank_fillchoice> selectByqid = bank_fillchoiceMapper.selectByqid(choice.getqId());
		return selectByqid;
	}

}
