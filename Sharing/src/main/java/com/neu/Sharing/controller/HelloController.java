package com.neu.Sharing.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.http.HttpServletRequest;

import com.neu.Sharing.entity.Record;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.RecodeOnChain;
import com.neu.Sharing.service.ViewRecord;


@Controller
public class HelloController {
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	@RequestMapping("/hello")
	public  String hello() throws Exception {

		
      Record r= new Record();
      r.setUsername("wangwu");//根据前端登录的用户进更改
      r.setType(1);
      User u = new User();
      u.setAccountaddress("0xeff2E5C49d66055e1b1D3f896bF7d7a172e246Fe");
      u.setProfession("医生");
	  ViewRecord v = new ViewRecord();
	  v.ViewAllRecord(r,u);
		
		return "hello";
	}
	 



	 @RequestMapping("/getUser")
	    public @ResponseBody String getUser() throws Exception{
//	        String sql="select * from recode";
//	        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		 User u = new User();
		 u.setUsername("张三");
	      u.setAccountaddress("0xeff2E5C49d66055e1b1D3f896bF7d7a172e246Fe");
	      u.setProfession("医生");
	      User u2 = new User();
	      u2.setUsername("李四");
	      u2.setAccountaddress("0x83cB1aD0ecBf8da260A0Eb72f448EBCD9043ee38");
	      u2.setProfession("患者");
	        RecodeOnChain r = new RecodeOnChain();
	        
	        //type 1.授权 3.撤销
	        String str = r.AuthorizeOrRevokeRecord("张三授权给李四，2020.3.24，医院就诊",u,1);
	        String str2 =r.UseRecord("张三使用李四记录，2020.3.24，医院就诊", u, u2);
	        return str2;
	    }
	 
	
	
}
 