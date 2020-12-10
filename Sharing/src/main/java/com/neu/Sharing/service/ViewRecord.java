package com.neu.Sharing.service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import com.neu.Sharing.cpabe.CPABETool;
import com.neu.Sharing.dao.PathDao;
import com.neu.Sharing.dao.RecordDao;
import com.neu.Sharing.entity.Path;
import com.neu.Sharing.entity.Record;
import com.neu.Sharing.entity.User;

public class ViewRecord {

	private  File gpFile;
	private File apFileS;


	
	public List<Map<String, Object>>  ViewAllRecord(Record r,User u) throws IOException {
		List<String> recordlist = new ArrayList<String>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		//去数据库中查询相关的交易hash
		//启动IoC容器
		ApplicationContext ctx= JDBCBean.getAc();
    	//获取IoC容器中JdbcTemplate实例
    	JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
    	RecordDao rd = new RecordDao();
        rd.setJdbcTemplate(jdbcTemplate);    
        List<Map<String, Object>> list =rd.getRecord(r);
        if(list.size()==0) {
        	return result;
        }
//        System.out.println(list);
		Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));

		PathDao pd = new PathDao();
		pd.setJdbcTemplate(jdbcTemplate);
		Path p = new Path();
        for(int i =0;i<list.size();i++) {
        	String txHash = (String) list.get(i).get("hash");
        	System.out.println(txHash);
    		Optional<Transaction>tx = web3j.ethGetTransactionByHash(txHash).send().getTransaction();
    		String input = tx.get().getInput();
//    		System.out.println(tx.get().getInput());
    		String str = input.substring(2,input.length());//去除0x
    		String str2 = unicode2String(hexStringToString(str));
//    		System.out.println(str2);
    		//将str2的内容写入文件
    		WriteFile(str2,"D:\\EclipseCode\\Sharing\\encFile");
        	
    		//去数据库中找到gpFile、apFileS
    		p.setHash(txHash);
    		List<Map<String, Object>> plist = pd.getPath(p);
    		apFileS =  new File((String) plist.get(0).get("apFileS"));
    		gpFile = new File((String) plist.get(0).get("gpFile"));
    		File encFile = new File((String) plist.get(0).get("encFile"));

          File key1AFile;
          key1AFile = File.createTempFile("user1_a", "key");
          key1AFile.deleteOnExit();
  		  String[] keyGenA = {"keyGen", "user1", u.getAccountaddress(), gpFile.getAbsolutePath(), apFileS.getAbsolutePath(), key1AFile.getAbsolutePath()};
          CPABETool.main(keyGenA);//属性ֵ
          
          
          File key1BFile;
          key1BFile = File.createTempFile("user1_b", "key");
          key1BFile.deleteOnExit();
          String[] keyGenB = {"keyGen", "user1", u.getUsername(), gpFile.getAbsolutePath(), apFileS.getAbsolutePath(), key1BFile.getAbsolutePath()};
          CPABETool.main(keyGenB);
  		
          File  resFile2 = new File("D:\\EclipseCode\\Sharing\\result.txt");
         
          String[] arg = {"dec", "user1", encFile.getAbsolutePath(), resFile2.getAbsolutePath(), gpFile.getAbsolutePath(), key1AFile.getAbsolutePath(), key1BFile.getAbsolutePath()};
//        System.out.println(encFile.getAbsolutePath());
          CPABETool.main(arg);//解密
          //将解密好的数据读出存放
          String record = ReadFile(resFile2);
          System.out.println(record);
          recordlist.add(record);
        }
        
        for(int i =0 ;i<recordlist.size();i++) {
			String str = recordlist.get(i);
			StringTokenizer st = new StringTokenizer(str, ",");
			String record =st.nextToken();
			String time = st.nextToken();
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("record", record);
			map.put("time", time);
			result.add(map); 
		

		}
		listSort(result);
        

		return result;
	}
	
	
	 /**
     * 根据时间排序倒序
     * @param list
     */
	public void listSort(List<Map<String, Object>> list) {
       
//        System.out.println("排序前----:" + Json.toJson(list, JsonFormat.compact()));
        Collections.sort(list, new Comparator<Map<String, Object>>() {
           

			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				// TODO Auto-generated method stub
				if(((String) o1.get("time")).compareTo((String) o2.get("time"))>0) {
					
					return -1;
					
				}else if(((String) o1.get("time")).compareTo((String) o2.get("time"))<0) {
					return 1;
				}else {
					return 0;
				}
				
			}
        });
//        System.out.println("排序后----:" + Json.toJson(list, JsonFormat.compact()));
    }
	
	/**
     * 16进制数->字符串
     * 2.1  16进制转换成为unicode字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
    /**
     * 16进制数->字符串
     * 2.2 unicode 转字符串
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
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
