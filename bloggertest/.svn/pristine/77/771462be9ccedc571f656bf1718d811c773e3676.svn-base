package com.neuedu.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

public class PersistenceCookie {
	
	
	/**
	 * 时间：用户登录的时候点击记住密码
	 * 动作：本地持久化
	 * @param request
	 * @param response
	 * @param useraccount
	 * @param userpassword
	 */
	public static void refreshSession(HttpServletRequest request,HttpServletResponse response,String useraccount,String userpassword){	
		
			Cookie cookieaccount = new Cookie("useraccount", useraccount);
			Cookie cookiepassword = new Cookie("userpassword", userpassword);
			cookieaccount.setMaxAge(24*60*60*30);//三十天内免登录
			response.addCookie(cookieaccount);
			response.addCookie(cookiepassword);
	}
	
	/**
	 * 时间：过滤器
	 * 动作：自动登录
	 * @param request
	 * @param response
	 */
	public static boolean loginAutomatic(HttpServletRequest request){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		String userpassword=null;
		String useraccount=null;
		    String cookie=request.getHeader("cookie");
			Cookie [] cookies = request.getCookies();
			//超时或者过期获得为空.
			
			//System.out.println("打印cookies:"+cookies);
			if(cookie!=null) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("useraccount")) {
					useraccount=cookies[i].getValue();
				}else if(cookies[i].getName().equals("userpassword")) {
					userpassword=cookies[i].getValue();
				}
			}
			}
		if(useraccount==null||userpassword==null) {
			return false;
		}else {
			User logUser = new User();
			logUser.setUseraccount(useraccount);
			User currentUser = userServiceImpl.selectUserByAccount(logUser);
			if(MD5Utils.getSaltverifyMD5(userpassword, currentUser.getUserpassword())){
				request.getSession().setAttribute("currentUser", currentUser);
				return true;
			}else {
				return false;
			}
		}
	}
}
