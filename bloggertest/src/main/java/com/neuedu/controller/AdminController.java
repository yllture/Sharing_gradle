package com.neuedu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.Utils.PushtoSingle;
import com.neuedu.entity.Adimin;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Bank_multiple;
import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_single;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.User;
import com.neuedu.service.AdminService;
import com.neuedu.service.Bank_fillService;
import com.neuedu.service.Bank_judgeService;
import com.neuedu.service.Bank_multipleService;
import com.neuedu.service.Bank_shortanswerService;
import com.neuedu.service.Bank_singleService;
import com.neuedu.service.ExamrecordService;
import com.neuedu.service.PaperService;
import com.neuedu.service.Paper_fillService;
import com.neuedu.service.Paper_fillchoiceService;
import com.neuedu.service.Paper_judgeService;
import com.neuedu.service.Paper_multipleService;
import com.neuedu.service.Paper_multiplechoiceService;
import com.neuedu.service.Paper_shortanswerService;
import com.neuedu.service.Paper_singleService;
import com.neuedu.service.Paper_singlechoiceService;
import com.neuedu.service.Shop_bankService;
import com.neuedu.service.Shop_paperService;
import com.neuedu.service.UserService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	Shop_bankService  shop_bankService;
	@Autowired
	Shop_paperService  shop_paperService;
	@Autowired
	UserService  userService;
	@Autowired
	PaperService paperService;
	@Autowired
	Paper_fillService paper_fillService;
	@Autowired
	Paper_judgeService paper_judge_Service;
	@Autowired
	Paper_multipleService paper_multipleService;
	@Autowired
	Paper_shortanswerService paper_shortanswer_Service;
	@Autowired
	Paper_singleService papersingle_Service;
	@Autowired
	Paper_singlechoiceService paper_singlechoiceService;
	@Autowired
	Paper_multiplechoiceService paper_multiplechoiceService;
	@Autowired
	Paper_fillchoiceService paper_fillchoiceService;
	@Autowired 
	ExamrecordService examrecordService;
	@Autowired 
	Bank_singleService bank_singleService;
	@Autowired 
	Bank_multipleService bank_multipleService;
	@Autowired 
	Bank_judgeService bank_judgeService;
	@Autowired 
	Bank_fillService bank_fillService;
	@Autowired 
	Bank_shortanswerService bank_shortanswerService;
	
	@RequestMapping("/toAdminLogin")
	public String toLogin() {
		return "admin/manage_login.html";
	}
	@RequestMapping("/adminLogin")
	public String  admin(String username,String password,HttpServletRequest req) throws IOException {
		System.out.println(username);
		List<Adimin> list = adminService.SelectByAdminName(username);
		
		if(list!=null|| list.size()!=0) {
			for(Adimin  admin :list) {
				System.out.println("密码："+admin.getPassword());
				if(admin.getPassword().equals(password)) {
					return "admin/manage_index.html";
				}
			}
		}
		req.setAttribute("tipInfo","用户名或者密码错误");
		return "admin/manage_login.html";
		
	}
	@RequestMapping("/toManage_index")
	public String toManage_index(){
		return "admin/manage_index";
	}
	@RequestMapping("/toCheck_question")
	public String toCheck_question() {
		return "admin/check_question";
	}
	@RequestMapping("/toCheck_questionBank")
	public String toCheck_questionBank() {
		return "admin/check_questionBank";
	}
	@RequestMapping("/updateCheck_paper")
	public  void updateCheck_paper(HttpServletResponse res) throws IOException {
//		 List<Shop_paper> notCheckedList = shop_paperService.selectByCheckFlag(0);
		 Shop_paper item=new Shop_paper();
		 item.setCheckflag(0);
		 List<Shop_paper> notCheckedList=shop_paperService.selectByType(item);
		 List list=new ArrayList();
		 Map<String, List<Shop_paper>> map=new LinkedHashMap<String, List<Shop_paper>>();
		 //json数组
		 
		 for(int i=0;i<notCheckedList.size();i++) {
			 Map m=new LinkedHashMap();
			 m.put("id",i+1);
			 m.put("title",notCheckedList.get(i).getPapername());
			 m.put("paperid", notCheckedList.get(i).getPaperid());
			
			
			 m.put("writer",userService.selectUserByPrimaryKey(notCheckedList.get(i).getUser()).getUsername());
			 m.put("questionNumber",notCheckedList.get(i).getQuestionnum());
			  SimpleDateFormat ft = 
				      new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss ");
			 
			 m.put("public_date",ft.format(notCheckedList.get(i).getTime()));
			 m.put("money",notCheckedList.get(i).getPrice());
			 list.add(m);
			
		}
		 map.put("notCheckedList",list);
		 String jsonString = JSONArray.toJSONString(map);
		 res.setContentType("text/html;charset=utf-8");
		 res.getWriter().print(jsonString);
		 return;
		 
		 
		
	}
	
	@RequestMapping("/updateCheck_questionBank")
	public  void updateCheck_questionBank(HttpServletResponse res) throws IOException {
		 //List<Shop_bank> notCheckedList = shop_bankService.selectByCheckFlag(0);
		
		 Shop_bank item=new Shop_bank();
		 item.setCheckflag(0);
		 List<Shop_bank> notCheckedList=shop_bankService.selectByType(item);
		 List list=new ArrayList();
		 Map<String, List<Shop_bank>> map=new LinkedHashMap<String, List<Shop_bank>>();
		 //json数组
		 
		 for(int i=0;i<notCheckedList.size();i++) {
			 Map m=new LinkedHashMap();
			 m.put("id",i+1);
			 m.put("title",notCheckedList.get(i).getBankname());
			 m.put("bankid", notCheckedList.get(i).getBankid());
			
			 User u=new User();
			 u.setUserid(notCheckedList.get(i).getUserid());
			 m.put("writer",userService.selectUserByPrimaryKey(u).getUsername());
			 m.put("questionNumber",notCheckedList.get(i).getQuestionnum());
			  SimpleDateFormat ft = 
				      new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss ");
			 
			 m.put("public_date",ft.format(notCheckedList.get(i).getTime()));
			 m.put("money",notCheckedList.get(i).getPrice());
			 list.add(m);
			
		}
		 map.put("notCheckedList",list);
		 String jsonString = JSONArray.toJSONString(map);
		 res.setContentType("text/html;charset=utf-8");
		 res.getWriter().print(jsonString);
		 return;
		 
		 
		
	}
	@RequestMapping("/approve_bank")
	public void approve_bank(@RequestParam(value="bankid",required=false,defaultValue="-1") String bankid,HttpServletResponse res) throws Exception {
		if(Integer.parseInt(bankid)==-1) {
			res.getWriter().print(0);
			
		}
		else {
			
			Shop_bank bank=new Shop_bank();
			bank.setBankid(Integer.parseInt(bankid));
			Shop_bank selectbyBankid = shop_bankService.selectbyBankid(bank);
			if(selectbyBankid.getCheckflag()==0) {
			bank.setCheckflag(1);
			
			int i=shop_bankService.updateCheckFlag(bank);
			Shop_bank sb=shop_bankService.selectbyBankid(bank);
			User uc=new User();
			uc.setUserid(sb.getUserid());
			User u=userService.selectUserByPrimaryKey(uc);
			PushtoSingle ps=new PushtoSingle();
			ps.psstart(u.getC1(), ps.linkapproveBank(sb.getBankname()));
			
			res.getWriter().print(i);
			}else {
				res.getWriter().print(2);
			}
			
		}
		return;
		
	}
	@RequestMapping("/notApprove_bank")
	public void notApprove_bank(@RequestParam(value="bankid",required=false,defaultValue="-1") String bankid,HttpServletResponse res) throws Exception {
		if(Integer.parseInt(bankid)==-1) {
			res.getWriter().print(0);
			
		}
		else {
			Shop_bank bank=new Shop_bank();
			bank.setBankid(Integer.parseInt(bankid));
			Shop_bank selectbyBankid = shop_bankService.selectbyBankid(bank);
			if(selectbyBankid.getCheckflag()==0) {
			bank.setCheckflag(2);
			
			int i=shop_bankService.updateCheckFlag(bank);
			
			Shop_bank sb=shop_bankService.selectbyBankid(bank);
			User uc=new User();
			uc.setUserid(sb.getUserid());
			User u=userService.selectUserByPrimaryKey(uc);
			PushtoSingle ps=new PushtoSingle();
			ps.psstart(u.getC1(), ps.linknotapproveBank(sb.getBankname()));
			
			res.getWriter().print(i);
			}else {
				res.getWriter().print(2);
			}
			
		}
		return;
		
	}
	
	//审核试卷的相关内容
	
	
	@RequestMapping("/approve_paper")
	public void approve_paper(@RequestParam(value="paperid",required=false,defaultValue="-1") String paperid,HttpServletResponse res) throws IOException {
		if(Integer.parseInt(paperid)==-1) {
			res.getWriter().print(0);
			
		}
		else {
			Shop_paper paper=new Shop_paper();
			paper.setPaperid(Integer.parseInt(paperid));
			Shop_paper selectbypaperid = shop_paperService.selectbypaperid(paper);
			if(selectbypaperid.getCheckflag()==0) {
			paper.setCheckflag(1);
			int i=shop_paperService.updateCheckFlag(paper);
			res.getWriter().print(i);
			}
			else {
				res.getWriter().print(2);
			}
			
		}
		return;
		
	}
	@RequestMapping("/notApprove_paper")
	public void notApprove_paper(@RequestParam(value="paperid",required=false,defaultValue="-1") String paperid,HttpServletResponse res) throws IOException {
		if(Integer.parseInt(paperid)==-1) {
			res.getWriter().print(0);
			
		}
		else {
			Shop_paper paper=new Shop_paper();
			paper.setPaperid(Integer.parseInt(paperid));
			Shop_paper selectbypaperid = shop_paperService.selectbypaperid(paper);
			if(selectbypaperid.getCheckflag()==0) {
			paper.setCheckflag(2);
			int i=shop_paperService.updateCheckFlag(paper);
			res.getWriter().print(i);
			}
			else {
				res.getWriter().print(2);
			}
		}
		return;
		
	}
	
	
	
	
	@RequestMapping("/showPaperDetail/{paperid}")
	public  String showPaperDetail(@PathVariable Integer paperid,HttpServletRequest req) {
		Shop_paper shoppaper=new Shop_paper();
		shoppaper.setPaperid(paperid);
		Shop_paper sp = shop_paperService.selectbypaperid(shoppaper);
		Paper p=new Paper();
		shoppaper.setPaperid(paperid);
		
		//获得用户
		Integer winder = sp.getWinder();
		User u=new User();
		u.setUserid(winder);
		userService.selectUserByPrimaryKey(u);
		//获得单项选择
		List<Paper_single> singles = papersingle_Service.getAllbyPaperid(p);
		//多项选择
		List<Paper_multiple> multiples = paper_multipleService.getAllbyPaperid(p);
		//判断题
		List<Paper_judge> judges= paper_judge_Service.getAllbyPaperid(p);
		//填空题
		List<Paper_fill> fills = paper_fillService.getAllbyPaperid(p);
		//简答题
		List<Paper_shortanswer> shortanswers = paper_shortanswer_Service.getAllbyPaperid(p);
		req.setAttribute("singles", singles);
		req.setAttribute("multiples", multiples);
		req.setAttribute("judges", judges);
		req.setAttribute("fills", fills);
		req.setAttribute("shortanswers", shortanswers);
		req.setAttribute("paper", p);
		req.setAttribute("shoppaper", sp);
		req.setAttribute("user", u);
		return "admin/waitingcheckPaperDetail";
	}
	
	@RequestMapping("/showBankDetail/{paperid}")
	public  String showBankDetail(@PathVariable Integer bankid,HttpServletRequest req) {
		Shop_bank shopbank=new Shop_bank();
		shopbank.setBankid(bankid);
		Shop_bank sb = shop_bankService.selectbyBankid(shopbank);
	    Bank b=new Bank();
		b.setBankid(bankid);
		
		//获得用户
		Integer winder = sb.getUserid();
		User u=new User();
		u.setUserid(winder);
		userService.selectUserByPrimaryKey(u);
		
		//获得单项选择
		List<Bank_single> singles = bank_singleService.getAllbyBankid(b);
		//多项选择
		List<Bank_multiple> multiples = bank_multipleService.getAllbyBankid(b);
		//判断题
		List<Bank_judge> judges= bank_judgeService.getAllbyBankid(b);
		//填空题
		List<Bank_fill> fills = bank_fillService.getAllbyBankid(b);
		//简答题
		List<Bank_shortanswer> shortanswers = bank_shortanswerService.getAllbyBankid(b);
		req.setAttribute("singles", singles);
		req.setAttribute("multiples", multiples);
		req.setAttribute("judges", judges);
		req.setAttribute("fills", fills);
		req.setAttribute("shortanswers", shortanswers);
		req.setAttribute("bank", b);
		req.setAttribute("shopbank", sb);
		req.setAttribute("user", u);
		return "admin/waitingcheckBankDetail";
	}
	
	
	
	
	
	

}
