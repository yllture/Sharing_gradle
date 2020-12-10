package com.neu.Sharing.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * JDBC连接IOC容器
 *防止出现JDBC连接过多
 */
public class JDBCBean {
	static private ApplicationContext ac = null;
	static {
	        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	 
    private JDBCBean() {
    }
	public static ApplicationContext getAc() {
        return ac;
    }
}