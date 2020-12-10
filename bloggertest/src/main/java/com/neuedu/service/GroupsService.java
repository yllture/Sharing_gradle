package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Groups;
import com.neuedu.entity.User;

public interface GroupsService {

	int addGroups(Groups group);
	List<Groups> selectOwnGroups(int owner);
	Groups selectGroupsByCode(String code);
	Groups selectGroupsByGroupid(int groupid);
	User selectOwnerFromGroup(int groupid);
	//List<User> selectMemFromGroup(int groupid);
	int updateGroups(Groups group);
//	int updateGroupsowner(int ownerid);
	int deleteGroups(int groupid);
	int addMemberByExcel(List<Object> list,int groupid);
	int updateGroupsowner(Groups g, int ownerid);
}
