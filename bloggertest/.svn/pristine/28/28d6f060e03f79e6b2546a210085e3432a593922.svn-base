package com.neuedu.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.Utils.AppPush;
import com.neuedu.Utils.MD5Utils;
import com.neuedu.Utils.PersistenceCookie;
import com.neuedu.Utils.PushtoSingle;
import com.neuedu.entity.Paper;
import com.neuedu.entity.User;
import com.neuedu.service.PaperService;
import com.neuedu.service.UserService;

@Controller
public class AppLoginController {
	@Autowired
	UserService userService;
	@Autowired
	PaperService paperService;
	
	@RequestMapping("/applogin")
	public  @ResponseBody Map applogin(HttpServletRequest request,
			@RequestParam(value="account",required=false) String number,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="cid",required=false) String cid,HttpServletResponse response) throws Exception {
//		System.out.println("come in");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setUserpassword(password);
		u.setC1(cid);
		User selectUser = null;
		//System.out.println(cid);
//		AppPush as=new AppPush();
//		as.apstart();
//		PushtoSingle ps=new PushtoSingle();
//		ps.psstart(cid);
		//电话登录
		if(number.length()==11) {
			u.setTel(number);
			selectUser = userService.selectUserByTel(u);		
		}
		//账号登录
		else if(number.length()==12) {
			u.setUseraccount(number);
			selectUser = userService.selectUserByAccount(u);	
		}	
		//无此用户
		if(selectUser==null) {
			map.put("code", "1000");
		}else if(MD5Utils.getSaltverifyMD5(password, selectUser.getUserpassword())) {//登录成功
			//更新用户cid
			userService.updateUser(u);
			map.put("code", "0000");
			map.put("userid", selectUser.getUserid());
			//用户目前登录类型，把用户登录的沈飞显示的类型页面
		}
			
		return map;
	}
	
	@RequestMapping("/apploginindex")
	public  @ResponseBody Map apploginindex(HttpServletRequest request,
			@RequestParam(value="username",required=false) Integer userid,
			@RequestParam(value="password",required=false) String password,HttpServletResponse response) {
//		System.out.println("come in");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setUserpassword(password);
		User selectUser = null;
			u.setUserid(userid);
			selectUser = userService.selectUserByPrimaryKey(u);	
		//无此用户
		if(selectUser==null) {
			map.put("code", "1000");
		}else if(MD5Utils.getSaltverifyMD5(password, selectUser.getUserpassword())) {//登录成功
			map.put("code", "0000");
		}
			
		return map;
	}
	
	@RequestMapping("/userInfo")
	public  @ResponseBody Map userInfo(HttpServletRequest request,
			@RequestParam(value="userid",required=false) Integer userid,HttpServletResponse response) {
//		System.out.println("come in");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setUserid(userid);
		User selectUser = null;
			selectUser = userService.selectUserByPrimaryKey(u);	
		//无此用户
		if(selectUser==null) {
			map.put("code", "1000");
		}else {//登录成功
			map.put("code", "0000");
			map.put("name", selectUser.getUsername());
			map.put("jifen",selectUser.getIntegral());
			map.put("account", selectUser.getUseraccount());
			map.put("icon", selectUser.getIcon());
		}
			
		return map;
	}
	
	@RequestMapping("/teacherInfor")
	public  @ResponseBody Map teacherInfor(HttpServletRequest request,
			@RequestParam(value="userid",required=false) Integer userid,HttpServletResponse response) {
//		System.out.println("come in");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setUserid(userid);
		User selectUser = null;
		selectUser = userService.selectUserByPrimaryKey(u);	
		List<Paper> papers=paperService.selectPaperPublic(selectUser);	
		System.out.println("------------"+papers.size()+"--"+userid);
		//无此用户
		if(selectUser==null) {
			map.put("code", "1000");
		}else {//登录成功
			map.put("code", "0000");
			map.put("papers", papers);
		}
			
		return map;
	}

	@RequestMapping("/studentpaperInfor")
	public  @ResponseBody Map studentpaperInfor(HttpServletRequest request,
			@RequestParam(value="userid",required=false) Integer userid,HttpServletResponse response) {
//		System.out.println("come in");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setUserid(userid);
		User selectUser = null;
		selectUser = userService.selectUserByPrimaryKey(u);	
		List<Paper> waitingpapers=paperService.selectAllPaperWaitingToFinish(selectUser);	
		List<Paper> donepapers=paperService.selectAllPaperFinished(selectUser);
		List<Paper> doingpapers=paperService.selectAllPaperWaitingToStart(selectUser);
//		System.out.println("------------"+papers.size()+"--"+userid);
		//无此用户
		if(selectUser==null) {
			map.put("code", "1000");
		}else {//登录成功
			map.put("code", "0000");
			map.put("waiting", waitingpapers);
			map.put("done", donepapers);
			map.put("doing", doingpapers);
		}
			
		return map;
	}
	

	@RequestMapping("/changeuserpassword")
	public  @ResponseBody Map changeuserpassword(HttpServletRequest request,
			@RequestParam(value="userid",required=false) Integer userid,
			@RequestParam(value="oldpassword",required=false) String oldpassword,
			@RequestParam(value="newpassword",required=false) String newpassword,HttpServletResponse response) {
//		System.out.println("come in");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setUserid(userid);
		User selectUser = null;
		selectUser = userService.selectUserByPrimaryKey(u);	
		if(MD5Utils.getSaltverifyMD5(oldpassword, selectUser.getUserpassword())) {
			MD5Utils.getSaltMD5(newpassword);
			selectUser.setUserpassword(newpassword);
			userService.updateUser(selectUser);
			map.put("code", "0000");
		}else {
			map.put("code", "1000");
		}
			
		return map;
	}
}
