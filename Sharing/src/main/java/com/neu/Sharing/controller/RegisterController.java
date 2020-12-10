package com.neu.Sharing.controller;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.neu.Sharing.dao.UserDao;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.AccountHelper;
import com.neu.Sharing.service.UserService;

@Controller
public class RegisterController {
	
	@RequestMapping("/toregister")
	public  String toRegister() {
		return "register.html";
	}
	
	@RequestMapping("/register")
	public  String Register(String username,String password,String profession,String phone) throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setProfession(profession);
		u.setPhone(phone);
		
//		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
		
		AccountHelper AH = new AccountHelper();
		 //创建密钥对
		String[] tuple =AH.newAccount();
		u.setAccountaddress(tuple[2]);
		
		BigInteger key = new BigInteger(tuple[0],16);
	    ECKeyPair keyPair = ECKeyPair.create(key);
		String path = AH.newWalletFile(password,keyPair);
		u.setPath(path);
		UserService us = new UserService();
		us.addUser(u);
		
		return "login.html";
	}
	
	
	
}
