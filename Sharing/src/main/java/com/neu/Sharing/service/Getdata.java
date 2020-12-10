package com.neu.Sharing.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;

import com.neu.Sharing.contract.Sharingdata;
import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.pre.*;


public class Getdata {
	public String getData(Apply a) throws Exception {
		
		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
		 
		 List<String> accounts = web3j.ethAccounts().send().getAccounts();
	     
		 ClientTransactionManager ctm = new ClientTransactionManager(web3j,accounts.get(0));
		 //需要获取合约地址
		 ApplyService as =new ApplyService();
		 List<Map<String, Object>> list = as.selectByID(a);
		 
		 String contractAddress = (String) list.get(0).get("contractaddress"); 
//		 String contractAddress = "0x15512cbc3db79f457fe6c0b96a27ca755e78ae30"; 
		 
		 Sharingdata sd = Sharingdata.load(contractAddress,web3j,ctm,Contract.GAS_PRICE,Contract.GAS_LIMIT);
	     String c3 = sd.getC3().send();
	     Capsule C3 =Capsule.fromBytes(ProxyUtils.fromHex(c3));
	     System.out.println(c3);
	     //获取本地的私钥
	     //从数据库中获取私钥地址
	     String path = (String) list.get(0).get("privatekey");
	     
//	     String path = "D:\\EclipseCode\\Sharing\\privatekey\\skey3364952076612053814.txt";
	     String sk = ReadFile(new File(path));
	     System.out.println(sk);
	     PrivateKey privatekey = PrivateKey.fromBytes(ProxyUtils.fromHex(sk));
	     //私钥在变成字节流时，只保留了scalar，publickey需要自己生成
	     PublicKey pk = privatekey.generatePublicKey();
	     privatekey.setPublicKey(pk);
//	     String privatey = ProxyUtils.toHex(privatekey.toBytes());
//	     privatekey.getPublicKey().getValue();
//	     System.out.println("哈哈"+privatey);
	     //解密得到对称密钥
	     Scalar decapsulatedReSymmetricKey = Proxy.decapsulate(C3, privatekey);
	     //获取密文C1
	     String c1path = sd.getC1().send();
	     String c1= ReadFile(new File(c1path));
	
	     String e= SymmetricEncoder.AESDncode(ProxyUtils.toHex(decapsulatedReSymmetricKey.toBytes()), c1);
	     System.out.println("原数据:"+e);
	     
	     return e;
	     
	}
	
	 public static String ReadFile(File path) {
	    	FileInputStream fis=null;
	        BufferedReader bufferedReader=null;
	        String str="";
	        try{
	            fis=new FileInputStream(path);
	            bufferedReader = new BufferedReader(new InputStreamReader(fis, "utf-8"));
	            int tempchar; 
	            while ((tempchar = bufferedReader.read()) != -1){
	                str+= (char)tempchar;
	            }
	        }catch (FileNotFoundException e){
	            e.printStackTrace();
	        }catch (IOException e){
	            e.printStackTrace();
	        }finally {
	            try{
	                bufferedReader.close();
	                fis.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }
//	        System.out.println(str);
	    	
	    	
	    	return str;
	    	
	    }

}
