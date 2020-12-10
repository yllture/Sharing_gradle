package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_shortanswer_movMapper;
import com.neuedu.entity.Paper_shortanswer_mov;
import com.neuedu.service.Paper_shortanswer_movService;
@Service
public class Paper_shortanswer_movServiceImpl implements Paper_shortanswer_movService{

	@Autowired
	Paper_shortanswer_movMapper paper_shortanswer_movMapper;

	@Override
	public int addPaper_shortanswer_mov(Paper_shortanswer_mov psm) {
		// TODO Auto-generated method stub
		int i = paper_shortanswer_movMapper.insert(psm);
		return i;
	}

	@Override
	public int updatePaper_shortanswer_mov(Paper_shortanswer_mov psm) {
		// TODO Auto-generated method stub
		int i = paper_shortanswer_movMapper.updateByPrimaryKeySelective(psm);
		return i;
	}

	@Override
	public int deletePaper_shortanswer_mov(Paper_shortanswer_mov psm) {
		// TODO Auto-generated method stub
		int i = paper_shortanswer_movMapper.deleteByPrimaryKey(psm);
		return i;
	}

	@Override
	public List<Paper_shortanswer_mov> getAllByid(Paper_shortanswer_mov psm) {
		// TODO Auto-generated method stub
		List<Paper_shortanswer_mov> allByid = paper_shortanswer_movMapper.getAllByid(psm.getqId());
		return allByid;
	}
	

}
