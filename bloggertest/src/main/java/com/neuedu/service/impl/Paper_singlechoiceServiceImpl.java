package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_singlechoiceMapper;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Paper_singlechoice;
import com.neuedu.service.Paper_singlechoiceService;
@Service
public class Paper_singlechoiceServiceImpl implements Paper_singlechoiceService {
	@Autowired
	Paper_singlechoiceMapper paper_singlechoiceMapper;

	@Override
	public int addPaper_singlechoice(Paper_singlechoice choice) {
		int i=paper_singlechoiceMapper.insert(choice);
		return i;
	}

	@Override
	public int deletePaper_singlechoice(Paper_singlechoice choice) {
		int i=paper_singlechoiceMapper.deleteByPrimaryKey(choice.getChoiceid());
		return i;
	}

	@Override
	public int updatePaper_singlechoice(Paper_singlechoice choice) {
		int i=paper_singlechoiceMapper.updateByPrimaryKeySelective(choice);
		return i;
	}

	@Override
	public List<Paper_singlechoice> selectByqid(Paper_singlechoice choice) {
		// TODO Auto-generated method stub
		List<Paper_singlechoice> selectByqid = paper_singlechoiceMapper.selectByqid(choice.getqId());
		return selectByqid;
	}



}
