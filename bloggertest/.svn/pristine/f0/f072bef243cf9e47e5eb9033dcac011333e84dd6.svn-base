package com.neuedu.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.Utils.ImgUtils;
import com.neuedu.Utils.MD5Utils;
import com.neuedu.Utils.MailUrlUtils;
import com.neuedu.Utils.SendMsg;
import com.neuedu.entity.User;
import com.neuedu.entity.UserExample;
import com.neuedu.service.MailService;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

@Controller
public class ChangeUserController {

		@Autowired
		UserServiceImpl userServiceImpl;
		@Autowired
		MailService mailService;
		//--------------------------------------------------------去往各个页面的controller
		
		/**
		 * 去往用户信息设置的个人资料基本信息页面
		 * @param m
		 * @return
		 */
		@RequestMapping("/tochangeUserInfor")
		public String tochangeUserInfor(Model m) {

			return "userInfor/changeUserInfor";
		}
		
		/**
		 * 去往用户信息设置的个人资料基本信息页面
		 * @param m
		 * @return
		 */
		@RequestMapping("/tochangePassword")
		public String tochangePassword(Model m) {

			return "userInfor/changePassword";
		}
		
		/**
		 * 去往用户信息设置的个人资料基本信息页面
		 * @param m
		 * @return
		 */
		@RequestMapping("/tochangeCompany")
		public String toRegister(Model m) {

			return "userInfor/changeCompany";

		}
		//--------------------------------------------------------changeUserInfor页面的Controller
		/**
		 * 上传用户头像图片
		 * @param image
		 * @return
		 */
		@RequestMapping("/uploadUserAuatarImg")
		public @ResponseBody Map uploadUserAuatarImg(HttpServletRequest request,
			@RequestParam(value="image",required=false) String image) {

			HashMap<String,Object> map = new HashMap<String,Object>();
			User currentUser = (User) request.getSession().getAttribute("currentUser");		
			String imageType = "usersAuatar";//userAuatar用户公司logo

			String imagePath;
			try {
				imagePath = ImgUtils.saveImage(image, imageType);
			} catch (FileNotFoundException e) {
				map.put("code", "5000");//上传图片失败
				e.printStackTrace();
				return map;			
			}
			//更新目前session中用户的头像信息
			currentUser.setIcon(imagePath);
			//把图片信息更新到数据库用户表
			userServiceImpl.updateUser(currentUser);
			
			map.put("code", "0000");//请求成功
			return map;
		}
		
		/**
		 * 更改用户姓名
		 * @param image
		 * @return
		 */
		@RequestMapping("/changeUsername")
		public @ResponseBody Map changeUsername(HttpServletRequest request,
			@RequestParam(value="name",required=false) String username) {

			HashMap<String,Object> map = new HashMap<String,Object>();
//			User currentUser = (User) request.getSession().getAttribute("currentUser");
//			
//	
//			//更新目前session中用户的姓名
//			currentUser.setUsername(username);
//			
//			//把姓名更新到数据库用户表
//			userServiceImpl.updateUser(currentUser);
			User user =new User();
			user.setUserid(6);
			user.setUsername(username);
			System.out.println(username);
			userServiceImpl.updateUser(user);
			map.put("code", "0000");//请求成功
			return map;
		}
	
		
		/**
		 * 更改用户邮箱
		 * @param image
		 * @return
		 */
		@RequestMapping("/changeEamil")
		public @ResponseBody Map changeEamil(HttpServletRequest request,
			@RequestParam(value="email",required=false) String email) {

			HashMap<String,Object> map = new HashMap<String,Object>();
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			//更新目前session中用户的公司logo信息
			currentUser.setUsermail(email);
			//把图片信息更新到数据库用户表
			userServiceImpl.updateUser(currentUser);
			
			map.put("code", "0000");//请求成功
			return map;
		}
		//--------------------------------------------------------changeUserInfor页面的验证码验证
		
