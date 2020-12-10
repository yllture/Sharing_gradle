package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.entity.Payrecord;
import com.neuedu.entity.*;
import com.neuedu.entity.User;
import com.neuedu.service.PayrecordService;
import com.neuedu.service.Shop_bankService;
import com.neuedu.service.Shop_paperService;
import com.neuedu.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	PayrecordService payrecordservice;
	
	@Autowired
	Shop_bankService shopbankservice;
	
	@Autowired
	Shop_paperService shoppaperservice;
	
	@RequestMapping("toteacheraccount")
	public String toteacgeraccount(HttpServletRequest request,Model model) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		User user=new User();
		user.setUserid(currentUser.getUserid());
		List<Payrecord> allBuyRecord = payrecordservice.getallBuyRecord(user);
		List<Payrecord> allSolderRecord = payrecordservice.getallSolderRecord(user);
		User reuser=userservice.selectUserByPrimaryKey(user);
		List<Shop_bank> banks=shopbankservice.selectByUser(user);
		List<Shop_paper> papers=shoppaperservice.selectByUser(user);
		model.addAttribute("currentuser",reuser);
		model.addAttribute("buyrecord",allBuyRecord);
		model.addAttribute("soldrecord",allSolderRecord);
		model.addAttribute("banks", banks);
		model.addAttribute("papers", papers);
		return "userInfor/teacheraccount";
		
	}
	
	
	@RequestMapping("tostudentaccount")
	public String touseraccount(HttpServletRequest request,Model model) {
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		User user=new User();
		user.setUserid(currentUser.getUserid());
		List<Payrecord> allBuyRecord = payrecordservice.getallBuyRecord(user);
		List<Payrecord> allSolderRecord = payrecordservice.getallSolderRecord(user);
		
		model.addAttribute("buyrecord",allBuyRecord);
		model.addAttribute("soldrecord",allSolderRecord);
		
		return "userInfor/studentaccount";
		
	}
	
	
}
