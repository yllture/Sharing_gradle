package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.neuedu.Utils.InvitingCode;
import com.neuedu.dao.Bank_fillMapper;
import com.neuedu.dao.Bank_judgeMapper;
import com.neuedu.dao.PapermappingMapper;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Bankfolder;
import com.neuedu.entity.Knowledge;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_fillchoice;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_shortanswer_mov;
import com.neuedu.entity.Paper_shortanswer_movKey;
import com.neuedu.entity.Paper_shortanswer_pic;
import com.neuedu.entity.Paper_shortanswer_picKey;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Paper_singlechoice;
import com.neuedu.entity.Papermapping;
import com.neuedu.entity.PapermappingExample;
import com.neuedu.entity.Shop_paper;
import com.neuedu.entity.TreeFolder;
import com.neuedu.entity.User;
import com.neuedu.entity.Shop_bankExample.Criteria;
import com.neuedu.service.*;
@Controller
public class Papercontroller {
	@Autowired
	PaperService paperService;
	@Autowired
	Paper_fillService paper_fillService;
	@Autowired
	Paper_multipleService paper_multipleService;
	@Autowired
	Paper_shortanswerService paper_shortanswerService;
	@Autowired
	Paper_singleService paper_singleService;
	@Autowired
	Paper_judgeService paper_judgeService;
	@Autowired
	Paper_fillchoiceService paper_fillchoiceService;
	@Autowired
	Bank_fillMapper bank_fillMapper;
	@Autowired
	Bank_judgeMapper bank_judgeMapper;
	@Autowired
	BankService bankService;
	@Autowired
	BankfolderService bankforderService;
	@Autowired
	Shop_paperService shop_paperService;
	@Autowired
	UserService userService;
	@Autowired
	PapermappingMapper papermappingMapper;

	
	@Autowired
	Paper_multiplechoiceService paper_multiplechoiceService;
	
	@Autowired
	Paper_singlechoiceService paper_singlechoiceService;
	
	@Autowired
	Paper_shortanswer_movService paper_shortanswer_movService;
	@Autowired
	Paper_shortanswer_picService paper_shortanswer_picService;
	@RequestMapping("/tounpublishteacherPaper")
	public String teacherPaper(HttpServletRequest request,Model m) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid= currentUser.getUserid();
		User u = new User();
		u.setUserid(userid);
		 
		List<Paper> list = paperService.selectPaperunPublic(u);
		List<Paper> uploadlist = new ArrayList<Paper>();
		List<Paper> unuploadlist = new ArrayList<Paper>();
		if(list!=null) {
			
			for(Paper p :list) {
				Shop_paper sp = new Shop_paper();
				sp.setPaperid(p.getPaperid());
				sp = shop_paperService.selectbypaperid(sp);
				if(sp==null) {
					unuploadlist.add(p);
				}else {
					uploadlist.add(p);
				}
			}	
		}
		m.addAttribute("uploadlist", uploadlist);
		m.addAttribute("unuploadlist", unuploadlist);
		
