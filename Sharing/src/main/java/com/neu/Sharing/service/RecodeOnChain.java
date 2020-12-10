package com.neu.Sharing.service;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import com.neu.Sharing.cpabe.CPABETool;
import com.neu.Sharing.dao.PathDao;
import com.neu.Sharing.dao.RecordDao;
import com.neu.Sharing.entity.Path;
import com.neu.Sharing.entity.Record;
import com.neu.Sharing.entity.User;

import rx.Subscription;

public class RecodeOnChain {
	private static File gpFile ;
    private static File resFile;
    private File apFileS;
    private File apFileP;
    private File encFile;
    private String policy;
    
    //授权/撤销记录上链
    public String AuthorizeOrRevokeRecord(String record,User u,int type) throws Exception {
    	
    	String a = u.getAccountaddress();
    	String b = u.getUsername();
    	policy = a+" and "+b;

    	//加密信息需要存储到文件中
    	//文件目录
        resFile = new File("D:\\EclipseCode\\Sharing\\resFile.txt");
    	WriteFile(record,resFile.getAbsolutePath());
        
    	apFileS = File.createTempFile("authority", "sk",new File("D:\\EclipseCode\\Sharing\\TempFile\\apFileS"));
//        apFileS.deleteOnExit();

        apFileP = File.createTempFile("authority", "pk",new File("D:\\EclipseCode\\Sharing\\TempFile\\apFileP"));
//        apFileP.deleteOnExit();
        
    	gpFile = File.createTempFile("dcpabe", "gp",new File("D:\\EclipseCode\\Sharing\\TempFile\\gpFile"));
        String[] args = {"gsetup", gpFile.getAbsolutePath()};
        CPABETool.main(args);//全局初始化
    	
        //加密后文件目录
        encFile = File.createTempFile("res", "enc",new File("D:\\EclipseCode\\Sharing\\TempFile\\encFile"));
        String[] asetup = {"asetup", "authority1", gpFile.getAbsolutePath(), apFileS.getAbsolutePath(), apFileP.getAbsolutePath(), a, b};
    	CPABETool.main(asetup);//初始化
    	
    	String[] enc = {"enc", resFile.getAbsolutePath(), policy, encFile.getAbsolutePath(), gpFile.getAbsolutePath(), apFileP.getAbsolutePath()};
        CPABETool.main(enc);//加密
        String str = ReadFile(encFile);
        
         
        Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
        List<String> accounts = web3j.ethAccounts().send().getAccounts();
        String from = accounts.get(0); 
        String to = accounts.get(0); 

        BigInteger gasLimit = BigInteger.valueOf(6000000); 
        BigInteger gasPrice = Convert.toWei("2000",Convert.Unit.GWEI).toBigInteger();
        BigInteger value = BigInteger.valueOf(10000L); //wei 
        BigInteger nonce = null; 
        String data = strTo16(string2Unicode(str)); 
//        System.out.println("转化成16进制数"+data);
      
//        System.out.println(unicode2String(hexStringToString(data)));
        
        Transaction tx = new Transaction(from,nonce,gasPrice,gasLimit,to,value,data); 
      
        String txHash = web3j.ethSendTransaction(tx).send().getTransactionHash();
        
        System.out.println("交易的hash值ֵ:"+txHash);
    	//启动IoC容器
    	ApplicationContext ctx= JDBCBean.getAc();
    	//获取IoC容器中JdbcTemplate实例
    	JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

      
        //将交易hash值存入数据库
        RecordDao rd = new RecordDao();
        rd.setJdbcTemplate(jdbcTemplate);

        Record r = new Record();
        r.setUsername(u.getUsername());
        r.setHash(txHash);
        r.setType(type);
        rd.addRecord(r);
        
        //将文件路径存入数据库
        
        PathDao pd = new PathDao();
        pd.setJdbcTemplate(jdbcTemplate);
        Path p = new Path();
        p.setHash(txHash);
        p.setGbFile( gpFile.getAbsolutePath());
        p.setApFileP( apFileP.getAbsolutePath());
        p.setApFileS(apFileS.getAbsolutePath());
        p.setEncFile( encFile.getAbsolutePath());
        pd.addPath(p);
        
        return txHash;
        
    }
	//使用记录上链 
    public String UseRecord(String record,User u1,User u2) throws Exception {
    	String a = u1.getAccountaddress();
    	String b = u1.getUsername();
    	String c = u2.getAccountaddress();
    	String d = u2.getUsername();
    	policy = "("+a+" and "+b+") or ("+c+" and "+d+")";
//    	policy = "and a or d and b c";//需要根据实际情况更改
    	
//    	String record= "zhasjajgj";//从前端获得数据
    	//加密信息需要存储到文件中
    	//文件目录
        resFile = new File("D:\\EclipseCode\\Sharing\\resFile.txt");
    	WriteFile(record,resFile.getAbsolutePath());
        
    	apFileS = File.createTempFile("authority", "sk",new File("D:\\EclipseCode\\Sharing\\TempFile\\apFileS"));
//        apFileS.deleteOnExit();

        apFileP = File.createTempFile("authority", "pk",new File("D:\\EclipseCode\\Sharing\\TempFile\\apFileP"));
//        apFileP.deleteOnExit();
        
    	gpFile = File.createTempFile("dcpabe", "gp",new File("D:\\EclipseCode\\Sharing\\TempFile\\gpFile"));
        String[] args = {"gsetup", gpFile.getAbsolutePath()};
        CPABETool.main(args);//全局初始化
    	
        //加密后文件目录
        encFile = File.createTempFile("res", "enc",new File("D:\\EclipseCode\\Sharing\\TempFile\\encFile"));
        String[] asetup = {"asetup", "authority1", gpFile.getAbsolutePath(), apFileS.getAbsolutePath(), apFileP.getAbsolutePath(), a, b,c,d};
    	CPABETool.main(asetup);//初始化
    	
    	String[] enc = {"enc", resFile.getAbsolutePath(), policy, encFile.getAbsolutePath(), gpFile.getAbsolutePath(), apFileP.getAbsolutePath()};
        CPABETool.main(enc);//加密
        String str = ReadFile(encFile);
        
         
        Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
        List<String> accounts = web3j.ethAccounts().send().getAccounts();
        String from = accounts.get(0); 
        String to = accounts.get(1); 

        BigInteger gasLimit = BigInteger.valueOf(6000000); 
        BigInteger gasPrice = Convert.toWei("2000",Convert.Unit.GWEI).toBigInteger();
        BigInteger value = BigInteger.valueOf(10000L); //wei 
        BigInteger nonce = null; 
        String data = strTo16(string2Unicode(str)); 

        Transaction tx = new Transaction(from,nonce,gasPrice,gasLimit,to,value,data); 
      
        String txHash = web3j.ethSendTransaction(tx).send().getTransactionHash();
        
        System.out.println("交易的hash值ֵ:"+txHash);
    	//启动IoC容器
    	ApplicationContext ctx=JDBCBean.getAc();
    	//获取IoC容器中JdbcTemplate实例
    	JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

      
        //将交易hash值存入数据库
        RecordDao rd = new RecordDao();
        rd.setJdbcTemplate(jdbcTemplate);

        Record r = new Record();
        r.setUsername(u1.getUsername());
        r.setHash(txHash);
        r.setType(2);
        rd.addRecord(r);
        
        r.setUsername(u2.getUsername());
        rd.addRecord(r);
        
        //将文件路径存入数据库
        
        PathDao pd = new PathDao();
        pd.setJdbcTemplate(jdbcTemplate);
        Path p = new Path();
        p.setHash(txHash);
        p.setGbFile( gpFile.getAbsolutePath());
        p.setApFileP( apFileP.getAbsolutePath());
        p.setApFileS(apFileS.getAbsolutePath());
        p.setEncFile( encFile.getAbsolutePath());
        pd.addPath(p);
        
        return txHash;
    }
    
   
    
	
    /**
     * 字符串->16进制数
     * 1.1字符串转换unicode
     */
    public static String string2Unicode(String string) {
    	StringBuffer unicode = new StringBuffer();
    	for (int i = 0; i < string.length(); i++) {
    	// 取出每一个字符
    	char c = string.charAt(i);
    	// 转换为unicode
    	unicode.append("\\u" + Integer.toHexString(c));
    	}
    	return unicode.toString();
    	}   
    
   
    /**
     * 字符串->16进制数
     * 1.2unicode字符串转化成为16进制字符串
     * @param s
     * @return
     */
    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }
    
    
    
    public static String ReadFile(File path) {
    	FileInputStream fis=null;
        BufferedReader bufferedReader=null;
        String str="";
        try{
            fis=new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(fis, "GBK"));
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
//        System.out.println(str);
    	
    	
    	return str;
    	
    }
    
    public static  void WriteFile(String str,String path){
    	File fileOut=new File(path);
    	
    	try {
			
    		
            FileOutputStream fos=null;
            fos=new FileOutputStream(fileOut,false);

            BufferedWriter bufferedWriter=null;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "GBK"));
            char[] arry = str.toCharArray();
            
            for (char tempchar: arry){
                bufferedWriter.write(tempchar);
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            fos.close();

//			System.out.println("finish");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }

    
   
    
}
