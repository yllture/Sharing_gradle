package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.GroupapplyMapper;
import com.neuedu.entity.Groupapply;
import com.neuedu.entity.GroupapplyExample;
import com.neuedu.entity.GroupapplyExample.Criteria;
import com.neuedu.entity.Groups;
import com.neuedu.entity.User;
import com.neuedu.service.GroupapplyService;
import com.neuedu.service.GroupsService;
import com.neuedu.service.UserService;
@Service
public class GroupapplyServiceImpl implements GroupapplyService {

	@Autowired
	GroupapplyMapper groupapplyMapper;
	@Autowired
	UserService userService;
	@Autowired
	GroupsService groupsService;
	@Override
	public int addGroupapply(Groupapply groupapply) {
		// TODO Auto-generated method stub
		int i=groupapplyMapper.insert(groupapply);
		return i;
	}
	@Override
	public List<Groupapply> selectGroupapplyByGroupid(int groupid) {
		// TODO Auto-generated method stub
		GroupapplyExample groupapplyExample=new GroupapplyExample();
		Criteria c1=groupapplyExample.createCriteria();
		c1.andGroupidEqualTo(groupid);
		List<Groupapply> galist=groupapplyMapper.selectByExample(groupapplyExample);
		return galist;
	}
	@Override
	public List<User> selectUserFromGroupapply(int groupid) {
		// TODO Auto-generated method stub
		List<Groupapply> galist=selectGroupapplyByGroupid(groupid);
		List<User> userlist=new ArrayList<User>();
		for(Groupapply ga:galist) {
			User u=new User();
			u.setUserid(ga.getApplyid());
			userlist.add(userService.selectUserByPrimaryKey(u));
		}
		return userlist;
	}
	
	@Override
	public List<Groups> selectGroupFromGroupapply(int groupid) {
		// TODO Auto-generated method stub
		List<Groupapply> galist=selectGroupapplyByGroupid(groupid);
		List<Groups> glist=new ArrayList<Groups>();
		for(Groupapply ga:galist) {
			glist.add(groupsService.selectGroupsByGroupid(ga.getGroupid()));
		}
		return glist;
	}
	@Override
	public int updateType(Groupapply groupapply) {
		// TODO Auto-generated method stub
		
		int i=groupapplyMapper.updateByPrimaryKey(groupapply);
		return i;
	}

}
