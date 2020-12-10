package com.neu.Sharing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.neu.Sharing.entity.Apply;



public class ApplyDao {
	
	
	private String sql;
	
	 //JdbcTemplate 数据库操作类对象，作为属性。通过xml配置注入
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Map<String, Object>> selectByID(Apply  a) {
		 sql = "SELECT * FROM apply WHERE applyid=? ";
		 List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {a.getApplyid()} );
		 return maps;
		
	}
	
	public void addApplydata(Apply  a) {
		 sql="INSERT INTO apply (applicant, owner,time,introduction,contractaddress,privatekey,state,filename) VALUES (?,?,?,?,?,?,?,?)";
//		 System.out.println(sql);
		 jdbcTemplate.update(sql,new Object[] {a.getApplicant(),a.getOwner(),a.getTime(),a.getIntroduction(),a.getContractaddress(),a.getPrivatekey(),a.getState(),a.getFilename()});
		   
	 }
	//查找未授权的申请
	public List<Map<String, Object>> searchApply(Apply a) {
		 sql = "SELECT * FROM apply WHERE owner = ? and state = 1 ";
		 List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {a.getOwner()} );
		return maps;
	}
	
	//查找已授权的申请
	public List<Map<String, Object>> searchAuthorization(Apply a){
		
		 sql = "SELECT * FROM apply WHERE owner = ? and state = 2 "; 
		 List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {a.getOwner()} );
		return maps;
		
	}
	
	//查找未授权的数据
	public List<Map<String, Object>> getUnauthorized(Apply a){
		sql = "SELECT * FROM apply WHERE applicant = ? and (state = 1 or state = 0) ORDER BY time  "; 
		 List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {a.getApplicant()} );
		return maps;
		
	}
	
	//查找已授权数据
	public List<Map<String, Object>> getAuthorized(Apply a){
		sql = "SELECT * FROM apply WHERE applicant = ? and state = 2 ORDER BY time "; 
		 List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {a.getApplicant()} );
		return maps;
		
	}
	public void updateState(Apply a) {
		sql = "UPDATE apply SET state = ? WHERE applyid = ?";
		jdbcTemplate.update(sql,new Object[] {a.getState(),a.getApplyid()});
		   
	}
	
	public void updateFilename(Apply a) {
		sql = "UPDATE apply SET filename = ? WHERE applyid = ?";
		jdbcTemplate.update(sql,new Object[] {a.getFilename(),a.getApplyid()});
	}
	
	public void deleteapply(Apply a ) {
		sql = "DELETE FROM apply WHERE applyid = ? ";
		jdbcTemplate.update(sql,new Object[] {a.getApplyid()});
		   
		
	}
}
