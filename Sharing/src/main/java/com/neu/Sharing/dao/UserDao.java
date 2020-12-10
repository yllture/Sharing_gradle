package com.neu.Sharing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.neu.Sharing.entity.User;


public class UserDao {
	private String sql;
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addUser(User u) {

		 sql="INSERT INTO user (username, password,path,accountaddress,profession,phone) VALUES (?,?,?,?,?,?)";

		 jdbcTemplate.update(sql,new Object[] {u.getUsername(),u.getPassword(),u.getPath(),u.getAccountaddress(),u.getProfession(),u.getPhone()});
		
	}
	//判断是否能够登录
	public List<Map<String, Object>> selectUser(User u) {
		sql = "SELECT * FROM user WHERE username = ? and password=?";
		
		List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {u.getUsername(),u.getPassword()} );
		return maps;
	}
	//
	public List<Map<String, Object>> getUserByname(User u) {
		sql = "SELECT * FROM user WHERE username = ? ";
		List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {u.getUsername()} );
		return maps;
	}
	
}

