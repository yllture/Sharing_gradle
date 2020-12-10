package com.neu.Sharing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.neu.Sharing.service.AccountHelper;



public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
//		
		AccountHelper AH = new AccountHelper();
		 //创建密钥对
		ECKeyPair keyPair = Keys.createEcKeyPair();
		
		AH.newWalletFile("123",keyPair);
//		 
//		//查看节点账户
//	    AH.getNodeAccounts();
		
//		//启动IoC容器
//    	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//    	//获取IoC容器中JdbcTemplate实例
//    	JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
//		UserDao ud = new UserDao();
//		ud.setJdbcTemplate(jdbcTemplate);
//		User u = new User();
//		u.setAccountaddress("1");
//		u.setPassword("2");
//		u.setPath("3");
//		u.setPhone("4");
//		u.setProfession("5");
//		u.setUsername("6");
//		ud.addUser(u);
		
		
//		Applydata a= new Applydata();
//		a.ApplyforData();
		
//		
//		//启动IoC容器
//	    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//	    //获取IoC容器中JdbcTemplate实例
//	    JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
//	    
//	    ApplyDao ad = new ApplyDao();
//	    ad.setJdbcTemplate(jdbcTemplate);
//	    Apply a = new Apply();
//	    a.setApplicant("5");
//	    a.setOwner("55");
//	    a.setContractaddress("0x4555");
//	    a.setPrivatekey("99");
//	    a.setState(1);
//	    ad.addApplydata(a);
	}

}
