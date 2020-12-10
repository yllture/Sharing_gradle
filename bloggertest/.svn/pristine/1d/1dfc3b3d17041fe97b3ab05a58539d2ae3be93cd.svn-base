package com.neuedu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.neuedu.entity.*;
import com.neuedu.entity.Shop_bankExample.Criteria;
import com.neuedu.service.BankService;
import com.neuedu.service.Bank_fillService;
import com.neuedu.service.Bank_fillchoiceService;
import com.neuedu.service.Bank_judgeService;
import com.neuedu.service.Bank_multipleService;
import com.neuedu.service.Bank_multiplechoiceService;
import com.neuedu.service.Bank_shortanswerService;
import com.neuedu.service.Bank_shortanswer_movService;
import com.neuedu.service.Bank_shortanswer_picService;
import com.neuedu.service.Bank_singleService;
import com.neuedu.service.Bank_singlechoiceService;
import com.neuedu.service.PaperService;
import com.neuedu.service.Paper_fillService;
import com.neuedu.service.Paper_fillchoiceService;
import com.neuedu.service.Paper_judgeService;
import com.neuedu.service.Paper_multipleService;
import com.neuedu.service.Paper_multiplechoiceService;
import com.neuedu.service.Paper_shortanswerService;
import com.neuedu.service.Paper_shortanswer_movService;
import com.neuedu.service.Paper_shortanswer_picService;
import com.neuedu.service.Paper_singleService;
import com.neuedu.service.Paper_singlechoiceService;
import com.neuedu.service.PayrecordService;
import com.neuedu.service.Shop_bankService;
import com.neuedu.service.Shop_paperService;
import com.neuedu.service.UserService;

@Controller
public class ShopController {
    
	@Autowired
	Shop_bankService shopbankservice;
	
	@Autowired
	Shop_paperService shoppaperservice;
	
	
	@Autowired
	BankService bankService;
	@Autowired
	Bank_fillService bank_fillService;
	@Autowired
	Bank_multipleService bank_multipleService;
	@Autowired
	Bank_singleService bank_singleService;
	@Autowired
	Bank_judgeService bank_judgeService;
	@Autowired
	Bank_shortanswerService bank_shortanswerService;
	@Autowired
	Bank_fillchoiceService bank_fillchoiceService;
	@Autowired
	Bank_multiplechoiceService bank_multiplechoiceService;
	@Autowired
	Bank_singlechoiceService bank_singlechoiceService;
	@Autowired
	UserService userService;
	
	@Autowired
	PayrecordService payrecordService;


	@Autowired
	PaperService paperService;
	@Autowired
	Paper_judgeService paper_judgeService;
	@Autowired
	Paper_fillService paper_fillService;
	@Autowired
	Paper_fillchoiceService paper_fillchoiceService;
	@Autowired
	Paper_multipleService paper_multipleService;
	@Autowired
	Paper_multiplechoiceService paper_multiplechoiceService;
	@Autowired
	Paper_singleService paper_singleService;
	@Autowired
	Paper_singlechoiceService paper_singlechoiceService;
	@Autowired
	Paper_shortanswerService paper_shortanswerService;
	@Autowired
	Paper_shortanswer_movService paper_shortanswer_movService;
	@Autowired
	Paper_shortanswer_picService paper_shortanswer_picService;
	
	 
	@RequestMapping("/tobankshop")
	public String bankshop(@RequestParam(value="sorttype",required=false,defaultValue="1") int sorttype,
			@RequestParam(value="chargetype",required=false,defaultValue="0") int chargetype,
			@RequestParam(value="label",required=false,defaultValue=" ") String label,
			@RequestParam(value="search",required=false,defaultValue=" ") String search,
			@RequestParam(value="keywords",required=false,defaultValue=" ") String keywords,
			@RequestParam(value="page",required=false,defaultValue="1") int page,
			@RequestParam(value="pagesize",required=false,defaultValue="15") int pagesize,Model model,HttpServletRequest req ) {
	     	HttpSession session = req.getSession();	   
			session.setAttribute("sorttype", sorttype);
            session.setAttribute("pagesize", pagesize);
            session.setAttribute("chargetype", chargetype);
            session.setAttribute("search", search);      
            session.setAttribute("label", label);
		Shop_bankExample shop_bank=new Shop_bankExample();
		Criteria c1 = shop_bank.createCriteria();
	
		int start=page*pagesize-pagesize;
		if(sorttype==0) 
		{
			String clause="desc  limit "+pagesize+" offset "+start;
			shop_bank.setOrderByClause("time "+clause);
		}
		else if(sorttype==1)
		{
			String clause="desc  limit "+pagesize+" offset "+start;
			shop_bank.setOrderByClause("paynum "+clause);
		} 
		if(chargetype==1)
		{
			
		    c1.andPriceEqualTo(0);
		}
		else if(chargetype==2)
		{
			c1.andPriceGreaterThan(0);
		}
		if(label.equals(" "))
		{
			
		}
		else {
			c1.andBanklabelLike("%"+label+"%");
		}
		if(search.equals(" "))
		{
			
		}
		else {
			c1.andBanknameLike("%"+search+"%");
			c1.andBankdescriptionLike("%"+search+"%");
		}
		c1.andCheckflagEqualTo(1);
		int count=shopbankservice.countByExample(shop_bank);
		List<Shop_bank> banks=shopbankservice.selectByExample(shop_bank);
		model.addAttribute("banks",banks);
		model.addAttribute("pagesize",pagesize);
		model.addAttribute("page",page);	
		model.addAttribute("count",count);
		return "shopmarket/bankshop";
		
	}
	
	
	
	

