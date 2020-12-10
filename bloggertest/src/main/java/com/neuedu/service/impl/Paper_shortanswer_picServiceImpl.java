package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_shortanswer_picMapper;
import com.neuedu.entity.Paper_shortanswer_pic;
import com.neuedu.service.Paper_shortanswer_picService;
@Service
public class Paper_shortanswer_picServiceImpl implements Paper_shortanswer_picService {

	@Autowired
	Paper_shortanswer_picMapper paper_shortanswer_picMapper;
	
	@Override
	public int addPaper_shortanswer_pic(Paper_shortanswer_pic psp) {
		// TODO Auto-generated method stub
		int i = paper_shortanswer_picMapper.insert(psp);
		return i;
	}

	@Override
	public int updatePaper_shortanswer_pic(Paper_shortanswer_pic psp) {
		// TODO Auto-generated method stub
		int i = paper_shortanswer_picMapper.updateByPrimaryKeySelective(psp);
		return i;
	}

	@Override
	public int deletePaper_shortanswer_pic(Paper_shortanswer_pic psp) {
		// TODO Auto-generated method stub
		int i = paper_shortanswer_picMapper.deleteByPrimaryKey(psp);
		return i;
	}

	@Override
	public List<Paper_shortanswer_pic> getAllByid(Paper_shortanswer_pic psp) {
		// TODO Auto-generated method stub
		List<Paper_shortanswer_pic> allByid = paper_shortanswer_picMapper.getAllByid(psp.getqId());
		return allByid;
	}

}
