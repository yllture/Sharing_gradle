package com.neu.Sharing.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;

import com.neu.Sharing.contract.Sharingdata;
import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.pre.*;


public class Authorizationdata {
	public void AuthorizationforData(Apply a ,String filename) throws Exception {
		
		 Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
		 
		 List<String> accounts = web3j.ethAccounts().send().getAccounts();
	     
		 ClientTransactionManager ctm = new ClientTransactionManager(web3j,accounts.get(0));
		 
		 //从数据库获取合约地址
		 ApplyService as =new ApplyService();
		 List<Map<String, Object>> list = as.selectByID(a);
		 
		 String contractAddress = (String) list.get(0).get("contractaddress"); 
		 Sharingdata sd = Sharingdata.load(contractAddress,web3j,ctm,Contract.GAS_PRICE,Contract.GAS_LIMIT);
	     String s = sd.getPublickey().send();
	     System.out.println(s);
	     //获取请求者的公钥
	     byte[] b =ProxyUtils.fromHex(s);
	     PublicKey publickeyA = PublicKey.fromBytes(b);
	     
	     KeyPair kpB = Proxy.generateKeyPair();

	     PrivateKey skB = kpB.getPrivateKey();
	     PublicKey pkB = kpB.getPublicKey();
	     //重加密密钥
	     ReEncryptionKey rkAB = Proxy.generateReEncryptionKey(skB,publickeyA);
	     String kab = ProxyUtils.toHex(rkAB.toBytes());
	     
	     //在这里先尝试转换一下，防止出现字节流转换错误
	     ReEncryptionKey kAB = ReEncryptionKey.fromBytes(ProxyUtils.fromHex(kab));
	     
	     System.out.println("kab:"+kab);
	     List<Object> cp = Proxy.encapsulate(pkB);
	     //密文C2
	     Capsule capsule = (Capsule) cp.get(0);
	     byte[] capsuleByte = capsule.toBytes();
	     String C2 =  ProxyUtils.toHex(capsuleByte);
	     System.out.println("C2:"+C2);
	     //对称加密密钥
	     Scalar symmetricKey = (Scalar) cp.get(1);
	    
	     //数据获取
	     String path = "D:\\EclipseCode\\Sharing\\data\\rawdata\\"+filename+".txt";
	     File f = new File(path);
//	     File f = new File("D:\\EclipseCode\\Sharing\\data\\rawdata\\data.txt");
	     String content = ReadFile(f);
	     System.out.println(content);
	     
	     //将数据用对称加密密钥进行加密的C1
	     String C1 =SymmetricEncoder.AESEncode(ProxyUtils.toHex(symmetricKey.toBytes()), content);
	     System.out.println("C1:"+C1);
	     File encfile = File.createTempFile("enc", ".txt",new File("D:\\EclipseCode\\Sharing\\data\\encdata"));
//	     
	     WriteFile(C1,encfile);
	     
//	     String e= SymmetricEncoder.AESDncode(ProxyUtils.toHex(symmetricKey.toBytes()), C1);
//	     System.out.println("原数据:"+e);
	     //将rkAB、C2、C1的存放地址写进区块链
	     sd.setC2(C2).send();
	     sd.setKAB(kab).send();
	     sd.setC1(encfile.getAbsolutePath()).send();
//	     String s1 = sd.getC2().send();
//	     String s2 = sd.getKAB().send();
//	     String s3 = sd.getC1().send();
//	     System.out.println("S1:"+s1);
//	     System.out.println("S2:"+s2);
//	     System.out.println("S3:"+s3);
	     
	     
	     //更改apply状态
	     Apply newapply = new Apply();
	     newapply.setApplyid(a.getApplyid());
	     newapply.setState(2);
	     as.updateState(newapply);
	     
	     
	     
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
