package com.neuedu.service;

import com.neuedu.entity.Usersession;

public interface UsersessionService {

	Usersession selectUsersessionByUserid(Usersession u);

	int insertUsersession(Usersession u);

	int updateUsersession(Usersession u);
	Usersession selectByUserid(Usersession u);
	
}
