package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Bank_fillMapper;
import com.neuedu.dao.Paper_fillMapper;
import com.neuedu.dao.Paper_fillchoiceMapper;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_fillchoice;
import com.neuedu.entity.Paper_fillchoiceExample;
import com.neuedu.entity.Paper_fillchoiceExample.Criteria;
import com.neuedu.service.Paper_fillService;
@Service
public class Paper_fillServiceImpl implements Paper_fillService {

	@Autowired 
	Paper_fillMapper paper_fillMapper;
	@Autowired
	Paper_fillchoiceMapper paper_fillchoiceMapper;
	@Autowired
	Paper_fillchoiceExample paper_fillchoiceExample;
	@Autowired
	Bank_fillMapper bank_fillMapper;
	@Override
	public List<Paper_fill> getAllbyPaperid(Paper paper) {
		List<Paper_fill> paperfills=paper_fillMapper.getAllbyPaperid(paper.getPaperid());
//		for(Paper_fill paperfill:paperfills) {
//			Criteria c1=paper_fillchoiceExample.createCriteria();
//			c1.andQIdEqualTo(paperfill.getqId());
//			List<Paper_fillchoice> choices = paper_fillchoiceMapper.selectByExample(paper_fillchoiceExample);
//			paperfill.setFilllsit(choices);
//		}
		
		return paperfills;
	}

	@Override
	public int addPaper_fill(Paper_fill pf) {
//		pf.setqId(0);
		int i=paper_fillMapper.insert(pf);
//		int j=pf.getqId();
//		//List<Paper_fillchoice> choices=pf.getFilllsit();
//		System.out.println("��������ֵ"+j);
//		for(Paper_fillchoice pfc:pf.getFilllsit()) {
//			pfc.setqId(j);
//			paper_fillchoiceMapper.insert(pfc);
//		}
		return i;
	}

	@Override
	public int deletePaper_fill(Paper_fill pf) {
		int i=paper_fillMapper.deleteByPrimaryKey(pf.getqId());
		return i;
	}

	@Override
	public int updatePaper_fill(Paper_fill pf) {
		int i=paper_fillMapper.updateByPrimaryKeySelective(pf);
//		for(Paper_fillchoice pfc:pf.getFilllsit()) {
//			paper_fillchoiceMapper.updateByPrimaryKeySelective(pfc);
//		}
		return i;
	}

	@Override
	public int addPaper_fill2(Bank_fill f, Integer score,Paper paper) {
		Paper_fill pf=new Paper_fill();
		pf.setqTitle(f.getqTitle());
		pf.setqKnowledge(f.getqKnowledge());
		pf.setqAnalysis(f.getqAnalysis());
		pf.setqScore(score);
		pf.setPaperid(paper.getPaperid());
		pf.setqDifficulty(f.getqDifficulty());
		int i=paper_fillMapper.insert(pf);
		List<Bank_fillchoice> choices=f.getFilllsit();
		//System.out.println(choices.size());
		for(Bank_fillchoice bfc:choices) {
			Paper_fillchoice pfc=new Paper_fillchoice();
			pfc.setqId(pf.getqId());
			pfc.setSequence(bfc.getSequence());
			pfc.setContent(bfc.getContent());
			paper_fillchoiceMapper.insert(pfc);
		}
		return i;
	}

	@Override
	public Paper_fill selectPaper_fill(Paper_fill pf) {
		// TODO Auto-generated method stub
		Paper_fill p=paper_fillMapper.selectByPrimaryKey(pf.getqId());
		
		List<Paper_fillchoice> selectByqid = paper_fillchoiceMapper.selectByqid(pf.getqId());
		
		p.setFilllist(selectByqid);
		
		return p;
	}

}
