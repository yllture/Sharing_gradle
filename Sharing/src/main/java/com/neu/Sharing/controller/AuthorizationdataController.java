package com.neu.Sharing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.neu.Sharing.service.Authorizationdata;
import com.neu.Sharing.service.ProxyServer;
import com.neu.Sharing.service.RecodeOnChain;


@Controller
public class AuthorizationdataController {
	//去往授权数据页面
	@RequestMapping("/toauthorizationdata")
	public String toAuthorizationdata(HttpServletRequest request,Model m) {
		User user =(User) request.getSession().getAttribute("currentUser");
		ApplyService as = new ApplyService();
		Apply a = new Apply();
		a.setOwner(user.getUsername());
		a.setState(2);
		List<Map<String, Object>> authorizationdatalist =as.searchAuthorization(a);
		System.out.print(authorizationdatalist);
		m.addAttribute("authorizationlist", authorizationdatalist);
		return "authorizationdata.html";
	}
	//授权数据
	@RequestMapping("/authorizationdata")
	public @ResponseBody String Authorizationdata(String applyid,String file,HttpServletRequest request) throws Exception {
		User user =(User) request.getSession().getAttribute("currentUser");
		
		Apply a = new Apply();
		a.setApplyid(Integer.parseInt(applyid));
		Authorizationdata ad = new Authorizationdata();
		
		ad.AuthorizationforData(a, file);
		
		ProxyServer ps = new ProxyServer();
		ps.reEncrypt(a);
		ApplyService as = new ApplyService();
		a.setFilename(file);
		as.updateFilename(a);
		//授权数据上链
		String record = null;
		
		List<Map<String, Object>> list =as.selectByID(a);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		record = (String)list.get(0).get("owner") +"授权给"+list.get(0).get("applicant")+""+file+","+time;
		System.out.println(record);
		RecodeOnChain roc = new RecodeOnChain();
		roc.AuthorizeOrRevokeRecord(record, user, 1);
		
		return "1";
	}
	//拒绝
	@RequestMapping("/refuseapply")
	public @ResponseBody String  Refuseapply(String applyid) {
		Apply a = new Apply();
		a.setApplyid(Integer.parseInt(applyid));
		a.setState(0);
		ApplyService as = new ApplyService();
		as.updateState(a);
		
		
		return "1";
		
	}
	

}
