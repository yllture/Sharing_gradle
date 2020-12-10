package com.neu.Sharing.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;

import com.neu.Sharing.contract.Sharingdata;
import com.neu.Sharing.entity.Apply;

public class Revokedata {
	public void Revokedata(Apply a) throws Exception {
		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
		 
		List<String> accounts = web3j.ethAccounts().send().getAccounts();
	     
		ClientTransactionManager ctm = new ClientTransactionManager(web3j,accounts.get(0));
		 
		 //从数据库获取合约地址
		 ApplyService as =new ApplyService();
		 List<Map<String, Object>> list = as.selectByID(a);
		 
		 String contractAddress = (String) list.get(0).get("contractaddress"); 
		 Sharingdata sd = Sharingdata.load(contractAddress,web3j,ctm,Contract.GAS_PRICE,Contract.GAS_LIMIT);
		 String path =sd.getC1().send(); 
		 File file = new File(path);
		 if (file.isFile() && file.exists()) {
		 file.delete();
		 }
		 
		 sd.setC1("null").send();
		 sd.setC2("null").send();
		 sd.setC3("null").send();
		 sd.setPublickey("null").send();
	     sd.setKAB("null").send();
	     //更改apply状态
	     Apply newapply = new Apply();
	     newapply.setApplyid(a.getApplyid());
	     newapply.setState(3);
	     as.updateState(newapply);
	}
	

}
