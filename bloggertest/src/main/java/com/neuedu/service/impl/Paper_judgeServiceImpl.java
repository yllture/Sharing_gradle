package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_judgeMapper;
import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_judge;
import com.neuedu.service.Paper_judgeService;

@Service
public class Paper_judgeServiceImpl implements Paper_judgeService {
	@Autowired
	Paper_judgeMapper paper_judgeMapper;
	@Override
	public List<Paper_judge> getAllbyPaperid(Paper paper) {
		List<Paper_judge> judges=paper_judgeMapper.getAllbyPaperid(paper.getPaperid());
		return judges;
	}

	@Override
	public int addPaper_judge(Paper_judge pf) {
		int i=paper_judgeMapper.insert(pf);
		return i;
	}

	@Override
	public int deletePaper_judge(Paper_judge pf) {
		int i=paper_judgeMapper.deleteByPrimaryKey(pf.getqId());
		return i;
	}

	@Override
	public int updatePaper_judge(Paper_judge pf) {
		int i=paper_judgeMapper.updateByPrimaryKey(pf);
		return i;
	}

	@Override
	public int addPaper_judge2(Bank_judge f, Integer score, Paper paper) {
		Paper_judge pf=new Paper_judge();
		pf.setqTitle(f.getqTitle());
		pf.setqKnowledge(f.getqKnowledge());
		pf.setqAnalysis(f.getqAnalysis());
		pf.setqScore(score);
		pf.setPaperid(paper.getPaperid());
		pf.setqDifficulty(f.getqDifficulty());
		pf.setIsture(f.getIsture());
		int i=paper_judgeMapper.insert(pf);
		return i;

	}

	@Override
	public Paper_judge selectPaper_judge(Paper_judge pf) {
		Paper_judge p=paper_judgeMapper.selectByPrimaryKey(pf.getqId());
		return p;
	}

}
