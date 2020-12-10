package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_fillchoiceMapper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_fillchoice;
import com.neuedu.service.Paper_fillchoiceService;
@Service
public class Paper_fillchoiceServiceImpl implements Paper_fillchoiceService {
	@Autowired
	Paper_fillchoiceMapper paper_fillchoiceMapper;

	@Override
	public int addPaper_fillchoice(Paper_fillchoice choice) {
		int i=paper_fillchoiceMapper.insert(choice);
		return i;
	}

	@Override
	public int deletePaper_fillchoice(Paper_fillchoice choice) {
		int i=paper_fillchoiceMapper.deleteByPrimaryKey(choice.getChoiceid());
		return i;
	}

	@Override
	public int updatePaper_fillchoice(Paper_fillchoice choice) {
		int i=paper_fillchoiceMapper.updateByPrimaryKeySelective(choice);
		return i;
	}

	@Override
	public List<Paper_fillchoice> selectByqid(Paper_fillchoice choice) {
		// TODO Auto-generated method stub
		
		List<Paper_fillchoice> selectByqid = paper_fillchoiceMapper.selectByqid(choice.getqId());
		return selectByqid;
	}

	
}
