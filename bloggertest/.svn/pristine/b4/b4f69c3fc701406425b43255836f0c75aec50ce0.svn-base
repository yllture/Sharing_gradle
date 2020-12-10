package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_multipleMapper;
import com.neuedu.dao.Paper_multiplechoiceMapper;
import com.neuedu.entity.Bank_multiple;
import com.neuedu.entity.Bank_multiplechoice;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.service.Paper_multipleService;
@Service
public class Paper_multipleServiceImpl implements Paper_multipleService {
	@Autowired
	Paper_multipleMapper paper_multipleMapper;
	@Autowired
	Paper_multiplechoiceMapper paper_multiplechoiceMapper;
	@Override
	public List<Paper_multiple> getAllbyPaperid(Paper paper) {
		// TODO Auto-generated method stub
		List<Paper_multiple> multiples=paper_multipleMapper.getAllbyPaperid(paper.getPaperid());
		
		return multiples;
	}
	@Override
	public int addPaper_multiple(Paper_multiple pf) {
		int i=paper_multipleMapper.insert(pf);
		return i;
	}
	@Override
	public int deletePaper_multiple(Paper_multiple pf) {
		int i=paper_multipleMapper.deleteByPrimaryKey(pf.getqId());
		return i;
	}
	@Override
	public int updatePaper_multiple(Paper_multiple pf) {
		int i=paper_multipleMapper.updateByPrimaryKeySelective(pf);
		return i;
	}
	@Override
	public int addPaper_multiple2(Bank_multiple f, Integer score, Paper paper) {
		Paper_multiple pf=new Paper_multiple();
		pf.setqTitle(f.getqTitle());
		pf.setqKnowledge(f.getqKnowledge());
		pf.setqAnalysis(f.getqAnalysis());
		pf.setqScore(score);
		pf.setPaperid(paper.getPaperid());
		pf.setqDifficulty(f.getqDifficulty());
		int i=paper_multipleMapper.insert(pf);
		List<Bank_multiplechoice> choices=f.getMultiplelist();
		//System.out.println(choices.size());
		for(Bank_multiplechoice bfc:choices) {
			Paper_multiplechoice pfc=new Paper_multiplechoice();
			pfc.setqId(pf.getqId());
			pfc.setSequence(bfc.getSequence());
			pfc.setContent(bfc.getContent());
			pfc.setType(bfc.getType());
			pfc.setPicture(bfc.getPicture());
			paper_multiplechoiceMapper.insert(pfc);
		}
		return i;
	}
	@Override
	public Paper_multiple selectPaper_multiple(Paper_multiple pm) {
		Paper_multiple p=paper_multipleMapper.selectByPrimaryKey(pm.getqId());
		
		List<Paper_multiplechoice> selectByqid = paper_multiplechoiceMapper.selectByqid(pm.getqId());
		
		p.setMultiplelist(selectByqid);
		return p;
	}

}