		/**
		 * 发送手机号短信验证码
		 * @param m
		 * @param request
		 * @param telnumber
		 * @return
		 */
		@RequestMapping("/changeSendMsg/{telnumber}")
		@ResponseBody
		public Map changeSendMsg(Model m, HttpServletRequest request, @PathVariable String telnumber) {
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
		 * 手机验证码验证
		 * @param request
		 * @param username
		 * @param tel
		 * @param userpassword
		 * @param verifyCode
		 * @return
		 */
		@RequestMapping("/changeTel")
		@ResponseBody
		public Map register(HttpServletRequest request, String tel, 
				String verifyCode) {
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

			//将目前的手机号验证码session清空
			request.getSession().removeAttribute("verifyCode");
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			
			//更新目前session中用户手机号
			currentUser.setTel(tel);
			//把手机号信息更新到数据库用户表
			userServiceImpl.updateUser(currentUser);
			
			map.put("code", "0000");//请求成功
			return map;
		}

	
		//--------------------------------------------------------changePassword页面的Controller
		/**
		 * 判断用户密码是否正确
		 * @param image
		 * @return
		 */
		@RequestMapping("/passwordVerify")
		public @ResponseBody Map passwordVerify(HttpServletRequest request,
			@RequestParam(value="oldPassword",required=false) String oldPassword) {

			HashMap<String,Object> map = new HashMap<String,Object>();
			User currentUser = (User) request.getSession().getAttribute("currentUser");
		
			if(MD5Utils.getSaltverifyMD5(oldPassword, currentUser.getUserpassword())) {
				
				map.put("code", "0000");//请求成功
			}else {
				map.put("code", "1001");//用户名密码错误
			}
					
			return map;
		}
		
		
		/**
		 * 修改用户密码
		 * @param image
		 * @return
		 */
		@RequestMapping("/changePassword")
		public @ResponseBody Map changePassword(HttpServletRequest request,
			@RequestParam(value="newPassword",required=false) String newPassword) {

			HashMap<String,Object> map = new HashMap<String,Object>();
			User currentUser = (User) request.getSession().getAttribute("currentUser");
		
			String newMdpassword=MD5Utils.getSaltMD5(newPassword);
			//更新目前session中用户的公司logo信息
			currentUser.setUserpassword(newMdpassword);
			//把图片信息更新到数据库用户表
			userServiceImpl.updateUser(currentUser);
			
			map.put("code", "0000");//请求成功
			return map;
		}
		
		//--------------------------------------------------------changeCompany页面的Controller
		
		/**
		 * 上传公司logo图片
		 * @param image
		 * @return
		 */
		@RequestMapping("/uploadCompanyImg")
		public @ResponseBody Map uploadCompanyImg(HttpServletRequest request,
			@RequestParam(value="image",required=false) String image) {

			HashMap<String,Object> map = new HashMap<String,Object>();
			User currentUser = (User) request.getSession().getAttribute("currentUser");
						
			String imageType = "userCompanyLogo";//userAuatar用户公司logo
			String imagePath;
			try {
				imagePath = ImgUtils.saveImage(image, imageType);
			} catch (FileNotFoundException e) {
				map.put("code", "5000");//上传图片失败
				e.printStackTrace();
				return map;			
			}
			//更新目前session中用户的公司logo信息
			currentUser.setUsercompanylogo(imagePath);
			//把公司logo信息更新到数据库用户表
			userServiceImpl.updateUser(currentUser);
			
			map.put("code", "0000");//请求成功
			return map;
		}
		/**
		 * 保存用户公司名称
		 * @param image
		 * @return
		 */
		@RequestMapping("/saveCompanyName")
		public @ResponseBody Map saveCompanyName(HttpServletRequest request,
			@RequestParam(value="companyName",required=false) String usercompany) {

			HashMap<String,Object> map = new HashMap<String,Object>();
			User currentUser = (User) request.getSession().getAttribute("currentUser");
						
			//更新目前session中用户的公司名称信息
			currentUser.setUsercompany(usercompany);
			//把公司名称信息更新到数据库用户表
			userServiceImpl.updateUser(currentUser);
			
			map.put("code", "0000");//请求成功
			return map;
		}
		
		/**
		 * 判断邮箱是否激活
		 * @param mail
		 * @return
		 */
		@RequestMapping("/sendMail")
		public @ResponseBody Map sendMail(HttpServletRequest request,
			@RequestParam(value="mail",required=false) String mail) {
			//System.out.println(mail);
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			HashMap<String,Object> map = new HashMap<String,Object>();
//			User currentUser=new User();
//			currentUser.setUserid(1);
//			currentUser.setUsername("zhangsanfeng");
//			currentUser.setUsermail(mail);
//			currentUser.setC3(0);
//			currentUser.setIntegral(1000);
//			currentUser.setOutundonenum(0);
//			currentUser.setDonenum(0);
//			currentUser.setInundomenum(0);;
//			currentUser.setFuturenum(0);
			//User currentUser = (User) request.getSession().getAttribute("currentUser");
			//System.out.println(currentUser.getUserid());
			//生成码、更新邮箱、更新状态为0  激活后再更新状态为1
			MailUrlUtils murl=new MailUrlUtils();
			String url=murl.generateActivateLink(currentUser.getUserid(),currentUser.getUsername());
			String subject="黑马测试邮箱验证";
			String content="点击以下链接一键绑定邮箱："+url;
			int i=mailService.sendHtmlMail(mail, subject, content);
			//System.out.println(url);
		
			if(i==1) {
				map.put("code", "0000");//请求成功
				userServiceImpl.updateUser(currentUser);
			}else {
				map.put("code", "1001");//用户名密码错误
			}
					
			return map;
		}
		
		@RequestMapping("/checkMail")
		public String checkMail(HttpServletRequest request,@RequestParam(value="id",required=false) int id,@RequestParam(value="checkCode",required=false) String checkCode) {
//			String checkcode=request.getParameter("checkCode");
//			String id=request.getParameter("id");
			User currentUser = (User) request.getSession().getAttribute("currentUser");
				if(currentUser.getUserid()==id) {
				User user=new User();
				user.setUserid(id);
				User u=userServiceImpl.selectUserByPrimaryKey(user);
				MailUrlUtils murl=new MailUrlUtils();
				if(murl.verifyCheckcode(id, u.getUsername(), checkCode)) {
					userServiceImpl.updateUser(currentUser);
				}
			}
			return "userInfor/changeUserInfor";
		}
}
