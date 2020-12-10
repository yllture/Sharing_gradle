package com.neuedu.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.ServletRequest;


import com.neuedu.entity.User;
 
/**
 * @author amuxia
 * 2017年7月24日
 */
public class MailUrlUtils {
	
	private static final String CHECK_CODE = "checkCode";
	
	public static String generateActivateLink(int userid,String username) {
		return "http://localhost:8080/checkMail?id=" 
				+ userid + "&" + CHECK_CODE + "=" + generateCheckcode(username);
	}
	
	
	/**
	 * 生成校验码，用户名+UUID唯一标识符，为安全把他们加密发送
	 * @param user
	 * @return
	 */
	public static String generateCheckcode(String username) {
		String userName = username;
		String randomCode=UUID.randomUUID().toString().replace("-","");
		return md5(userName + ":" + randomCode);
	}
 
	
	/**
	 * 接收回来的校验码和发送出去的是不是同一份
	 * @param user
	 * @param request
	 * @return
	 */
	public static boolean verifyCheckcode(int userid,String username,String Ccode) {
		//String checkCode = request.getParameter(CHECK_CODE);
		boolean i=generateCheckcode(username).equals(Ccode);
		return i;
	}
 
	private static String md5(String string) {
		System.out.println(string);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
			md.update(string.getBytes());
			byte[] md5Bytes = md.digest();
			return bytes2Hex(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("md5这里出错了");
		}
		
		return null;
	}
	
	private static String bytes2Hex(byte[] byteArray)
	{
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++)
		{
			if(byteArray[i] >= 0 && byteArray[i] < 16)
			{
				strBuf.append("0");
			}
			strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));
		}
		return strBuf.toString();
	}
}
