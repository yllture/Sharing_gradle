package com.neu.Sharing.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.neu.Sharing.dao.ApplyDao;
import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.entity.Path;
import com.neu.Sharing.entity.User;

public class ApplyService {
	//启动IoC容器
	ApplicationContext ctx= JDBCBean.getAc();
	//获取IoC容器中JdbcTemplate实例
	JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
	
	public List<Map<String, Object>> selectByID(Apply  a) {
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps  =ad.selectByID(a);
		return maps;
	}
	
	public void addApplydata(Apply  a) {
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		ad.addApplydata(a);
	}
	
	public List<Map<String, Object>> searchApply(Apply a) {
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps  =ad.searchApply(a);
		return maps;
	}
	
	public List<Map<String, Object>> searchAuthorization(Apply a){
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps  =ad.searchAuthorization(a);
		
		return maps;
	}
	
	public List<Map<String, Object>> getUnauthorized(Apply a){
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps  =ad.getUnauthorized(a);
		
		return maps;
		
		
	}
	
	public List<Map<String, Object>> getAuthorized(Apply a){
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		List<Map<String, Object>> maps  =ad.getAuthorized(a);
		
		return maps;
	}
	public void updateState(Apply a) {
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		ad.updateState(a);
	}
	public void updateFilename(Apply a) {
		
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		ad.updateFilename(a);
	}
	public void deleteapply(Apply a) {
		ApplyDao ad = new ApplyDao();
		ad.setJdbcTemplate(jdbcTemplate);
		ad.deleteapply(a);
	}
}


