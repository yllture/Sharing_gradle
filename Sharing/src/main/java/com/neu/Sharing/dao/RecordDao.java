package com.neu.Sharing.dao;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.neu.Sharing.entity.Record;

@Repository
public class RecordDao {


	
	private String sql;
	
	 //JdbcTemplate 数据库操作类对象，作为属性。通过xml配置注入
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	public void addRecord(Record r) {
//		System.out.println(username+hash);
		 sql="INSERT INTO recode (username, type,hash) VALUES (?,?,?)";
//		 System.out.println(sql);
		 jdbcTemplate.update(sql,new Object[] {r.getUsername(),r.getType(),r.getHash()});
		
		 
	}
	
	public List<Map<String, Object>>  getRecord(Record r) {
		sql = "SELECT * FROM recode WHERE username = ? and type=?";
		List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {r.getUsername(),r.getType()} );
		return maps;
	}
	

}
