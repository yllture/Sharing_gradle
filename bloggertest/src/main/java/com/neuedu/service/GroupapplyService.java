package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Groupapply;
import com.neuedu.entity.Groups;
import com.neuedu.entity.User;

public interface GroupapplyService {

	int addGroupapply(Groupapply groupapply);
	List<Groupapply> selectGroupapplyByGroupid(int groupid);
	List<User> selectUserFromGroupapply(int groupid);
	List<Groups> selectGroupFromGroupapply(int groupid);
	int updateType(Groupapply groupapply);
}
