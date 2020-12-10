package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.Shop_paperMapper;
import com.neuedu.dao.UserMapper;
import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_bankExample;
import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.Shop_paperExample;
import com.neuedu.entity.User;
import com.neuedu.service.Shop_paperService;
@Service
public class Shop_paperServiceImpl implements Shop_paperService{

	
	@Autowired
	Shop_paperMapper shop_papermapper;
	@Autowired
	Shop_paperExample shop_paperExample;
	@Autowired
	UserMapper usermapper;


	@Override
	public List<Shop_paper> selectByType(Shop_paper paper) {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectByType(paper);
		return papers;  
	}



	@Override
	public List<Shop_paper> selectByLabel(Shop_paper paper) {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectByLabel(paper);
		
		return papers;
	}



	@Override
	public List<Shop_paper> selectByTime() {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectByTime();
		return papers;
	}



	@Override
	public List<Shop_paper> selectByHeat() {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectByHeat();
		return papers;
	}



	@Override
	public List<Shop_paper> selectFreepaper() {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectFreepaper();
		return papers;
	}



	@Override
	public List<Shop_paper> selectChargepaper() {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectChargepaper();
		return papers;
	}
 


	@Override
	public List<Shop_paper> selectByCheckFlag(int i) {
		shop_paperExample=new Shop_paperExample();
		com.neuedu.entity.Shop_paperExample.Criteria c1=shop_paperExample.createCriteria();
		c1.andCheckflagEqualTo(i);
		List<Shop_paper> list = shop_papermapper.selectByExample(shop_paperExample);
		return list;
	}

    @Override
	public int updateCheckFlag(Shop_paper paper) {
		// TODO Auto-generated method stub
    	 int i = shop_papermapper.updateByPrimaryKeySelective(paper);
		 return i;
	}



	@Override
	public Shop_paper selectbypaperid(Shop_paper shoppaper) {
		Shop_paper paper=shop_papermapper.selectbyPaperId(shoppaper);
		return paper;
	}



	@Override
	public List<Shop_paper> papershopSearch(Shop_paper paper) {
		List<Shop_paper> papers = shop_papermapper.papershopSearch(paper);
		return papers;
	}



	@Override
	public List<Shop_paper> selectByUser(User user) {
		List<Shop_paper> papers = shop_papermapper.selectByUser(user);
		return papers;
	}



	@Override
	public int addShop_paper(Shop_paper shop_Paper) {
		int i= shop_papermapper.insert(shop_Paper);
		return i;
	}



	@Override
	public int deleteShop_paper(Shop_paper shop_paper) {
		int i = shop_papermapper.deleteByPrimaryKey(shop_paper.getPaperid());
		return i;
	}



	@Override
	public int countByExample(Shop_paperExample shop_paper) {
		// TODO Auto-generated method stub
		int count=shop_papermapper.countByExample(shop_paper);
		return count;
	}



	@Override
	public List<Shop_paper> selectByExample(Shop_paperExample shop_paper) {
		// TODO Auto-generated method stub
		List<Shop_paper> papers=shop_papermapper.selectByExample(shop_paper);
		for(int i=0;i<papers.size();i++)
		{
			int userid =papers.get(i).getWinder();
			User user = usermapper.selectByPrimaryKey(userid);
			papers.get(i).setUser(user);
		}
		return papers;
	}
 
}
