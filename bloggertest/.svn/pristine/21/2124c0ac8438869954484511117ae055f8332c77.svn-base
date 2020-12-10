package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


import com.neuedu.dao.AdiminMapper;
import com.neuedu.entity.Adimin;
import com.neuedu.entity.AdiminExample;
import com.neuedu.entity.AdiminExample.Criteria;
import com.neuedu.service.AdminService;

@Service

public class AdminServiceImpl implements AdminService{
	@Autowired
	AdiminExample adiminExample; 
	@Autowired
	AdiminMapper adiminMapper;
	@Override
	public List<Adimin> SelectByAdminName(String name) {
		// TODO Auto-generated method stub
		Criteria c1=adiminExample.createCriteria();
		c1.andNameEqualTo(name);
		List<Adimin> admins = adiminMapper.selectByExample(adiminExample);
		return admins;
	}

	@Override
	public Adimin SelectByAdminId(int id) {
		// TODO Auto-generated method stub
		Adimin selectByPrimaryKey = adiminMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

}
