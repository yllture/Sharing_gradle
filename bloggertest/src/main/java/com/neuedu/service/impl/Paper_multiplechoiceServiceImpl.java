package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_multiplechoiceMapper;
import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.service.Paper_multiplechoiceService;
@Service
public class Paper_multiplechoiceServiceImpl implements Paper_multiplechoiceService {
	@Autowired
	Paper_multiplechoiceMapper paper_multiplechoiceMapper;

	@Override
	public int addPaper_multiplechoice(Paper_multiplechoice choice) {
		int i=paper_multiplechoiceMapper.insert(choice);
		return i;
	}

	@Override
	public int deletePaper_multiplechoice(Paper_multiplechoice choice) {
		int i=paper_multiplechoiceMapper.deleteByPrimaryKey(choice.getChoiceid());
		return i;
	}

	@Override
	public int updatePaper_multiplechoice(Paper_multiplechoice choice) {
		int i=paper_multiplechoiceMapper.updateByPrimaryKeySelective(choice);
		return i;
	}

	@Override
	public List<Paper_multiplechoice> selectByqid(Paper_multiplechoice choice) {
		// TODO Auto-generated method stub
		List<Paper_multiplechoice> selectByqid = paper_multiplechoiceMapper.selectByqid(choice.getqId());
		
		return selectByqid;
	}

	
}