		return "teacherPaper/unpublishpaperTeacher";
	}
	
	@RequestMapping("/topublishteacherPaper")
	public String publishteacherPaper(HttpServletRequest request,Model m) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid= currentUser.getUserid();
		User u = new User();
		u.setUserid(userid);
		List<Paper> list = paperService.selectPaperPublic(u);
		m.addAttribute("list", list);
		return "teacherPaper/publishpaperTeacher";
		  
	}
	
	
	@RequestMapping("/deletepaper")
	public @ResponseBody String deletePaper(@RequestBody Paper p,HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		p.setWinder(currentUser.getUserid());
		paperService.deletePaper(p);
		
		return "";
	}
		
	
	
	
	
	@RequestMapping("/addpaper")
	public @ResponseBody String getPaper(@RequestBody Paper p,HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid = currentUser.getUserid();
		p.setWinder(userid);
		p.setQuestionnum(0);
		p.setSinglenum(0);
		p.setMultiplenum(0);
		p.setFillnum(0);
		p.setShortanswernum(0);
		p.setJudgenum(0);
		p.setQuestionscore(0);
		p.setSignlescore(0);
		p.setJudgescore(0);
		p.setMultiplescore(0);
		p.setFillscore(0);
		p.setShortanswerscore(0);
		p.setDuration("60");
		p.setDoingnum(0);
		p.setDonenum(0);
		p.setUndonenum(0);
		paperService.addPaper(p);
		Integer i=p.getPaperid();
		//System.out.println(p.getPapername()+p.getWinder()+p.getPaperlabel());
		return i.toString();
	}
	
	@RequestMapping("/updatepaper")
	public @ResponseBody String updatePaper(@RequestBody Paper p,HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		p.setWinder(currentUser.getUserid());
		paperService.updateByPaperId(p);
		return "";
	}
		
	@RequestMapping("/uploadpaper")
	public @ResponseBody String uploadPaper(@RequestBody Shop_paper sp) {
		Paper p = new Paper();
		p.setPaperid(sp.getPaperid());
		p = paperService.selectPaperbyId(p.getPaperid());
		sp.setPapername(p.getPapername());
		sp.setQuestionnum(p.getQuestionnum());
		sp.setSignlenum(p.getSinglenum());
		sp.setJudgenum(p.getJudgenum());
		sp.setMultiplenum(p.getMultiplenum());
		sp.setFillnum(p.getFillnum());
		sp.setShortanswernum(p.getShortanswernum());
		sp.setQuestionscore(p.getQuestionscore());
		sp.setSignlescore(p.getSignlescore());
		sp.setJudgescore(p.getJudgescore());
		sp.setMultiplescore(p.getMultiplescore());
		sp.setFillscore(p.getFillscore());
		sp.setShortanswerscore(p.getShortanswerscore());
		sp.setWinder(p.getWinder());
		sp.setTime(new Date());
		sp.setPaynum(0);
		sp.setAvgevaluate(0);
		sp.setCheckflag(0);
		shop_paperService.addShop_paper(sp);
		return "";
	}
	
	@RequestMapping("/checkuser")
	public @ResponseBody String checkUser(@RequestBody User u) {
		User select = new User();
		select= userService.selectUserByTel(u);
		if(select==null) {
			return "false";
		}
		if(select.getUsername().equals(u.getUsername())) {
			String s = select.getUserid().toString();
			return s;
		}else {
			return "false";
		}
		
	}
		
	 
	@RequestMapping("/publishpaper")
	public @ResponseBody String publishPaper(@RequestBody Paper p) {
		InvitingCode ic = new InvitingCode();
		String s = ic.toSerialCode(p.getPaperid());
		
		p.setInvitationcode(s);
		paperService.updateByPaperId(p);
		
		
		
		
		
//		Paper newpaper = new Paper();
//		newpaper  = paperService.selectPaperbyId(p.getPaperid());
////		newpaper.setPaperid(0);
//		newpaper.setBegintime(p.getBegintime());
//		newpaper.setEndtime(p.getEndtime()); 
//		newpaper.setType1(p.getType1());
////		newpaper.setExaminee(p.getExaminee());
//		newpaper.setDoflag(0);
////		if(newpaper.getInvitationcode()==null) {
////			newpaper.setInvitationcode(s);
////		}
////		
////		paperService.addPaper(newpaper);
//		int newpaperid= paperService.publishPaper(newpaper);
//		Papermapping pm = new Papermapping();
//		pm.setUserpaperid(newpaperid);
//		pm.setPaperid(p.getPaperid());
//		pm.setExaminee(p.getExaminee());
//		pm.setType(0);
//		papermappingMapper.insert(pm);
//		
//		
//		
		
		return "";
		
		
	}
	
	
	@RequestMapping("/addperson")
	public @ResponseBody String addPerson(@RequestBody Paper p) {
		
		int oldpaperid = p.getPaperid();
//		PapermappingExample pme = new PapermappingExample();
//		com.neuedu.entity.PapermappingExample.Criteria c1 = pme.createCriteria();
//		c1.andPaperidEqualTo(oldpaperid);
//		c1.andExamineeEqualTo(p.getExaminee());
//		List<Papermapping> list =  papermappingMapper.selectByExample(pme);
		Papermapping pam = new Papermapping();
		pam.setPaperid(oldpaperid);
		pam.setExaminee(p.getExaminee());
		pam = papermappingMapper.getMappingexcit(pam);
		if(pam!=null) {
			return "excited";
		}
		int newpaperid =paperService.publishPaper(p);
		Papermapping pm = new Papermapping();
		pm.setUserpaperid(newpaperid);
		pm.setPaperid(oldpaperid);
		pm.setExaminee(p.getExaminee());
		pm.setType(0);
		papermappingMapper.insert(pm);
		
		return "";
	}
	
	
	
	
	
	
	
	@RequestMapping("/copypaper")
	public @ResponseBody String copyPaper(@RequestBody Paper p,HttpServletRequest request) {
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid = currentUser.getUserid();
//		System.out.println(userid+"@@@@@@@@@@");
		User u = new User();
		u.setUserid(userid);
		
		int oldpaperid = p.getPaperid();
		Paper old = new Paper();
		old.setPaperid(oldpaperid);
		p= paperService.selectPaperbyId(p.getPaperid());
		p.setInvitationcode(null);
		p.setPaperid(0);
		p.setPapername(p.getPapername()+"_副本");
//		System.out.println(u.getUserid()+"@@@@@@@@@@");
		List<Paper> list = paperService.selectAllPaperByTeacher(u);
		
		for(Paper p1:list) {
			
			if(p1.getPapername().equals(p.getPapername())) {
				
				p.setPapername(p.getPapername()+"_副本");
			}
		}
		
		
		paperService.addPaper(p);
		int newpaperid = p.getPaperid();
		List<Paper_fill> filllist = paper_fillService.getAllbyPaperid(old);
		for(Paper_fill pf :filllist) {
			pf.setqId(null);
	
			pf.setPaperid(newpaperid);
			paper_fillService.addPaper_fill(pf);
			int qid = pf.getqId();
			for(Paper_fillchoice pfc:pf.getFilllist()) {
				pfc.setChoiceid(0);
				pfc.setqId(qid);
				paper_fillchoiceService.addPaper_fillchoice(pfc);
				
			}
		}
		
		List<Paper_single> singlelist = paper_singleService.getAllbyPaperid(old);
		for(Paper_single ps :singlelist) {
			ps.setqId(null);
	
			ps.setPaperid(newpaperid);
			 
			paper_singleService.addPaper_single(ps);
			int qid = ps.getqId();
			for(Paper_singlechoice psc:ps.getSinglelist()) {
				psc.setChoiceid(0);
				psc.setqId(qid);
				paper_singlechoiceService.addPaper_singlechoice(psc);
				
			}
		}
		
		List<Paper_multiple> multiplelist = paper_multipleService.getAllbyPaperid(old);
		
		for(Paper_multiple ps :multiplelist) {
			ps.setqId(null);
			
			ps.setPaperid(newpaperid);
			paper_multipleService.addPaper_multiple(ps);
			int qid = ps.getqId();
			for(Paper_multiplechoice psc:ps.getMultiplelist()) {
				psc.setChoiceid(0);
				psc.setqId(qid);
				paper_multiplechoiceService.addPaper_multiplechoice(psc);
				
			}
		}
		
		
		List<Paper_judge> judgelist = paper_judgeService.getAllbyPaperid(old);

		for(Paper_judge ps :judgelist) {
			ps.setqId(null);
		
			ps.setPaperid(newpaperid);
			paper_judgeService.addPaper_judge(ps);
			
		}
		
		List<Paper_shortanswer> shortanswerlist = paper_shortanswerService.getAllbyPaperid(old);
		for(Paper_shortanswer ps :shortanswerlist) {
			ps.setqId(null);
		
			ps.setPaperid(newpaperid);
			paper_shortanswerService.addPaper_shortanswer(ps);
			int qid =  ps.getqId();
			for(Paper_shortanswer_pic psp:ps.getShortpiclist()) {
				
				psp.setqId(qid);
				paper_shortanswer_picService.addPaper_shortanswer_pic(psp);
				
			}
			for(Paper_shortanswer_mov psv:ps.getShortmovlist()) {
				
				psv.setqId(qid);
				paper_shortanswer_movService.addPaper_shortanswer_mov(psv);
				
			}
		}
		return "";
	}
		
	
	
	
	
	
	
	
	
	

	
	@RequestMapping("/toSmartAdd")
	public String toSmartAdd(@RequestParam Integer paperid,HttpServletRequest req) {
//		User u=new User();
//		u.setUserid(1);
//		List<Bankfolder> forders=bankforderService.getAllbyUserid(u);
		//List<Bank> banks=bankService.getAllByFolderid(bf);
		req.getSession().setAttribute("smartpaperid", paperid);
		return "teacherPaper/smartAdd";
	}

