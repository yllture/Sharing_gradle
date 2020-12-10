package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Garbage_bankfolderMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bankfolder;
import com.neuedu.entity.Garbage_bankfolder;
import com.neuedu.service.BankService;
import com.neuedu.service.Garbage_bankfolderService;
@Service
public class Garbage_bankfolderServiceImpl implements Garbage_bankfolderService {

	@Autowired
	Garbage_bankfolderMapper garbage_bankfolderMapper;
	@Autowired
	BankService bankService;
	
	@Override
	public int addGarbage_bankfolder(Garbage_bankfolder gb) {
		// TODO Auto-generated method stub
		int i = garbage_bankfolderMapper.insert(gb);
		return i;
	}

	@Override
	public int updateGarbage_bankfolder(Garbage_bankfolder gb) {
		// TODO Auto-generated method stub
		int i = garbage_bankfolderMapper.updateByPrimaryKeySelective(gb);
		return i;
	}

	@Override
	public int deleteGarbage_bankfolder(Garbage_bankfolder gb) {
		// TODO Auto-generated method stub
		int i = garbage_bankfolderMapper.deleteByPrimaryKey(gb.getFolderid());
		return i;
	}

	@Override
	public Garbage_bankfolder seleteByfolderid(Garbage_bankfolder gb) {
		// TODO Auto-generated method stub
		Garbage_bankfolder selectByPrimaryKey = garbage_bankfolderMapper.selectByPrimaryKey(gb.getFolderid());
		return selectByPrimaryKey;
	}

	@Override
	public List<Garbage_bankfolder> getAllByuserid(Garbage_bankfolder gb) {
		// TODO Auto-generated method stub
		List<Garbage_bankfolder> allByuserid = garbage_bankfolderMapper.getAllByuserid(gb.getUserid());
		for(int i=0;i<allByuserid.size();i++) {
			
			Bankfolder b = new Bankfolder();
			b.setFolderid(allByuserid.get(i).getFolderid());
			List<Bank> banklist = bankService.getAllByFolderid(b);
			if(banklist != null) {
				allByuserid.get(i).setBanklist(banklist);
			}
			
		}
		
		
		return allByuserid;
	}

	@Override
	public List<Garbage_bankfolder> getAllByfoldermapping(Garbage_bankfolder gb) {
		// TODO Auto-generated method stub
		List<Garbage_bankfolder> allByfoldermapping = garbage_bankfolderMapper.getAllByfoldermapping(gb.getFoldermapping());
		return allByfoldermapping;
	}

}
