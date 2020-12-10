package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_shortanswerMapper;
import com.neuedu.dao.Bank_shortanswer_movMapper;
import com.neuedu.dao.Bank_shortanswer_picMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_shortanswer_mov;
import com.neuedu.entity.Bank_shortanswer_pic;
import com.neuedu.service.Bank_shortanswerService;
import com.neuedu.service.*;

@Service
public class Bank_shortanswerServiceImpl implements Bank_shortanswerService {

	@Autowired
	Bank_shortanswerMapper bank_shortanswerMapper;
	@Autowired
	Bank_shortanswer_movService bank_shortanswer_movService;
	@Autowired
	Bank_shortanswer_picService bank_shortanswer_picService;
	
	@Override
	public List<Bank_shortanswer> getAllbyBankid(Bank b) {
		// TODO Auto-generated method stub
		List<Bank_shortanswer> allbyBankid = bank_shortanswerMapper.getAllbyBankid(b.getBankid());
		for(int i=0;i<allbyBankid.size();i++) {
			
			Bank_shortanswer_pic bsp = new Bank_shortanswer_pic();
			bsp.setqId(allbyBankid.get(i).getqId());
			List<Bank_shortanswer_pic> listpic = bank_shortanswer_picService.getAllByid(bsp);
			allbyBankid.get(i).setShortpiclist(listpic);
			
			
			Bank_shortanswer_mov bsm = new Bank_shortanswer_mov();
			bsm.setqId(allbyBankid.get(i).getqId());
			List<Bank_shortanswer_mov> listmov = bank_shortanswer_movService.getAllByid(bsm);
			allbyBankid.get(i).setShortmovlist(listmov);
		}
		
		return allbyBankid;
	}


	@Override
	public int addBank_shortanswer(Bank_shortanswer bsa) {
		// TODO Auto-generated method stub
		int i = bank_shortanswerMapper.insert(bsa);
		
		return i;
	}


	@Override
	public int updateBank_shortanswer(Bank_shortanswer bsa) {
		// TODO Auto-generated method stub
		
		int i = bank_shortanswerMapper.updateByPrimaryKeySelective(bsa);
		
		return i;
	}


	@Override
	public int deleteBank_shortanswer(Bank_shortanswer bsa) {
		// TODO Auto-generated method stub
		int i = bank_shortanswerMapper.deleteByPrimaryKey(bsa.getqId());
		return i;
	}
	@Override
	public Bank_shortanswer selectBank_shortanswer(Bank_shortanswer bf) {
		Bank_shortanswer b=bank_shortanswerMapper.selectByPrimaryKey(bf.getqId());
		return b;
	}
}
