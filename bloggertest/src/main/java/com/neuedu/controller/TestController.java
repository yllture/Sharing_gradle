package com.neuedu.controller;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.Utils.FaceMatch;
import com.neuedu.Utils.ImgUtils;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import sun.misc.BASE64Decoder;
import com.baidu.ai.aip.utils.GsonUtils;
import java.io.FileNotFoundException;
import java.util.*;
import org.json.JSONException;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;
import com.baidu.ai.aip.utils.GsonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


@Controller
public class TestController {
	
	@Autowired
	UserService userService;
	@RequestMapping("/toTest")
	public String toTest() {
		return "studentPaper/verifyIdentify";
	}
	@RequestMapping("/toSave")
	public void picView(@RequestBody JSONObject obj,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException {	
//	  System.out.println("进来了");
	   User u=(User)request.getSession().getAttribute("currentUser");
	   User selectUserByPrimaryKey = userService.selectUserByPrimaryKey(u);
	   System.out.println("zhujian"+selectUserByPrimaryKey);
	   if(selectUserByPrimaryKey.getC3()==null||(selectUserByPrimaryKey.getC3()!=null&&selectUserByPrimaryKey.getC3()==0)) {
	    	 //这里表示是第一次考试
	    	 //将第一次采集人脸
	    	 File f =  ResourceUtils.getFile("classpath:static");
	    	
			 String rootPath=f.getPath();
			 String filePath = rootPath+"\\upload" +File.separator+ "face";
			 ImgUtils.makeSureDirExists(filePath);
			 UUID randomUUID = UUID.randomUUID();
			 String newFileName = randomUUID + ".jpg";
			 String path = filePath+File.separator+newFileName;
			 File picPath = new File(path);
			 String image =  (String)obj.get("image");//240
	         String type = (String)obj.get("val");//240
	         System.out.println("image:"+image);
	         System.out.println("zhujian"+selectUserByPrimaryKey);
	         if(null!=image && !"".equals(image)){//防止没有拍照直接保存产生的空指针的错误
	        	int w = (Integer)obj.get("w");
	        	int h = (Integer)obj.get("h");
	        	FileOutputStream out = null;
	        	if (null!=type &&"pixel".equals(type)) {//Trident
	  	            try {
	  		            BufferedImage bf = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  		            String[] rows = image.split("\\|");
		  	            for (int i = 0; i < rows.length; i++) {
		  	                String[] col = rows[i].split(";");
		  	                for (int j = 0; j < col.length; j++) {
		  	                    int data = Integer.parseInt(col[j], 10);
		  	                    bf.setRGB(j, i, data);
		  	                }
		  	            }
	  		           
	  		            ImageIO.write(bf, "jpg", picPath);
	  		         } catch (Exception e) {
	  		            e.printStackTrace();
	  		         }
	        	} else {//WebKit
	        		try {
	  		            byte[] bytes = null;
	  		            String imageStr = null;
		        	    //Base64解码并生成图片  
		        		//替换头
	  	                imageStr = image.replace("data:image/png;base64,", "").trim();
	  	                // Base64解码  
	                    bytes = new BASE64Decoder().decodeBuffer(imageStr);  
		        		for (int i = 0; i < bytes.length; ++i) {  
			        		if (bytes[i] < 0) {// 调整异常数据  
			        			bytes[i] += 256;  
			        		}  
		        		}  
						
		        		// 生成jpeg图片  
		        		out = new FileOutputStream(path);  
		        		out.write(bytes); 
		        		
		        		
		        		
		        		
		        		
		        	  } catch (Exception e) {
	  		            e.printStackTrace();
	  		         }finally{
	  		        	 if(null!=out){
	  		        		 out.flush();  
	  		        		 out.close(); 
	  		        	 }
	        		}
	        	}
	        	//将人脸地址保存到数据库中
	        	selectUserByPrimaryKey.setC2(path);
	        	selectUserByPrimaryKey.setC3(1);
	        	
	        	userService.updateUserSelective(selectUserByPrimaryKey);
	        	request.getSession().setAttribute("cuurentUser",selectUserByPrimaryKey);
	        	response.setCharacterEncoding("utf-8");
	        	response.getWriter().print("0");
	        	
	        }else{
	        	System.out.println("图像为空");
	        }
	 
	     }
	     else {
	    	 //这里表示不是第一次参加考试
	    	 
	    	 //将现在的照片与数据中的照片形成对比。判断是否正确
	    	 File f =  ResourceUtils.getFile("classpath:static");
			 String rootPath=f.getPath();
			 String filePath = rootPath+"\\upload" +File.separator+ "copy";
			 ImgUtils.makeSureDirExists(filePath);
			 UUID randomUUID = UUID.randomUUID();
			 String newFileName = randomUUID + ".jpg";
			 String path = filePath+File.separator+newFileName;
			 File picPath = new File(path);
			 String image =  (String)obj.get("image");//240
	         String type = (String)obj.get("val");//240
	         System.out.println("image:"+image);
	         if(null!=image && !"".equals(image)){//防止没有拍照直接保存产生的空指针的错误
	        	int w = (Integer)obj.get("w");
	        	int h = (Integer)obj.get("h");
	        	FileOutputStream out = null;
	        	if (null!=type &&"pixel".equals(type)) {//Trident
	  	            try {
	  		            BufferedImage bf = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  		            String[] rows = image.split("\\|");
		  	            for (int i = 0; i < rows.length; i++) {
		  	                String[] col = rows[i].split(";");
		  	                for (int j = 0; j < col.length; j++) {
		  	                    int data = Integer.parseInt(col[j], 10);
		  	                    bf.setRGB(j, i, data);
		  	                }
		  	            }
	  		           
	  		            ImageIO.write(bf, "jpg", picPath);
	  		         } catch (Exception e) {
	  		            e.printStackTrace();
	  		         }
	        	} else {//WebKit
	        		try {
	  		            byte[] bytes = null;
	  		            String imageStr = null;
		        	    //Base64解码并生成图片  
		        		//替换头
	  	                imageStr = image.replace("data:image/png;base64,", "").trim();
	  	                // Base64解码  
	                    bytes = new BASE64Decoder().decodeBuffer(imageStr);  
		        		for (int i = 0; i < bytes.length; ++i) {  
			        		if (bytes[i] < 0) {// 调整异常数据  
			        			bytes[i] += 256;  
			        		}  
		        		}  
						
		        		// 生成jpeg图片  
		        		out = new FileOutputStream(path);  
		        		out.write(bytes);
		        		//人脸对比
		        		
		        		    String ak = "t6q6SPyKU6Ae6gwxgFEmqTeB";
		        	        String sk = "VaYrOhwKTwzaiSYlZVuUGwCNbIdfjIIQ";
		        	        String imgPath1 =path;
		        	        String imgPath2 =selectUserByPrimaryKey.getC2() ;
		        	        String result = FaceMatch.match(ak, sk, imgPath1, imgPath2);
		        	        System.out.println("对比结果为：" + result);
		        	        JSONObject parseObject = JSON.parseObject(result);
		        	        System.out.println("result对象:"+parseObject.toJSONString());
		        	       
		        	        
		        	        if(parseObject.getJSONObject("result")!=null) {
								
							String score = parseObject.getJSONObject("result").get("score").toString();
							System.out.println("相似得分为：" + score);
							String judge="" ;
							// 阈值为80，高于80分判断为同一人s
							if(Double.parseDouble(score) < 80) {
								judge = "不是同一人";
							    response.setCharacterEncoding("utf-8");
								response.getWriter().print("2");
							}
							else if( Double.parseDouble(score) >= 80){
							    judge = "同一人";
							    response.setCharacterEncoding("utf-8");
								response.getWriter().print("1");
							}
     	 
							System.out.println("判断为：" + judge);
							}
							else{
								  System.out.println("判断为：" + "不是同一人");
								  response.setCharacterEncoding("utf-8");
								  response.getWriter().print("2");
							 }
		        		
		        		
		        		
		        		
		        		
		        	  } catch (Exception e) {
	  		            e.printStackTrace();
	  		         }finally{
	  		        	 if(null!=out){
	  		        		 out.flush();  
	  		        		 out.close(); 
	  		        	 }
	        		}
	        	}
	        	
	        	
	        	
	        }else{
	        	System.out.println("图像为空");
	        }
	    	 
	    	 
	    	 
	     }
	}
	
	
	

}
