package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.BankfolderMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bankfolder;
import com.neuedu.entity.BankfolderExample;
import com.neuedu.entity.BankfolderExample.Criteria;
import com.neuedu.entity.TreeFolder;
import com.neuedu.entity.User;
import com.neuedu.service.*;
@Service
public class BankfolderServiceImpl implements BankfolderService {

	@Autowired
	BankfolderMapper bankfolderMapper;
	@Autowired
	BankService bankService;

	
	@Override
	public List<Bankfolder> getAllbyUserid(User u) {
		// TODO Auto-generated method stub
		System.out.println(u.getUserid());
		List<Bankfolder> allbyUserid = bankfolderMapper.getAllbyUserid(u.getUserid());
		System.out.println(allbyUserid.size());
		for(int i=0;i<allbyUserid.size();i++) {
		
			List<Bank> banklist = bankService.getAllByFolderid(allbyUserid.get(i));
			if(banklist != null) {
				allbyUserid.get(i).setBanklist(banklist);
			}
			
		}
		
		
		return allbyUserid;
	}

	@Override
	public int addBankfolder(Bankfolder bf) {
		// TODO Auto-generated method stub
		int i = bankfolderMapper.insert(bf);
		return i;
	}

	@Override
	public int updateBankfolder(Bankfolder bf) {
		// TODO Auto-generated method stub
		int i = bankfolderMapper.updateByPrimaryKeySelective(bf);
		return i;
	}

	@Override
	public int deleteBankfolder(Bankfolder bf) {
		// TODO Auto-generated method stub
		int i = bankfolderMapper.deleteByPrimaryKey(bf.getFolderid());
		return i;
	}

	@Override
	public Bankfolder selectByfolderid(Bankfolder bf) {
		// TODO Auto-generated method stub
		
		Bankfolder selectByPrimaryKey = bankfolderMapper.selectByPrimaryKey(bf.getFolderid());
		 
		
		return selectByPrimaryKey;
	}

	@Override
	public List<Bankfolder> getAllbyFolderid(Bankfolder bf) {
		// TODO Auto-generated method stub
		
		List<Bankfolder> allbyFolderid = bankfolderMapper.getAllbyFolderid(bf.getFolderid());
		for(int i=0;i<allbyFolderid.size();i++) {
			
			List<Bank> banklist = bankService.getAllByFolderid(allbyFolderid.get(i));
			if(banklist != null) {
				allbyFolderid.get(i).setBanklist(banklist);
			}
			
		}
		
		return allbyFolderid;
	}

	@Override
	public ArrayList<TreeFolder> getAllArrayForFolder(User u) {
		// TODO Auto-generated method stub
		BankfolderExample bankfolderExample=new BankfolderExample();
		Criteria c1=bankfolderExample.createCriteria();
		c1.andUseridEqualTo(u.getUserid());
		List<Bankfolder> bflist=bankfolderMapper.selectByExample(bankfolderExample);
		ArrayList<TreeFolder> bfArr=new ArrayList<TreeFolder>();
		ArrayList<Bank> bklist=new ArrayList<Bank>();
		for(Bankfolder bf:bflist) {
			TreeFolder tf=new TreeFolder();
			bklist=(ArrayList<Bank>) bankService.getAllByFolderid(bf);
			tf.setId(bf.getFolderid());
			tf.setPid(bf.getC4());
			tf.setTitle(bf.getFoldername());
			tf.setType(0);
			bfArr.add(tf);
			for(Bank bk:bklist) {
				TreeFolder t=new TreeFolder();
				t.setId(bk.getBankid());
				t.setPid(bk.getFolderid());
				t.setTitle(bk.getBankname());
				t.setType(1);
				bfArr.add(t);
			}
		}
		Bank b=new Bank();
		b.setUserid(u.getUserid());
		bklist=(ArrayList<Bank>) bankService.selectAllBank(b);
		for(Bank bk:bklist) {
			TreeFolder t=new TreeFolder();
			t.setId(bk.getBankid());
			t.setPid(bk.getFolderid());
			t.setTitle(bk.getBankname());
			t.setType(1);
			bfArr.add(t);
		}
		
		return bfArr;
	}

}
