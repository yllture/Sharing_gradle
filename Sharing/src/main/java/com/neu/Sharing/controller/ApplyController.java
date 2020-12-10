package com.neu.Sharing.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.ApplyService;

import com.neu.Sharing.service.Applydata;
import com.neu.Sharing.service.UserService;


@Controller
public class ApplyController {
	//去往申请数据页面
	@RequestMapping("/toapplydata")
	public String toApplydata(HttpServletRequest request,Model m) {
		User user =(User) request.getSession().getAttribute("currentUser");
		ApplyService as = new ApplyService();
		Apply a = new Apply();
		a.setOwner(user.getUsername());
		a.setState(1);
		List<Map<String, Object>> applylist = as.searchApply(a);
		m.addAttribute("applylist", applylist);
		return "applydata.html";
	}
	
	//发出申请
	@RequestMapping("/applydata")
	public @ResponseBody String Applydata(String owner,String introduction,HttpServletRequest request) throws Exception {
//		System.out.println(owner+introduction);
		User user =(User) request.getSession().getAttribute("currentUser");
		
		UserService us = new UserService();
		User u = new User();
		u.setUsername(owner);
		List<Map<String, Object>> maps=us.getUserByname(u);
		if(maps.size()==0) {
			return "0";
		}
		
		Apply a = new Apply();
		a.setOwner(owner);
		a.setIntroduction(introduction);
		a.setApplicant(user.getUsername());
		a.setTime(new Date());
		Applydata ad= new Applydata();
		ad.ApplyforData(a);
		
		return "1";
	}
	
	

}
