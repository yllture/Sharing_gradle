package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.GroupmemberMapper;
import com.neuedu.dao.GroupsMapper;
import com.neuedu.entity.Groupmember;
import com.neuedu.entity.GroupmemberExample;
import com.neuedu.entity.GroupmemberExample.Criteria;
import com.neuedu.entity.Groups;
import com.neuedu.entity.GroupsExample;
import com.neuedu.entity.User;
import com.neuedu.service.GroupmemberService;
import com.neuedu.service.UserService;

@Service
public class GroupmemberServiceImpl implements GroupmemberService{

	@Autowired
	GroupmemberMapper groupmemberMapper;
	
	/*
	 * @Autowired GroupmemberExample groupmemberExample;
	 */
	
	@Autowired
	GroupsMapper groupsMapper;
	@Autowired
	UserService userService;
	
	@Override
	public int addMember(Groupmember gm) {
		// TODO Auto-generated method stub
		int i =groupmemberMapper.insert(gm);
		//System.out.print(i);
		return i;
	}

	@Override
	public List<Groupmember> selectmemGroups(int userid) {
		GroupmemberExample groupmemberExample=new GroupmemberExample();
		Criteria c1=groupmemberExample.createCriteria();
		c1.andMemberidEqualTo(userid);
		List<Groupmember> selectAllGroups = groupmemberMapper.selectByExample(groupmemberExample);
		return selectAllGroups;
	}

	@Override
	public List<Groups> selectGroups(int userid) {
		// TODO Auto-generated method stub
		List<Groupmember> gmlist=selectmemGroups(userid);
		List<Groups> grouplist=new ArrayList<Groups>();
		for(Groupmember gm:gmlist) {
			grouplist.add(groupsMapper.selectByPrimaryKey(gm.getGroupid()));
		}
		return grouplist;
	}

	@Override
	public List<Integer> selectUser(int groupid) {
		// TODO Auto-generated method stub
		GroupmemberExample groupmemberExample=new GroupmemberExample();
		Criteria c1=groupmemberExample.createCriteria();
		c1.andGroupidEqualTo(groupid);
		List<Groupmember> gmemList=groupmemberMapper.selectByExample(groupmemberExample);
		List<Integer> useridList=new ArrayList<Integer>();
		for(Groupmember gm:gmemList) {
			useridList.add(gm.getMemberid());
		}
		return useridList;
	}

	@Override
	public List<User> selectUserEntity(int groupid) {
		// TODO Auto-generated method stub
		GroupmemberExample groupmemberExample=new GroupmemberExample();
		Criteria c1=groupmemberExample.createCriteria();
		c1.andGroupidEqualTo(groupid);
		List<Groupmember> gmemList=groupmemberMapper.selectByExample(groupmemberExample);
		List<User> useridList=new ArrayList<User>();
		for(Groupmember gm:gmemList) {
			User u=new User();
			u.setUserid(gm.getMemberid());
			useridList.add(userService.selectUserByPrimaryKey(u));
		}
		return useridList;
	}

	@Override
	public int deleteMember(int userid) {
		// TODO Auto-generated method stub
		GroupmemberExample groupmemberExample=new GroupmemberExample();
		Criteria c1=groupmemberExample.createCriteria();
		c1.andMemberidEqualTo(userid);
		int i=groupmemberMapper.deleteByExample(groupmemberExample);
		return i;
	}

	@Override
	public int ifContainInGroup(Groupmember gm) {
		// TODO Auto-generated method stub
		GroupmemberExample groupmemberExample=new GroupmemberExample();
		Criteria c1=groupmemberExample.createCriteria();
		c1.andGroupidEqualTo(gm.getGroupid());
		c1.andMemberidEqualTo(gm.getMemberid());
		List<Groupmember> i=groupmemberMapper.selectByExample(groupmemberExample);
		int j;
		if(i.size()==0) {//不在群
			j=1;
		}else {
			j=0;
		}
		return j;
	}

	@Override
	public void updateMemberid(Groupmember gm,int changeid) {
		// TODO Auto-generated method stub
		GroupmemberExample groupmemberExample=new GroupmemberExample();
		Criteria c1=groupmemberExample.createCriteria();
		c1.andGroupidEqualTo(gm.getGroupid());
		c1.andMemberidEqualTo(gm.getMemberid());
		
//		Criteria c2=groupmemberExample.createCriteria();
//		c2.andMemberidEqualTo(gm.getMemberid());
//		groupmemberExample;
		
		gm.setMemberid(changeid);
		groupmemberMapper.updateByExample(gm, groupmemberExample);
	}

	
}