//	@RequestMapping("/smartFolderList")
//	public void smartFolderList(HttpServletResponse res) throws IOException {
//		//System.out.println("inController");
//		int userid=1;
//		User u=new User();
//		u.setUserid(userid);
//		ArrayList<TreeFolder> tflist=bankforderService.getAllArrayForFolder(u);	
//		JSONObject jo=new JSONObject();
//		//System.out.println("Json"+JSONArray.fromObject(tflist));
//		jo.put("files", tflist);
//		String jsonString = JSONArray.toJSONString(jo);
//		res.setCharacterEncoding("UTF-8");
//		System.out.println(jsonString);
//		res.getWriter().println(jsonString);
//	}
	
	@RequestMapping("/smartFolderList")
	public void smartFolderList(HttpServletRequest request,HttpServletResponse res) throws IOException {
		//System.out.println("inController");
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid=currentUser.getUserid();
		User u=new User();
		u.setUserid(userid);
		ArrayList<TreeFolder> tflist=bankforderService.getAllArrayForFolder(u);	
		JSONObject jo=new JSONObject();
		//System.out.println("Json"+JSONArray.fromObject(tflist));
		jo.put("files", tflist);
		String jsonString = JSONArray.toJSONString(jo);
		res.setCharacterEncoding("UTF-8");
		System.out.println(jsonString);
		res.getWriter().println(jsonString);
	}
	
