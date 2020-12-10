package com.neu.Sharing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.UserService;






@Controller
public class LoginController {
	
	@RequestMapping("/tologin")
	public String toLogin() {
		return "login.html";
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public  Map Login(String username,String password,HttpServletRequest request) {
		HashMap<String,Object> map = new HashMap<String,Object>();
//		System.out.println(username+password);
		User u = new User();
		
		u.setUsername(username);
		u.setPassword(password);
		UserService us = new UserService();
		List<Map<String, Object>> maps = us.logintosearch(u);
//		System.out.print(maps.size()+maps.get(0).get("username").toString());
		if(maps.size()==0) {
			map.put("code", "0");
			return map;
		} 
		map.put("code", "1");
		
		u.setAccountaddress((String)maps.get(0).get("accountaddress"));
		u.setProfession((String)maps.get(0).get("profession"));
		//用户信息session存储
		request.getSession().setAttribute("currentUser", u);

		
		return map;
	}
	
	
	
	

}
