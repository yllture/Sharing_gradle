package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.GroupmemberMapper;
import com.neuedu.dao.GroupsMapper;
import com.neuedu.entity.Groupmember;
import com.neuedu.entity.Groups;
import com.neuedu.entity.GroupsExample;
import com.neuedu.entity.User;
import com.neuedu.entity.GroupsExample.Criteria;
import com.neuedu.excel.MemberDTO;
import com.neuedu.service.GroupmemberService;
import com.neuedu.service.GroupsService;
import com.neuedu.service.UserService;
@Service
public class GroupsServicImpl implements GroupsService{

	
	@Autowired
	GroupsMapper groupsMapper;
	
//	@Autowired
//	GroupsExample groupsExample;
	
	@Autowired
	UserService userService;
	
	@Autowired
	GroupmemberService groupmemberService;
	
	@Autowired
	GroupmemberMapper groupmemberMapper;
		
	@Override
	public int addGroups(Groups group) {
		// TODO Auto-generated method stub
		//System.out.print(group.getIcon());
		int i =groupsMapper.insert(group);
		//System.out.print(i);
		return i;
	}

	@Override
	public List<Groups> selectOwnGroups(int ower) {
		// TODO Auto-generated method stub	
		GroupsExample groupsExample=new GroupsExample();
		Criteria c1=groupsExample.createCriteria();
		c1.andOwnerEqualTo(ower);
		List<Groups> selectAllGroups = groupsMapper.selectByExample(groupsExample);
		return selectAllGroups;
	}

	@Override
	public Groups selectGroupsByCode(String code) {
		// TODO Auto-generated method stub
		GroupsExample groupsExample=new GroupsExample();
		//System.out.println(code+"code");
		//code="kk";
		//System.out.println(code+"code2");
		Criteria c1=groupsExample.createCriteria();
		c1.andC1EqualTo(code);
//		c1.andGroupnameEqualTo(code);
		List<Groups> list = groupsMapper.selectByExample(groupsExample);
		/*
		 * for(Groups g:list) { System.out.println(g.getGroupid()+"id"); }
		 */
		return list.get(0);
		
	}

	@Override
	public Groups selectGroupsByGroupid(int groupid) {
		// TODO Auto-generated method stub
		Groups group=groupsMapper.selectByPrimaryKey(groupid);
		return group;
	}

	@Override
	public int updateGroups(Groups group) {
		// TODO Auto-generated method stub
		int i=groupsMapper.updateByPrimaryKeySelective(group);
		return i;
	}

	@Override
	public int updateGroupsowner(Groups g,int ownerid) {
		// TODO Auto-generated method stub
		//Groups group=new Groups();
		//g.setOwner(ownerid);
		
		Groupmember gm=new Groupmember();
		gm.setGroupid(g.getGroupid());
		gm.setMemberid(ownerid);
		//System.out.println(g.getOwner());
		Groupmember contain=groupmemberMapper.selectByPrimaryKey(gm);
		System.out.println(contain.getGroupid()+"------------------");
		
		groupmemberService.updateMemberid(gm, ownerid);
		g.setOwner(ownerid);
		int i=groupsMapper.updateByPrimaryKey(g);
//		GroupsExample groupsExample=new GroupsExample();
//		Criteria c1=groupsExample.createCriteria();
//		
////		c1.andGroupnameEqualTo(code);
////		System.out.println(g.getOwner());
////		System.out.println(ownerid);
//		g.setOwner(ownerid);
//		int i= groupsMapper.updateByExampleSelective(g,groupsExample);
		return i;
	}

	@Override
	public int deleteGroups(int groupid) {
		// TODO Auto-generated method stub
		int i=groupsMapper.deleteByPrimaryKey(groupid);
		return i;
	}

	@Override
	public int addMemberByExcel(List<Object> list,int groupid) {
		// TODO Auto-generated method stub
		for(int i =0 ;i<list.size();i++) {
			MemberDTO m = (MemberDTO) list.get(i);
			User u = new User();
			u.setUseraccount(m.getAccount());
			u = userService.selectUserByAccount(u);
			if(u.getUserid()!=null) {
				Groupmember gm=new Groupmember();
				gm.setGroupid(groupid);
				gm.setMemberid(u.getUserid());
				groupmemberService.addMember(gm);
			}
		}
		
		return 1;
	}

	@Override
	public User selectOwnerFromGroup(int groupid) {
		// TODO Auto-generated method stub
		User user=new User();
		Groups group=groupsMapper.selectByPrimaryKey(groupid);
		user.setUserid(group.getOwner());
		User u=userService.selectUserByPrimaryKey(user);
		return u;
	}

//	@Override
//	public int updateGroupsowner(int ownerid) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	/*
	 * @Override public List<User> selectMemFromGroup(int groupid) { // TODO
	 * Auto-generated method stub Groups
	 * group=groupsMapper.selectByPrimaryKey(groupid); List<User>
	 * userlist=groupmemberService. return null; }
	 */
}
