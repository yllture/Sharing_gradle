package com.neuedu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.neuedu.entity.Payrecord;
import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.User;
@Service
public interface PayrecordService {
	int addPayrecord(Payrecord p);
	
	List<Payrecord> getallSolderRecord(User u);
	
	List<Payrecord> getallBuyRecord(User u);
	
	int updateScore(Payrecord payrecord);
	
	List<Payrecord> getallBankRecord(Shop_bank b);
	
	List<Payrecord> getallPaperRecord(Shop_paper b);
	
	int isPurchaseBank(Payrecord payrecord);
	
	int isPurchasePaper(Payrecord payrecord);
	
	int papercancelupload(Payrecord payrecord);
	int bankcancelupload(Payrecord payrecord);

	Payrecord selectByPrimarykey(Payrecord payrecord);
	
}
