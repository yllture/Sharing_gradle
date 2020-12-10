package com.neu.Sharing.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.Sharing.entity.Record;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.ViewRecord;

@Controller
public class UserecordController {

	//去往使用记录页面
	@RequestMapping("/touserecord")
	public String	toUserecord(HttpServletRequest request,Model m) throws IOException {
		User user =(User) request.getSession().getAttribute("currentUser");
		Record r = new Record();
		r.setUsername(user.getUsername());
		r.setType(2);
		ViewRecord vr =new  ViewRecord();
		
		List<Map<String, Object>> list = vr.ViewAllRecord(r, user);
		m.addAttribute("userecordlist", list);
		return "userecord.html";
		
	}
}
