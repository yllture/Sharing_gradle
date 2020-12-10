package com.neuedu.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.UsersessionMapper;
import com.neuedu.entity.Usersession;
import com.neuedu.entity.UsersessionExample;
import com.neuedu.service.UsersessionService;

@Service
@MapperScan(basePackages = {"mapper","com.neuedu.dao"})
public class UsersessionServiceImpl implements UsersessionService{
	@Autowired
	UsersessionMapper usersessionMapper;
	
	
	
	@Override
	public Usersession selectUsersessionByUserid(Usersession u) {
		
		UsersessionExample usersessionExample= new UsersessionExample();
		com.neuedu.entity.UsersessionExample.Criteria c1 = usersessionExample.createCriteria();
		//c1.(u.getUseraccount());
		
		c1.andUseridEqualTo(u.getUserid());
		
		List<Usersession> resu = usersessionMapper.selectByExample(usersessionExample);
		Usersession ru = null;
		
		if(resu !=null&&resu.size()!=0) {
			ru = resu.get(0);
		}
		return ru;
	}
	
	@Override
	public int insertUsersession(Usersession u) {
		// TODO Auto-generated method stub
		int i  = usersessionMapper.insert(u);
		return i;
	}
	
	@Override
	public int updateUsersession(Usersession u) {
		// TODO Auto-generated method stub
//		Usersession usersession = selectUsersessionByUserid(u);
		
		int i  = usersessionMapper.updateByPrimaryKey(u);
		return i;
	}

	@Override
	public Usersession selectByUserid(Usersession u) {
		// TODO Auto-generated method stub
		Usersession selectbyUserid = usersessionMapper.selectbyUserid(u.getUserid());
		return selectbyUserid;
	}
}
