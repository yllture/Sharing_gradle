package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_singleMapper;
import com.neuedu.dao.Paper_singlechoiceMapper;
import com.neuedu.entity.Bank_singlechoice;
import com.neuedu.entity.Bank_single;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Paper_singlechoice;
import com.neuedu.entity.Paper_single;
import com.neuedu.service.Paper_singleService;
@Service
public class Paper_singleServiceImpl implements Paper_singleService {
	@Autowired
	Paper_singleMapper paper_singleMapper;
	@Autowired
	Paper_singlechoiceMapper paper_singlechoiceMapper;
	@Override
	public List<Paper_single> getAllbyPaperid(Paper paper) {
		// TODO Auto-generated method stub
		List<Paper_single> singlelist=paper_singleMapper.getAllbyPaperid(paper.getPaperid());
		return singlelist;
	}
	@Override
	public int addPaper_single(Paper_single ps) {
		int i=paper_singleMapper.insert(ps);
		return i;
	}
	@Override
	public int deletePaper_single(Paper_single ps) {
		int i=paper_singleMapper.deleteByPrimaryKey(ps.getqId());
		return i;
	}
	@Override
	public int updatePaper_single(Paper_single ps) {
		int i=paper_singleMapper.updateByPrimaryKeySelective(ps);
		return i;
	}
	@Override
	public int addPaper_single(Bank_single f, Integer score, Paper paper) {
		Paper_single pf=new Paper_single();
		pf.setqTitle(f.getqTitle());
		pf.setqKnowledge(f.getqKnowledge());
		pf.setqAnalysis(f.getqAnalysis());
		pf.setqScore(score);
		pf.setPaperid(paper.getPaperid());
		pf.setqDifficulty(f.getqDifficulty());
		int i=paper_singleMapper.insert(pf);
		List<Bank_singlechoice> choices=f.getSinglelist();
		//System.out.println(choices.size());
		for(Bank_singlechoice bfc:choices) {
			Paper_singlechoice pfc=new Paper_singlechoice();
			pfc.setqId(pf.getqId());
			pfc.setSequence(bfc.getSequence());
			pfc.setContent(bfc.getContent());
			pfc.setType(bfc.getType());
			pfc.setPicture(bfc.getPicture());
			paper_singlechoiceMapper.insert(pfc);
		}
		return i;
	}
	@Override
	public Paper_single selectPaper_single(Paper_single ps) {
		Paper_single p=paper_singleMapper.selectByPrimaryKey(ps.getqId());
		List<Paper_singlechoice> selectByqid = paper_singlechoiceMapper.selectByqid(ps.getqId());
		p.setSinglelist(selectByqid);
		return p;
	}

}
