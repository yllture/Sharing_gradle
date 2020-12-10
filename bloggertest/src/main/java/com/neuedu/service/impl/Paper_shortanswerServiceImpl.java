package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Paper_shortanswerMapper;
import com.neuedu.dao.Paper_shortanswer_movMapper;
import com.neuedu.dao.Paper_shortanswer_picMapper;
import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_shortanswer_mov;
import com.neuedu.entity.Bank_shortanswer_movKey;
import com.neuedu.entity.Bank_shortanswer_pic;
import com.neuedu.entity.Bank_shortanswer_picKey;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_shortanswer_mov;
import com.neuedu.entity.Paper_shortanswer_pic;
import com.neuedu.service.Paper_shortanswerService;
import com.neuedu.service.Paper_shortanswer_movService;
import com.neuedu.service.Paper_shortanswer_picService;
@Service
public class Paper_shortanswerServiceImpl implements Paper_shortanswerService {
	@Autowired
	Paper_shortanswerMapper paper_shortanswerMapper;
	@Autowired
	Paper_shortanswer_movMapper paper_shortanswer_movMapper;
	@Autowired
	Paper_shortanswer_picMapper paper_shortanswer_picMapper;
	@Autowired
	Paper_shortanswer_movService paper_shortanswer_movService;
	@Autowired
	Paper_shortanswer_picService paper_shortanswer_picService;
	
	@Override
	public List<Paper_shortanswer> getAllbyPaperid(Paper paper) {
		// TODO Auto-generated method stub
		List<Paper_shortanswer> shortanswerlist=paper_shortanswerMapper.getAllbyid(paper.getPaperid());
		for(int i=0;i<shortanswerlist.size();i++) {
			Paper_shortanswer_pic psp = new Paper_shortanswer_pic();
			psp.setqId(shortanswerlist.get(i).getqId());
			List<Paper_shortanswer_pic> listpic = paper_shortanswer_picService.getAllByid(psp);
			shortanswerlist.get(i).setShortpiclist(listpic);
			
			Paper_shortanswer_mov psm = new Paper_shortanswer_mov();
			psm.setqId(shortanswerlist.get(i).getqId());
			List<Paper_shortanswer_mov> listmov = paper_shortanswer_movService.getAllByid(psm);
			shortanswerlist.get(i).setShortmovlist(listmov);
		}
		
		
		
		
		return shortanswerlist;
	}
	@Override
	public int addPaper_shortanswer(Paper_shortanswer psa) {
		int i=paper_shortanswerMapper.insert(psa);
		return i;
	}
	@Override
	public int deletePaper_shortanswer(Paper_shortanswer psa) {
		int i=paper_shortanswerMapper.deleteByPrimaryKey(psa.getqId());
		return i;
	}
	@Override
	public int updatePaper_shortanswer(Paper_shortanswer psa) {
		int i=paper_shortanswerMapper.updateByPrimaryKeySelective(psa);
		return i;
	}
	@Override
	public int addPaper_shortanswer2(Bank_shortanswer f, Integer score, Paper paper) {
		Paper_shortanswer pf=new Paper_shortanswer();
		pf.setqTitle(f.getqTitle());
		pf.setqKnowledge(f.getqKnowledge());
		pf.setqAnalysis(f.getqAnalysis());
		pf.setqScore(score);
		pf.setPaperid(paper.getPaperid());
		pf.setqFifficulty(f.getqFifficulty());
		int i=paper_shortanswerMapper.insert(pf);
		List<Bank_shortanswer_mov> movs=f.getShortmovlist();
		if(movs!=null) {
			for(Bank_shortanswer_mov mov:movs) {
				Paper_shortanswer_mov m=new Paper_shortanswer_mov();
				m.setMovie(mov.getMovie());
				m.setqId(pf.getqId());
				paper_shortanswer_movMapper.insert(m);
			}
		}
		
		List<Bank_shortanswer_pic> pics=f.getShortpiclist();
		if(pics!=null) {
			for(Bank_shortanswer_pic pic:pics) {
				Paper_shortanswer_pic m=new Paper_shortanswer_pic();
				m.setPicture(pic.getPicture());
				m.setqId(pf.getqId());
				paper_shortanswer_picMapper.insert(m);
			}
		}
		
		return i;
	}
	@Override
	public Paper_shortanswer selectPaper_shortanswer(Paper_shortanswer ps) {
		Paper_shortanswer p=paper_shortanswerMapper.selectByPrimaryKey(ps.getqId());
		return p;
	}

}
