package com.neu.Sharing.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


import com.neu.Sharing.dao.UserDao;
import com.neu.Sharing.entity.User;

public class UserService {
	//启动IoC容器
	ApplicationContext ctx=JDBCBean.getAc();
	//获取IoC容器中JdbcTemplate实例
	JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
			
	public void addUser(User u) {
		
		UserDao ud = new UserDao();
		ud.setJdbcTemplate(jdbcTemplate);
		
		ud.addUser(u);

	}
	public List<Map<String, Object>> logintosearch(User u) {
		UserDao ud = new UserDao();
		ud.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps = ud.selectUser(u);
		return maps;
	}
	
	public  List<Map<String, Object>> getUserByname(User u) {
		
		UserDao ud = new UserDao();
		ud.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps = ud.getUserByname(u);
		return maps;
	}
	
	
	
}
