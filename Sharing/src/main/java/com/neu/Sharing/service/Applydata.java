package com.neu.Sharing.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;

import com.neu.Sharing.contract.Sharingdata;
import com.neu.Sharing.dao.ApplyDao;
import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.pre.KeyPair;
import com.neu.Sharing.pre.PrivateKey;
import com.neu.Sharing.pre.Proxy;
import com.neu.Sharing.pre.ProxyUtils;
import com.neu.Sharing.pre.PublicKey;


public class Applydata {
	
	public void ApplyforData(Apply a) throws Exception {
		 Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
	     List<String> accounts = web3j.ethAccounts().send().getAccounts();
	     ClientTransactionManager ctm = new ClientTransactionManager(web3j,accounts.get(0));
		 KeyPair kp = Proxy.generateKeyPair();
		 PublicKey pk = kp.getPublicKey();
		 PrivateKey sk = kp.getPrivateKey();
	     Sharingdata sd = Sharingdata.deploy(web3j,ctm,Contract.GAS_PRICE,Contract.GAS_LIMIT).send();
	     String publickey = ProxyUtils.toHex(pk.toBytes());
	     System.out.println(publickey);
	     //
	     TransactionReceipt receipt = sd.setPublickey(publickey).send();
//	     String s = sd.getPublickey().send();
//	     System.out.println(s);
	     //获取合约的部署地址 
	     String contractAddress = sd.getContractAddress();
	     
	     System.out.println(contractAddress);
	     
	     //将私钥保存，保存在本地非服务器中
	     String privatekey = ProxyUtils.toHex(sk.toBytes());
	     File f = File.createTempFile("skey", ".txt",new File("D:\\EclipseCode\\Sharing\\privatekey"));
	     WriteFile(privatekey,f);
	     
	     //将合约地址,私钥地址存入数据库
	   //启动IoC容器
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	    //获取IoC容器中JdbcTemplate实例
	    JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
	    
	    ApplyDao ad = new ApplyDao();
	    ad.setJdbcTemplate(jdbcTemplate);
	    
	    
	    a.setContractaddress(contractAddress);
	    a.setPrivatekey(f.getAbsolutePath());
	    a.setState(1);
	    ad.addApplydata(a);
	     
	}
	
	 public static  void WriteFile(String str,File fileOut){ 	
	    	try {
				
	    		
	            FileOutputStream fos=null;
	            fos=new FileOutputStream(fileOut,false);

	            BufferedWriter bufferedWriter=null;
	            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
	            char[] arry = str.toCharArray();
	            
	            for (char tempchar: arry){
	                bufferedWriter.write(tempchar);
	            }

	            bufferedWriter.flush();
	            bufferedWriter.close();

	            fos.close();

//				System.out.println("finish");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }

}
