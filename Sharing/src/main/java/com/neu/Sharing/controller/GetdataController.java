package com.neu.Sharing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.ApplyService;
import com.neu.Sharing.service.Getdata;
import com.neu.Sharing.service.RecodeOnChain;
import com.neu.Sharing.service.UserService;

@Controller
public class GetdataController {
	
	//去往获取数据controller
	@RequestMapping("/togetdata")
	public String toGetdata(HttpServletRequest request,Model m) {
		User user =(User) request.getSession().getAttribute("currentUser");
		ApplyService as = new ApplyService();
		Apply a = new Apply();
		a.setApplicant(user.getUsername());
		List<Map<String, Object>> authorizedlist = as.getAuthorized(a);
		List<Map<String, Object>> unauthorizedlist = as.getUnauthorized(a);
		m.addAttribute("authorizedlist", authorizedlist);
		m.addAttribute("unauthorizedlist", unauthorizedlist);
		
		return "getdata.html";
	}
	@RequestMapping("/getdata")
	public @ResponseBody String Getdata(String applyid ,String filename,HttpServletRequest request) throws Exception {
		User user =(User) request.getSession().getAttribute("currentUser");
		
		Apply a = new Apply();
		a.setApplyid(Integer.parseInt(applyid));
		Getdata gd = new Getdata();
		String data =gd.getData(a);
		
		//使用记录上链
		String record = null;
		ApplyService as = new ApplyService();
		List<Map<String, Object>> list =as.selectByID(a);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		record = (String) list.get(0).get("applicant")+"使用了"+list.get(0).get("owner")+"授权的"+filename+","+time;
		System.out.println(record);
		UserService us = new UserService();
		User owner = new User();
		owner.setUsername((String)list.get(0).get("owner"));
		List<Map<String, Object>> list1 =us.getUserByname(owner);
		owner.setProfession((String)list1.get(0).get("profession"));
		owner.setAccountaddress((String)list1.get(0).get("accountaddress"));
		RecodeOnChain roc = new RecodeOnChain();
//		System.out.println(owner.getAccountaddress()+owner.getUsername()+owner.getProfession());
//		System.out.println(user.getAccountaddress()+user.getUsername()+user.getProfession());
		
		roc.UseRecord(record, user, owner);
		return data;
	}
	@RequestMapping("/deleterefuse")
	public String DeleteRefuse(@RequestParam String applyid) {
		
		Apply a = new Apply();
		a.setApplyid(Integer.parseInt(applyid));
		ApplyService as = new ApplyService();
		as.deleteapply(a);
		
		return "redirect:/togetdata";
	}
	
	
	
	

}
