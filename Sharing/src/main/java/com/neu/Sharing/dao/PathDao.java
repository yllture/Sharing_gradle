package com.neu.Sharing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.neu.Sharing.entity.Path;

public class PathDao {
	
	private String sql;
	
	 //JdbcTemplate 数据库操作类对象，作为属性。通过xml配置注入
   private JdbcTemplate jdbcTemplate;
   public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }
   
   public void addPath(Path p) {
	   sql="INSERT INTO path (hash, gpFile,apFileS,apFileP,encFile) VALUES (?,?,?,?,?)";
//		 System.out.println(sql);
	   jdbcTemplate.update(sql,new Object[] {p.getHash(),p.getGbFile(),p.getApFileS(),p.getApFileP(),p.getEncFile()});
	   
   }
   
   public List<Map<String, Object>> getPath(Path p ){
	   sql = "SELECT * FROM path WHERE hash = ? ";
		List<Map<String, Object>> maps =jdbcTemplate.queryForList(sql,new Object[] {p.getHash()} );
		return maps;
   }
	
}
