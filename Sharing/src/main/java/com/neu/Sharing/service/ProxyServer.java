package com.neu.Sharing.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;

import com.neu.Sharing.contract.Sharingdata;
import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.pre.*;


public class ProxyServer {
	public void reEncrypt(Apply a) throws Exception {
		
		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
		 
		 List<String> accounts = web3j.ethAccounts().send().getAccounts();
	     
		 ClientTransactionManager ctm = new ClientTransactionManager(web3j,accounts.get(0));
		 //需要获取合约地址
		 ApplyService as =new ApplyService();
		 List<Map<String, Object>> list = as.selectByID(a);
		 
		 String contractAddress = (String) list.get(0).get("contractaddress"); 
		 
//		 String contractAddress = "0x15512cbc3db79f457fe6c0b96a27ca755e78ae30"; 
		 
		 Sharingdata sd = Sharingdata.load(contractAddress,web3j,ctm,Contract.GAS_PRICE,Contract.GAS_LIMIT);
	     
		 String c2 = sd.getC2().send();
//		 System.out.println(c2);
		 Capsule C2 =  Capsule.fromBytes(ProxyUtils.fromHex(c2));
		 
		 String kab = sd.getKAB().send();
		 ReEncryptionKey kAB = ReEncryptionKey.fromBytes(ProxyUtils.fromHex(kab));
//		 System.out.println(ProxyUtils.toHex(kAB.toBytes()));
		 
		 //将C3写入区块链
		 Capsule C3 = Proxy.reEncryptCapsule(C2, kAB);
		 String c3 = ProxyUtils.toHex(C3.toBytes());
		 System.out.println(c3);
		 sd.setC3(c3).send();
		 
//		 String s1 = sd.getC3().send();
//		 System.out.println(s1);
		 
	}

	

}