	@RequestMapping("/topapershop")
	public String papershop(@RequestParam(value="sorttype",required=false,defaultValue="1") int sorttype,
			@RequestParam(value="chargetype",required=false,defaultValue="0") int chargetype,
			@RequestParam(value="label",required=false,defaultValue=" ") String label,
			@RequestParam(value="search",required=false,defaultValue=" ") String search,
			@RequestParam(value="page",required=false,defaultValue="1") int page,
			@RequestParam(value="keywords",required=false,defaultValue=" ") String keywords,
			@RequestParam(value="pagesize",required=false,defaultValue="15") int pagesize,
			Model model,HttpServletRequest req) {
		Shop_paperExample shop_paper=new Shop_paperExample();
		com.neuedu.entity.Shop_paperExample.Criteria c1 = shop_paper.createCriteria();
		HttpSession session = req.getSession();
		 session.setAttribute("label", label);
		 session.setAttribute("search", search);
		session.setAttribute("pagesize", pagesize);
		session.setAttribute("sorttype", sorttype);
     	session.setAttribute("chargetype", chargetype);
     	
		int start=page*pagesize-pagesize;
		if(sorttype==0) 
		{
			String clause="desc  limit "+pagesize+" offset "+start;
			shop_paper.setOrderByClause("time "+clause);
		}
		else if(sorttype==1)
		{
			String clause="desc  limit "+pagesize+" offset "+start;
			shop_paper.setOrderByClause("paynum "+clause);
		} 
		if(chargetype==1)
		{
		    c1.andPriceEqualTo(0);
		}
		else if(chargetype==2)
		{
			c1.andPriceGreaterThan(0);
		}
		if(label.equals(" "))
		{
			
		}
		else {
			c1.andPaperlabelLike("%"+label+"%");
		}
		if(search.equals(" "))
		{
			
		}
		else {
			c1.andPapernameLike("%"+search+"%");
		
		}
		c1.andCheckflagEqualTo(1);
		int count=shoppaperservice.countByExample(shop_paper);
		List<Shop_paper> papers=shoppaperservice.selectByExample(shop_paper);
		
		model.addAttribute("papers",papers);
		model.addAttribute("pagesize",pagesize);
		model.addAttribute("page",page);	
		model.addAttribute("count",count);
		return "shopmarket/papershop";
		
	} 

	
	
	
	
	
	@RequestMapping("/bankshopdetail")
	public String bankshopdetail(@RequestParam(value="shop_bankid",required=false,defaultValue="0") int bankid,Model model,HttpServletRequest request) {
		
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
			
		
		int userid=currentUser.getUserid();//这个最后别忘了改成从session中获取值
		Payrecord p = new Payrecord();
		p.setBankid(bankid);
		p.setBuyid(userid);
		int isbuy = payrecordService.isPurchaseBank(p);

		Shop_bank shopbank = new Shop_bank();
		shopbank.setBankid(bankid);
		Shop_bank bank=shopbankservice.selectbyBankid(shopbank);
		User u = new User();
		u.setUserid(bank.getUserid());
		u = userService.selectUserByPrimaryKey(u);
		List<Payrecord> allBankRecord = payrecordService.getallBankRecord(bank);
//		for(int i=0 ;i<allBankRecord.size();i++) {
//			 String json =JSON.toJSONString(allBankRecord.get(i));
//			System.out.println(json);
//		}
		
		Bank b=new Bank();
	    b.setBankid(bankid);
//		List<Bank_fill> allfill = bank_fillService.getAllbyBankid(b);
//		List<Bank_multiple> allmultiple = bank_multipleService.getAllbyBankid(b);
		List<Bank_single> allsingle = bank_singleService.getAllbyBankid(b);		
//		List<Bank_shortanswer> allshortanswer = bank_shortanswerService.getAllbyBankid(b);
		List<Bank_single> selectsingle = new ArrayList<Bank_single>();
		//如果单选题数大于2，则仅选择前三个进行显示，否则就全部显示
		if(allsingle.size()>2) {
			for(int i=0;i<3;i++) {
				selectsingle.add(allsingle.get(i));
			}
			model.addAttribute("bank_singles", selectsingle);
		}else {
			model.addAttribute("bank_singles", allsingle);
		}
		model.addAttribute("isbuy",isbuy);
		model.addAttribute("recordlist", allBankRecord);
		model.addAttribute("bank", bank);
		model.addAttribute("user",u);

		return "shopmarket/bankshopdetail";
		
	}
	
	

	
	@RequestMapping("/papershopdetail")
	public String papershopdetail(@RequestParam(value="shop_paperid",required=false,defaultValue="0") int paperid,HttpServletRequest request,Model model) {
		//从前台获得paperid 
		User currentUser = (User) request.getSession().getAttribute("currentUser");

		int userid = currentUser.getUserid();//应该是通过session获得userid
		Payrecord pay = new Payrecord();
		pay.setPaperid(paperid);
		pay.setBuyid(userid);
		int isbuy = payrecordService.isPurchasePaper(pay);

		Shop_paper shoppaper = new Shop_paper();
		shoppaper.setPaperid(paperid);
		Shop_paper paper=shoppaperservice.selectbypaperid(shoppaper);
		User u = new User();
		u.setUserid(paper.getWinder());
		u = userService.selectUserByPrimaryKey(u);
		List<Payrecord> allPaperRecord = payrecordService.getallPaperRecord(paper);
		Paper p=new Paper();
	    p.setPaperid(paperid);

		List<Paper_single> allsingle = paper_singleService.getAllbyPaperid(p);		
//		List<Paper_shortanswer> allshortanswer = paper_shortanswerService.getAllbyPaperid(p);
		List<Paper_single> selectsingle = new ArrayList<Paper_single>();
		//如果单选题数大于2，则仅选择前三个进行显示，否则就全部显示
		if(allsingle.size()>2) {
			for(int i=0;i<3;i++) {
				selectsingle.add(allsingle.get(i));
			}
			model.addAttribute("paper_singles", selectsingle);
		}else {
			model.addAttribute("paper_singles", allsingle);
		}
		
		model.addAttribute("isbuy",isbuy);
		model.addAttribute("recordlist",allPaperRecord);
		model.addAttribute("user", u);
		model.addAttribute("paper", paper);	
		return "shopmarket/papershopdetail";
		
	}
	
