package com.neu.Sharing.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.Sharing.entity.Record;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.ViewRecord;

@Controller
public class AuthorizationrecordController {
	
	//去往授权记录页面
	@RequestMapping("/toauthorizationrecord")
	public String	toAuthorizationrecord(HttpServletRequest request,Model m) throws IOException, ParseException {
		User user =(User) request.getSession().getAttribute("currentUser");
		Record r = new Record();
		r.setUsername(user.getUsername());
		r.setType(1);
		ViewRecord vr =new  ViewRecord();
		
		List<Map<String, Object>> list = vr.ViewAllRecord(r, user);
		
		m.addAttribute("authorizationrecordlist", list);
		
		
		
		
		return "authorizationrecord.html";
		
	}
	
}