//	@RequestMapping("/smartBankList")
//	public void smartBankList(HttpServletResponse res) throws IOException {
//		//System.out.println("inController");
//		int userid=1;
//		User u=new User();
//		u.setUserid(userid);
//		ArrayList<TreeFolder> tflist=bankforderService.getAllArrayForFolder(u);	
//		List<Bank> bk=new ArrayList<Bank>();
//		List<Bank> bklist=new ArrayList<Bank>();
//		for(int i=0;i<tflist.size();i++) {
//			Bankfolder bf=new Bankfolder();
//			bf.setFolderid(tflist.get(i).getId());
//			bk=bankService.getAllByFolderid(bf);
//			for(Bank b:bk) {
//				bklist.add(b);
//			}
//		}
//		Map<String, List> map=new LinkedHashMap<String, List>();
//		map.put("bklist",bklist);
//		String jsonString = JSONArray.toJSONString(map);
//		res.setCharacterEncoding("UTF-8");
//		System.out.println(jsonString);
//		res.getWriter().println(jsonString);
//	}
	
	@RequestMapping("/getSmartKnowledge")
	@ResponseBody
	public void getSmartKnowledge(@RequestBody JSONObject obj,HttpServletResponse res,HttpServletRequest req) throws IOException {
			 JSONArray bankid = obj.getJSONArray("bankid");
			 List<Bank> banks=new ArrayList<>();
			 for(int i=0;i<bankid.size();i++) {
				 //System.out.println(bankid.get(i));
				 Bank bank=new Bank();
				 bank.setBankid((Integer)bankid.get(i));
				 banks.add(bankService.selectBankByID(bank));
			 }
			 HashMap<String, Integer> fill=paperService.getFillKnowledgeAndNumber(banks);
			 HashMap<String, Integer> judge= paperService.getJudgeKnowledgeAndNumber(banks);
			 HashMap<String, Integer> multiple=paperService.getMutipleKnowledgeAndNumber(banks);
			 HashMap<String, Integer> single=paperService.getSingleKnowledgeAndNumber(banks);
			 HashMap<String, Integer> shortanswer= paperService.getShortanswerKnowledgeAndNumber(banks);
			 Object json1 = JSON.toJSONString(fill);
			 HashMap<String, List<Knowledge>> all=new HashMap<>();
			 List<Knowledge> si=new ArrayList<>();
			 for(String key:single.keySet()) {
				 Knowledge k=new Knowledge(key, single.get(key));
				// System.out.println(k.getName());
				 si.add(k);
			 }
			 all.put("single", si);
			 List<Knowledge> f=new ArrayList<>();
			 for(String key:fill.keySet()) {
				 Knowledge k=new Knowledge(key, fill.get(key));
				 f.add(k);
			 }
			 all.put("fill", f);
			 List<Knowledge> j=new ArrayList<>();
			 for(String key:judge.keySet()) {
				 Knowledge k=new Knowledge(key, judge.get(key));
				 j.add(k);
			 }
			 all.put("judge", j);
			 List<Knowledge> m=new ArrayList<>();
			 for(String key:multiple.keySet()) {
				 Knowledge k=new Knowledge(key, multiple.get(key));
				 m.add(k);
			 }
			 all.put("multiple", m);
			 List<Knowledge> sh=new ArrayList<>();
			 for(String key:shortanswer.keySet()) {
				 Knowledge k=new Knowledge(key, shortanswer.get(key));
				 sh.add(k);
			 }
			 all.put("shortanswer", sh);
			 Object json=JSON.toJSONString(all);
			 res.setContentType("text/html;charset=utf-8");
			 res.getWriter().print(json);   
	}
	@RequestMapping("/makesmartpaper")
	public void makesmartpaper(@RequestBody JSONObject obj,HttpServletResponse res,HttpServletRequest req) throws IOException {
		 JSONArray bankid = obj.getJSONArray("bankid");
		 List<Bank> banks=new ArrayList<>();
		 for(int i=0;i<bankid.size();i++) {
			// System.out.println(bankid.get(i));
			 Bank bank=new Bank();
			 bank.setBankid((Integer)bankid.get(i));
			 banks.add(bankService.selectBankByID(bank));
		 }
		 //得到出各类题的分数
		 JSONArray score = obj.getJSONArray("score");
		 List<Integer> scores=new ArrayList<>();
		 for(int i=0;i<5;i++) {
			 scores.add((Integer) score.get(i));
			// System.out.println(score.get(i));
		 }
		 //得到选择题知识点等信息
		 JSONArray singleknowledge = obj.getJSONArray("singleknowledge");
		 JSONArray singlenumber = obj.getJSONArray("singlenumber");
		 HashMap<String, Integer> singlehashmap=new HashMap<>();
		 for(int i=0;i<singleknowledge.size();i++) {
			 String name=(String)singleknowledge.get(i);
			 String number=(String)singlenumber.get(i);
			 Integer n=Integer.parseInt(number);
			 singlehashmap.put(name, n);
		 }
		 //得到多选题知识点等信息
		 JSONArray multipleknowledge = obj.getJSONArray("multipleknowledge");
		 JSONArray multiplenumber = obj.getJSONArray("multiplenumber");
		 HashMap<String, Integer> multiplehashmap=new HashMap<>();
		 //System.out.println(multipleknowledge.size());
		 for(int i=0;i<multipleknowledge.size();i++) {
			 String name=(String)multipleknowledge.get(i);
			 String number=(String)multiplenumber.get(i);
			 Integer n=Integer.parseInt(number);
			 multiplehashmap.put(name, n);
		 }
		 //得到填空题知识点等信息
		 JSONArray fillknowledge = obj.getJSONArray("fillknowledge");
		 JSONArray fillnumber = obj.getJSONArray("fillnumber");
		 HashMap<String, Integer> fillhashmap=new HashMap<>();
		 for(int i=0;i<fillknowledge.size();i++) {
			 String name=(String)fillknowledge.get(i);
			 String number=(String)fillnumber.get(i);
			 Integer n=Integer.parseInt(number);
			 fillhashmap.put(name, n);
		 }
		 //得到判断题知识点等信息
		 JSONArray judgeknowledge = obj.getJSONArray("judgeknowledge");
		 JSONArray judgenumber = obj.getJSONArray("judgenumber");
		 HashMap<String, Integer> judgehashmap=new HashMap<>();
		 for(int i=0;i<judgeknowledge.size();i++) {
			 String name=(String)judgeknowledge.get(i);
			 String number=(String)judgenumber.get(i);
			 Integer n=Integer.parseInt(number);
			 judgehashmap.put(name, n);
		 }
		 //得到简答题知识点等信息
		 JSONArray shortanswerknowledge = obj.getJSONArray("shortanswerknowledge");
		 JSONArray shortanswernumber = obj.getJSONArray("shortanswernumber");
		 HashMap<String, Integer> shortanswerhashmap=new HashMap<>();
		 for(int i=0;i<shortanswerknowledge.size();i++) {
			 String name=(String)shortanswerknowledge.get(i);
			 String number=(String)shortanswernumber.get(i);
			 Integer n=Integer.parseInt(number);
			 shortanswerhashmap.put(name, n);
		 }
		 //假数据
		 User currentUser = (User) req.getSession().getAttribute("currentUser");
		 int userid = currentUser.getUserid();
		 User user=new User();
		 user.setUserid(userid);
		 Paper paper=new Paper();
		 paper.setPapername((String)req.getSession().getAttribute("smartpapername"));
		 paper.setPaperid(null);
		 paper.setWinder(user.getUserid());
		 paper.setSinglenum(0);
		 paper.setMultiplenum(0);
		 paper.setFillnum(0);
		 paper.setShortanswernum(0);
		 paper.setJudgenum(0);
		 paper.setQuestionnum(0);
		 Integer paperid=(Integer)req.getSession().getAttribute("smartpaperid");
		 paper.setPaperid(paperid);
		 paperService.updateByPaperId(paper);
		 paperService.intelligentSinglePaper(singlehashmap, scores.get(0), banks, paper);
		 paperService.intelligentMultiplePaper(multiplehashmap, scores.get(1), banks, paper);
		 paperService.intelligentFillPaper(fillhashmap, scores.get(2), banks, paper);
		 paperService.intelligentJudgePaper(judgehashmap, scores.get(3), banks, paper);
		 paperService.intelligentShortanswerPaper(shortanswerhashmap, scores.get(4), banks, paper);
		 Object json=JSON.toJSONString(paper.getPaperid());
		 res.setContentType("text/html;charset=utf-8");
		 res.getWriter().print(json);
	}
	

	
}
