package com.neu.Sharing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.Sharing.entity.Apply;
import com.neu.Sharing.entity.User;
import com.neu.Sharing.service.ApplyService;
import com.neu.Sharing.service.Authorizationdata;
import com.neu.Sharing.service.RecodeOnChain;
import com.neu.Sharing.service.Revokedata;

@Controller
public class RevokedataController {
	
	//撤销授权
	
	@RequestMapping("/revokedata")
	public @ResponseBody String Applydata(String applyid,String filename,HttpServletRequest request) throws Exception {
		User user =(User) request.getSession().getAttribute("currentUser");
		
		Apply a = new Apply();
		a.setApplyid(Integer.parseInt(applyid));
		Revokedata rd = new Revokedata();
		rd.Revokedata(a);
		//撤销记录上链
		String record = null;
		ApplyService as = new ApplyService();
		List<Map<String, Object>> list =as.selectByID(a);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		record = (String)list.get(0).get("owner") +"撤销了"+list.get(0).get("applicant")+"申请的"+filename+"授权,"+time;
		System.out.println(record);
		RecodeOnChain roc = new RecodeOnChain();
		roc.AuthorizeOrRevokeRecord(record, user, 3);
		
		return "1";
	}
}
