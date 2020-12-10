package com.neuedu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.neuedu.entity.User;
import com.neuedu.entity.Usersession;
import com.neuedu.service.UsersessionService;

public class SessionIdInterceptor implements HandlerInterceptor{
    @Autowired
    UsersessionService usersessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
    	
        String sessionId  =request.getSession().getId();
        User user = (User) request.getSession().getAttribute("currentUser");

        
        if(user==null) {
        	 response.sendRedirect(request.getContextPath()+"/tologin");
             return false;
        }
        
        Usersession usession = new Usersession();
        usession.setUserid(user.getUserid());
//        System.out.println(usession.getUserid()+"********");
//        String json = JSON.toJSONString(usession);
//        System.out.println(json);
        //UsersessionService usersessionService = new UsersessionServiceImpl();
        Usersession selectsession=usersessionService.selectUsersessionByUserid(usession);
//        System.out.println(request.getRequestURI());
        System.out.println(request.getContextPath());
        if(selectsession==null) {
        	return false;
        }
        if(sessionId.equals(selectsession.getSessionid())){
            return true;
        }else{
            response.sendRedirect(request.getContextPath()+"/tologin");
            return false;
        }
    
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}