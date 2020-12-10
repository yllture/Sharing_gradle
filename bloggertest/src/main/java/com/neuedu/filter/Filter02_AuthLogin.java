//package com.neuedu.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.stereotype.Component;
//
//import com.neuedu.Utils.PersistenceCookie;
//import com.neuedu.entity.User;
//
//@Component
//@ServletComponentScan
//@WebFilter(filterName="filter02_AuthLogin",urlPatterns="/*")
//public class Filter02_AuthLogin implements Filter {
//
//    /**
//     * Default constructor. 
//     */
//    public Filter02_AuthLogin() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		
//		HttpServletRequest req = (HttpServletRequest)request;
//		HttpServletResponse res = (HttpServletResponse)response;
//		
//		String url = req.getServletPath();
//		
//		
//		if(url.contains("index")
//				||url.contains("login")
//				||url.contains("register")
//				||url.contains(".")){//静态资源
//			chain.doFilter(request, response);
//		}
//		
//		User u =(User)req.getSession().getAttribute("currentUser");
//		
//		if (null!=u && null!=u.getUserid()) {
//			chain.doFilter(request, response);
//		}else{
//			if(PersistenceCookie.loginAutomatic(req)) {
//				chain.doFilter(request, response);
//			}else {
//				res.sendRedirect("login");
//			}
//			
//		}
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
