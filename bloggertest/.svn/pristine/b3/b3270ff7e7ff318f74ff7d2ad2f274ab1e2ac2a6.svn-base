package com.neuedu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.Utils.MD5Utils;
import com.neuedu.Utils.SendMsg;
import com.neuedu.entity.User;
import com.neuedu.entity.Usersession;
import com.neuedu.service.UserService;
import com.neuedu.service.UsersessionService;

@Controller
public class RegisterController {

	@Autowired
	UserService userService;
	@Autowired
	UsersessionService usersessionService;

	/**
	 * 跳转到注册界面
	 * @param m
	 * @return
	 */
	@RequestMapping("/toregister")
	public String toRegister(Model m) {

		return "register";
	}
	
	/**
	 * 用户手机号是否已被注册
	 * @param m
	 * @param request
	 * @param telnumber
	 * @return
	 */
	@RequestMapping("/registerChecktel/{telnumber}")
	@ResponseBody
	public Map registerChecktel(Model m, HttpServletRequest request, @PathVariable String telnumber) {
		//System.out.println("join");
		HashMap<String,Object> map = new HashMap<String,Object>();
		User u = new User();
		u.setTel(telnumber);
		User ru = userService.selectUserByTel(u);
		//将目前的手机号验证码session清空
		request.getSession().removeAttribute("verifyCode");
		//System.out.println(telnumber);
		//userService.selectUserByTel(u);
		//没有找到对应的手机话注册的用户
		if (ru==null) {
			//System.out.println("ok");
			map.put("code", "0000");
		} else if(ru!=null){
			//System.out.println("::"+ru.getTel());
			map.put("code", "1002");
		}
		return map;
	}

	/**
	 * 注册时短信验证码
	 * @param m
	 * @param request
	 * @param telnumber
	 * @return
	 */
	@RequestMapping("/registerSendMsg/{telnumber}")
	@ResponseBody
	public Map registerSendMsg(Model m, HttpServletRequest request, @PathVariable String telnumber) {
		//更新session当中的验证码数据
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		if (SendMsg.sendSms(request, telnumber)) {
			//System.out.println("ok");
			map.put("code", "0000");
			
		} else
			map.put("code", "2000");	
		return map;
	}

	/**
	 * 注册验证码验证
	 * @param request
	 * @param username
	 * @param tel
	 * @param userpassword
	 * @param verifyCode
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Map register(HttpServletRequest request, String username, String tel, String userpassword,
			String verifyCode,int usertype) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		JSONObject json = (JSONObject) request.getSession().getAttribute("verifyCode");
		//System.out.println(verifyCode);
		//System.out.println(json.getString("verifyCode"));

		// 验证码有效时间为5分钟
		if ((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5) {
			map.put("code", "2002");//验证码过期
			return map;
		}
		else if (!json.getString("verifyCode").equals(verifyCode)) {
			map.put("code", "2001");//验证码错误
			return map;
		}
		// 生成唯一的用户账号
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		String useraccount = machineId + String.format("%011d", hashCodeV);
		//System.out.println(useraccount);

	
		String mdpassword=MD5Utils.getSaltMD5(userpassword);
		// 将用户信息存入数据库

		User newUser = new User();
		newUser.setTel(tel);//电话
		newUser.setUseraccount(useraccount);//账号
		newUser.setUsername(username);//用户名
		newUser.setUserpassword(mdpassword);//密码
		newUser.setUsertype(usertype);//用户类型
		newUser.setIntegral(1000);//积分
		newUser.setIcon("img/defalutIcon.png");//默认头像
		newUser.setDonenum(0);
		newUser.setFuturenum(0);
		newUser.setInundomenum(0);
		newUser.setOutundonenum(0);
		
		userService.addUser(newUser);
		
		//将目前的手机号验证码session清空
		request.getSession().removeAttribute("verifyCode");
		
		//session记录用户信息进行登录存储
		User selectUser = userService.selectUserByAccount(newUser);
		request.getSession().setAttribute("currentUser", selectUser);
		Usersession usession = new Usersession();
		usession.setUserid(selectUser.getUserid());
		usession.setSessionid(request.getSession().getId());
		usersessionService.insertUsersession(usession);
		//返回给前端值
		String code = "0000";
		map.put("code", code);
		map.put("useraccount", useraccount);
//		JSONObject jsonObject = JSON.parseObject("");
//		jsonObject.put("code", code);
//		jsonObject.put("useraccount", useraccount);
		// 这里省略
		return map;
	}

}
