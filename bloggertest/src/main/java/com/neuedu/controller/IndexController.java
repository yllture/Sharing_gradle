package com.neuedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.entity.Bank;
import com.neuedu.service.BankService;
import com.neuedu.service.UserService;

@Controller
public class IndexController {

	@Autowired
	UserService userService;

	/**
	 * 跳转到首页界面
	 * @param m
	 * @return
	 */
	@RequestMapping("/toindex")
	public String toIndex(Model m) {

		return "index";
	}
	
	@RequestMapping("/index")
	public String toBank(Model m) {
		

		return "teacherBank/bankitem";
	}
}
