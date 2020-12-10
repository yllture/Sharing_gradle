package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.PayrecordMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Payrecord;
import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.User;
import com.neuedu.service.PayrecordService;
@Service 
public class PayrecordServiceImpl implements PayrecordService {

	@Autowired
	PayrecordMapper payrecordMapper;
	
	@Override
	public int addPayrecord(Payrecord p) {
		// TODO Auto-generated method stub
		int i = payrecordMapper.insert(p);
		
		return i;
	}

	@Override
	public List<Payrecord> getallSolderRecord(User u) {
		// TODO Auto-generated method stub
		List<Payrecord> getallSoldRecord = payrecordMapper.getallSoldRecord(u.getUserid());
		return getallSoldRecord;
	}

	@Override
	public List<Payrecord> getallBuyRecord(User u) {
		// TODO Auto-generated method stub
		List<Payrecord> getallBuyRecord = payrecordMapper.getallBuyRecord(u.getUserid());
		return getallBuyRecord;
	}

	@Override
	public int updateScore(Payrecord payrecord) {
		int i = payrecordMapper.updateByPrimaryKeySelective(payrecord);
		return i;
	}

	@Override
	public List<Payrecord> getallBankRecord(Shop_bank b) {
		// TODO Auto-generated method stub
		
		List<Payrecord> getallBankRecord = payrecordMapper.getallBankRecord(b.getBankid());
		
		return getallBankRecord;
	}

	@Override
	public List<Payrecord> getallPaperRecord(Shop_paper b) {
		// TODO Auto-generated method stub
		List<Payrecord> getallBankRecord = payrecordMapper.getallPaperRecord(b.getPaperid());
		
		
		return getallBankRecord;
	}

	@Override
	public int isPurchaseBank(Payrecord payrecord) {
		// TODO Auto-generated method stub
		
//		System.out.println("****"+payrecord.getBankid()+payrecord.getBuyid());
		Payrecord purchaseBank = payrecordMapper.isPurchaseBank(payrecord);
		if(purchaseBank==null) {
			return 0;
		}else {
			return 1;
		}
		
		
		
	}

	@Override
	public int isPurchasePaper(Payrecord payrecord) {
		// TODO Auto-generated method stub
		
		Payrecord purchasePaper = payrecordMapper.isPurchasePaper(payrecord);
		if(purchasePaper==null) {
			return 0;
		}else {
			return 1;
		}
		
		
	}

	

	@Override
	public int papercancelupload(Payrecord payrecord) {
		// TODO Auto-generated method stub
		int i = payrecordMapper.papercancelupload(payrecord.getPaperid());
		return i;
	}

	@Override
	public int bankcancelupload(Payrecord payrecord) {
		// TODO Auto-generated method stub
		int i = payrecordMapper.bankcancelupload(payrecord.getBankid());
		return i;
	}

	@Override
	public Payrecord selectByPrimarykey(Payrecord payrecord) {
		Payrecord selectByPrimaryKey = payrecordMapper.selectByPrimaryKey(payrecord.getRecordid());
		return selectByPrimaryKey;
	}

	

}
