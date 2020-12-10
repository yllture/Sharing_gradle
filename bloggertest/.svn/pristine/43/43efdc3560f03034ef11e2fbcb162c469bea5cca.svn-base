package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Garbage_bankMapper;
import com.neuedu.entity.Garbage_bank;
import com.neuedu.service.Garbage_bankService;
@Service
public class Garbage_bankServiceImpl implements Garbage_bankService {

	@Autowired
	Garbage_bankMapper garbage_bankMapper;
	
	
	
	@Override
	public Garbage_bank selectGarbage_bank(Garbage_bank gb) {
		// TODO Auto-generated method stub
		
		Garbage_bank selectByPrimaryKey = garbage_bankMapper.selectByPrimaryKey(gb.getBankid());
		
		return selectByPrimaryKey;
	}

	@Override
	public int addGarbage_bank(Garbage_bank gb) {
		// TODO Auto-generated method stub
		int i = garbage_bankMapper.insert(gb);
		return i;
	}

	@Override
	public int updateGarbage_bank(Garbage_bank gb) {
		// TODO Auto-generated method stub
		int i = garbage_bankMapper.updateByPrimaryKeySelective(gb);
		return i;
	}

	@Override
	public int deleteGarbage_bank(Garbage_bank gb) {
		// TODO Auto-generated method stub
		int i = garbage_bankMapper.deleteByPrimaryKey(gb.getBankid());
		return i;
	}

	@Override
	public List<Garbage_bank> getAllByuserid(Garbage_bank gb) {
		// TODO Auto-generated method stub
		List<Garbage_bank> allByUserid = garbage_bankMapper.getAllByUserid(gb.getUserid());
		return allByUserid;
	}

	@Override
	public List<Garbage_bank> getAllFolderid(Garbage_bank gb) {
		// TODO Auto-generated method stub
		List<Garbage_bank> allByFolderid = garbage_bankMapper.getAllByFolderid(gb.getFolderid());
		return allByFolderid;
	}

}
