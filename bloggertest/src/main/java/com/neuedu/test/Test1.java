package com.neuedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.Utils.MD5Utils;
import com.neuedu.dao.MyBatisSessionFactory;
import com.neuedu.dao.UserMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.User;
import com.neuedu.service.BankService;
import com.neuedu.service.Bank_fillService;

public  class Test1 {
	
//	SqlSession session = MyBatisSessionFactory.getSession();
//	@Test
//	public void test() {
//		UserMapper um = session.getMapper(UserMapper.class);
//		User u = um.selectByPrimaryKey(1);
//		System.out.println(u.getUsername());
//	}
	
	
	@Autowired
	BankService bankService;
	
	@Test
	public void test2(){
		
		MD5Utils m = new MD5Utils();
		String s = m.getSaltMD5("123456");
		System.out.println(s);
//		Bank_fill bf = new Bank_fill();
//		bf.setBankid(1);
//		bf.setqKnowledge("1");
//		int i = bankService.getFillnumByknowledge(bf);
//		
//		System.out.println(i+"!!!!!!!");
		
	
	}
	
	
	

}