	@RequestMapping("/buypaper")
	public @ResponseBody String buypaper(@RequestBody Shop_paper s,HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		int userid= currentUser.getUserid();
		Paper paper = paperService.selectPaperbyId(s.getPaperid());
		int newpaperid = paperService.Buypaper(paper,userid);
		
		User u = new User();
		u.setUserid(userid);
		u = userService.selectUserByPrimaryKey(u);
		int integral = u.getIntegral()-s.getPrice();
		u.setIntegral(integral);
		userService.updateUser(u);
		
		Payrecord pr = new Payrecord();
		pr.setBuyid(userid);
		pr.setNewpaperid(newpaperid);
		pr.setPaperid(s.getPaperid());
		pr.setName(paper.getPapername());
		pr.setSolderid(paper.getWinder());
		pr.setIntegral(s.getPrice());
		pr.setTime(new Date());
		pr.setCommentscore(0);
		payrecordService.addPayrecord(pr);
		return "";
	} 
	
	
	
	
	@RequestMapping("/buybank") 
	public @ResponseBody String buyBank(@RequestBody Shop_bank s,HttpServletRequest request) {
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid = currentUser.getUserid();
		
		Bank b=new Bank();
		b.setBankid(s.getBankid());
		b= bankService.selectBankByID(b);
		int newbankid = bankService.BuyBank(b,userid);
		User u = new User();
		u.setUserid(userid);
		u = userService.selectUserByPrimaryKey(u);
		int integral = u.getIntegral()-s.getPrice();
		u.setIntegral(integral);
		userService.updateUser(u);
		
		Payrecord pr = new Payrecord();
		pr.setBuyid(userid);
		pr.setNewbankid(newbankid);
		pr.setBankid(s.getBankid());
		pr.setName(b.getBankname());
		pr.setSolderid(b.getUserid());
		pr.setIntegral(s.getPrice());
		pr.setTime(new Date());
		pr.setCommentscore(0);
		payrecordService.addPayrecord(pr);
		
		
		
		
		return "";
	} 
	
	
	
	
	
	
}
