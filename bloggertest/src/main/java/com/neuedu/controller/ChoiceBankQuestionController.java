package com.neuedu.controller;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_fill;
import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.entity.Bank_judge;
import com.neuedu.entity.Bank_multiple;
import com.neuedu.entity.Bank_multiplechoice;
import com.neuedu.entity.Bank_shortanswer;
import com.neuedu.entity.Bank_shortanswer_mov;
import com.neuedu.entity.Bank_shortanswer_pic;
import com.neuedu.entity.Bank_single;
import com.neuedu.entity.Bank_singlechoice;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_fillchoice;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_shortanswer_mov;
import com.neuedu.entity.Paper_shortanswer_pic;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Paper_singlechoice;
import com.neuedu.service.BankService;
import com.neuedu.service.Bank_fillService;
import com.neuedu.service.Bank_judgeService;
import com.neuedu.service.Bank_multipleService;
import com.neuedu.service.Bank_shortanswerService;
import com.neuedu.service.Bank_singleService;
import com.neuedu.service.Garbage_bankService;
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
import com.neuedu.service.Shop_bankService;

@Controller
public class ChoiceBankQuestionController {

	@Autowired
	BankService bankService;
	@Autowired
	Bank_fillService bank_fillService;
	
	@Autowired
	Bank_multipleService bank_multipleService;
	
	@Autowired
	Bank_singleService bank_singleService;
	
	@Autowired
	Bank_shortanswerService bank_shortanswerService;
	
	@Autowired
	Shop_bankService shop_bankService;
	
	@Autowired
	Bank_judgeService bank_judgeService;
	
	@Autowired
	Garbage_bankService garbage_bankService;
	@Autowired
	Paper_singleService paper_singleService;
	@Autowired
	Paper_singlechoiceService paper_singlechoiceService;
	@Autowired
	Paper_multipleService paper_multipleService;
	@Autowired
	Paper_multiplechoiceService paper_multiplechoiceService;
	@Autowired
	Paper_judgeService paper_judgeService;
	@Autowired
	Paper_fillService paper_fillService;
	@Autowired
	Paper_fillchoiceService paper_fillchoiceService;
	@Autowired
	Paper_shortanswerService paper_shortanswerService;
	@Autowired
	Paper_shortanswer_movService paper_shortanswer_movService;
	@Autowired
	Paper_shortanswer_picService paper_shortanswer_picService;
	@Autowired
	PaperService paperService;
  @RequestMapping("/toPapersourceBank")
  public String toPapersourceBank(@RequestParam Integer paperid,HttpServletRequest req) {
	  Paper paper=paperService.selectPaperbyId(paperid);
	  req.getSession().setAttribute("currentPaper1", paper);
	return "teacherPaper/papersourceBank";
	  
  }
  @RequestMapping("/chookseBankAndLoad")
  public void chookseBankAndLoad(@RequestBody JSONObject obj,HttpServletResponse res) throws IOException {
	  
	  Integer bankid=Integer.parseInt((String)obj.get("bankid"));
	  Bank b=new Bank();
	  b.setBankid(bankid);
	  //通过bankid查找bank
	  Bank selectBankByID = bankService.selectBankByID(b);
	  //查找到单选题
	  List<Bank_single> singles = bank_singleService.getAllbyBankid(selectBankByID);
	  //查找多选题
	  List<Bank_multiple> multiples = bank_multipleService.getAllbyBankid(selectBankByID);
	  //查找填空题
	  List<Bank_fill> fills = bank_fillService.getAllbyBankid(selectBankByID);
	  //查找判断题
	  List<Bank_judge> judges = bank_judgeService.getAllbyBankid(selectBankByID);
	  //查找简答题
	  List<Bank_shortanswer> shortanswers= bank_shortanswerService.getAllbyBankid(selectBankByID);
		Map<String,List> map=new LinkedHashMap<String,List>();
		map.put("singles", singles);
		map.put("multiples",multiples);
		//多项选择
		
		map.put("judges", judges);
		map.put("fills", fills);
		map.put("shortanswers", shortanswers);
		Object json = JSON.toJSONString(map);
		res.setCharacterEncoding("utf-8");
		res.getWriter().print(json);
		return;
  }
  @RequestMapping("/AddChoicedQuestion")
  public void AddChoicedQuestion(@RequestBody JSONObject obj,HttpServletResponse res,HttpServletRequest req) throws IOException {
	  Paper p = (Paper) req.getSession().getAttribute("currentPaper1");
	  Integer paperid=p.getPaperid();
	  //获得并添加单选题
	     JSONArray singleData = obj.getJSONArray("singledata");
	     System.out.println("单选题:"+ singleData);
	     for(int i=0;i<singleData.size();i++) {
	    	 Integer questionId=Integer.parseInt((String)singleData.get(i));
	    	 Bank_single bf=new Bank_single();
	    	 bf.setqId(questionId);
	    	 Bank_single selectBank_single = bank_singleService.selectBank_single(bf);
	    	 Paper_single newSingle=new Paper_single();
	    	 Integer difficult = selectBank_single.getqDifficulty();
	    	 Integer scoreInteger=0;
	    	 if(difficult==0) {
	    		 scoreInteger=2;
	    	 }
	    	 else if(difficult==1) {
	    		 scoreInteger=3;
	    	 }else if(difficult==2) {
	    		 scoreInteger=5;
	    	 }
	    	 newSingle.setqScore(scoreInteger);
	    	 newSingle.setPaperid(paperid);
	    	 newSingle.setqAnalysis(selectBank_single.getqAnalysis());
	    	 newSingle.setqDifficulty(selectBank_single.getqDifficulty());
	    	 newSingle.setqKnowledge(selectBank_single.getqKnowledge());
	    	 newSingle.setqTitle(selectBank_single.getqTitle());
	    	 int addPaper_single = paper_singleService.addPaper_single(newSingle);
	    	 Integer qId = newSingle.getqId();
	    	 
	    	 //获得选项
	    	 List<Bank_singlechoice> singlelist = selectBank_single.getSinglelist();
	    	 for(int j=0;j<singlelist.size();j++) {
	    		 Bank_singlechoice old=new Bank_singlechoice();
	    		 Paper_singlechoice newChoice=new Paper_singlechoice();
	    		 newChoice.setContent(old.getContent());
	    		 newChoice.setPicture(old.getPicture());
	    		 newChoice.setqId(qId);
	    		 newChoice.setSequence(old.getSequence());
	    		 newChoice.setType(old.getType());
	    		 paper_singlechoiceService.addPaper_singlechoice(newChoice); 
	    	 }
	    	 
	    	
	    	 
	     }
	     
	      //获得并添加多选题
	     JSONArray multipleData = obj.getJSONArray("multipledata");
	      System.out.println("多选题:"+ multipleData);
	      for(int i=0;i<multipleData.size();i++) {
		    	 Integer questionId=Integer.parseInt((String)multipleData.get(i));
		    	 Bank_multiple bf=new Bank_multiple();
		    	 bf.setqId(questionId);
		    	 Bank_multiple selectbank_multiple = bank_multipleService.selectBank_multiple(bf);
		    	 Paper_multiple newMultiple=new Paper_multiple();
		    	 Integer difficult = selectbank_multiple.getqDifficulty();
		    	 Integer scoreInteger=0;
		    	 if(difficult==0) {
		    		 scoreInteger=2;
		    	 }
		    	 else if(difficult==1) {
		    		 scoreInteger=3;
		    	 }else if(difficult==2) {
		    		 scoreInteger=5;
		    	 }
		    	 newMultiple.setqScore(scoreInteger);
		    	 newMultiple.setPaperid(paperid);
		    	 newMultiple.setqAnalysis(selectbank_multiple.getqAnalysis());
		    	 newMultiple.setqDifficulty(selectbank_multiple.getqDifficulty());
		    	 newMultiple.setqKnowledge(selectbank_multiple.getqKnowledge());
		    	 newMultiple.setqTitle(selectbank_multiple.getqTitle());
		    	 int addPaper_multiple = paper_multipleService.addPaper_multiple(newMultiple);
		    	 Integer qId = newMultiple.getqId();
		    	 
		    	 //获得选项
		    	 List<Bank_multiplechoice> multiplelist = selectbank_multiple.getMultiplelist();
		    	 for(int j=0;j<multiplelist.size();j++) {
		    		 Bank_multiplechoice old=new Bank_multiplechoice();
		    		 Paper_multiplechoice newChoice=new Paper_multiplechoice();
		    		 newChoice.setContent(old.getContent());
		    		 newChoice.setPicture(old.getPicture());
		    		 newChoice.setqId(qId);
		    		 newChoice.setSequence(old.getSequence());
		    		 newChoice.setType(old.getType());
		    		
		    		 paper_multiplechoiceService.addPaper_multiplechoice(newChoice);
		    	 }
		    	 
		    	
		    	 
		     }
		     //获得并添加判断题
	      JSONArray judgeData = obj.getJSONArray("judgedata");  
	      for(int i=0;i<judgeData.size();i++) {
	    	  Integer questionId=Integer.parseInt((String)judgeData.get(i));
	    	  Bank_judge bf=new Bank_judge();
	    	  bf.setqId(questionId);
	    	  Bank_judge selectBank_judge = bank_judgeService.selectBank_judge(bf);
	    	  Paper_judge newJudge=new Paper_judge();
	    	  Integer difficult = selectBank_judge.getqDifficulty();
		    	 Integer scoreInteger=0;
		    	 if(difficult==0) {
		    		 scoreInteger=2;
		    	 }
		    	 else if(difficult==1) {
		    		 scoreInteger=3;
		    	 }else if(difficult==2) {
		    		 scoreInteger=5;
		    	 }
		    	 newJudge.setqScore(scoreInteger);
	    	  newJudge.setIsture(selectBank_judge.getIsture());
	    	  newJudge.setqAnalysis(selectBank_judge.getqAnalysis());
	    	  newJudge.setqDifficulty(selectBank_judge.getqDifficulty());
	    	  newJudge.setqKnowledge(selectBank_judge.getqKnowledge());
	    	  newJudge.setqTitle(selectBank_judge.getqTitle());
	    	  newJudge.setIsture(selectBank_judge.getIsture());
	    	  paper_judgeService.addPaper_judge(newJudge);
	     }
	      //获得并添加填空题
	     JSONArray fillData=obj.getJSONArray("filldata");
	     for(int i=0;i<fillData.size();i++) {
	    	 Integer questionId=Integer.parseInt((String)fillData.get(i));
	    	 Bank_fill bf=new Bank_fill();
	    	 bf.setqId(questionId);
	    	 Bank_fill selectBank_fill = bank_fillService.selectBank_fill(bf);
	    	 Paper_fill newFill=new Paper_fill();
	    	 Integer difficult = selectBank_fill.getqDifficulty();
	    	 Integer scoreInteger=0;
	    	 if(difficult==0) {
	    		 scoreInteger=1;
	    	 }
	    	 else if(difficult==1) {
	    		 scoreInteger=2;
	    	 }else if(difficult==2) {
	    		 scoreInteger=4;
	    	 }
	    	 newFill.setqScore(scoreInteger);
	    	 newFill.setqDifficulty(selectBank_fill.getqDifficulty());
	    	 newFill.setqAnalysis(selectBank_fill.getqAnalysis());
	    	 newFill.setqKnowledge(selectBank_fill.getqKnowledge());
	    	 newFill.setqTitle(selectBank_fill.getqTitle());
	    	 int addPaper_fill = paper_fillService.addPaper_fill(newFill);
	    	 Integer qId=newFill.getqId();
	    	 List<Bank_fillchoice> filllsit = selectBank_fill.getFilllsit();
	    	 for(int j=0;j<filllsit.size();j++) {
	    		 Bank_fillchoice old=new Bank_fillchoice();
	    		 Paper_fillchoice newChoice=new Paper_fillchoice();
	    		 newChoice.setContent(old.getContent());
	    		 newChoice.setqId(qId);
	    		 newChoice.setSequence(old.getSequence());
	    		 newChoice.setqId(qId);
	    		 paper_fillchoiceService.addPaper_fillchoice(newChoice);
	    		 
	    	 }
	    	 
	    	 
	    	
	    	 
	    	 
	     }
	     //获得并添加简答题
	      JSONArray shortanswerData = obj.getJSONArray("shortanswerdata");  
	      for(int i=0;i<shortanswerData.size();i++) {
	    	  Integer questionId=Integer.parseInt((String)shortanswerData.get(i));
	    	  Bank_shortanswer bf=new Bank_shortanswer();
	    	  bf.setqId(questionId);
	    	  Bank_shortanswer selectBank_shortanswer = bank_shortanswerService.selectBank_shortanswer(bf);
	    	  Paper_shortanswer newshortanswer=new Paper_shortanswer();
	    	  Integer difficult = selectBank_shortanswer.getqFifficulty();
		    	 Integer scoreInteger=0;
		    	 if(difficult==0) {
		    		 scoreInteger=5;
		    	 }
		    	 else if(difficult==1) {
		    		 scoreInteger=7;
		    	 }else if(difficult==2) {
		    		 scoreInteger=10;
		    	 }
		      newshortanswer.setqScore(scoreInteger);
		      newshortanswer.setqAnalysis(selectBank_shortanswer.getqAnalysis());
	    	  newshortanswer.setqFifficulty(selectBank_shortanswer.getqFifficulty());
	    	  newshortanswer.setqKnowledge(selectBank_shortanswer.getqKnowledge());
	    	  newshortanswer.setqTitle(selectBank_shortanswer.getqTitle());
	    	  int addPaper_shortanswer = paper_shortanswerService.addPaper_shortanswer(newshortanswer);
	    	  Integer qId=newshortanswer.getqId();
	    	  if(selectBank_shortanswer.getShortmovlist()!=null) {
	    	  for(int j=0;j<selectBank_shortanswer.getShortmovlist().size();j++) {
	    		  Bank_shortanswer_mov bank_shortanswer_mov = selectBank_shortanswer.getShortmovlist().get(i);
	    		  Paper_shortanswer_mov newMov=new Paper_shortanswer_mov();
	    		  newMov.setMovie(bank_shortanswer_mov.getMovie());
	    		  newMov.setqId(qId);
	    		  paper_shortanswer_movService.addPaper_shortanswer_mov(newMov);
	    	  
	    	  }}
	    	  if(selectBank_shortanswer.getShortpiclist()!=null) {
	    	  for(int j=0;j<selectBank_shortanswer.getShortpiclist().size();j++) {
	    		  Bank_shortanswer_pic bank_shortanswer_pic = selectBank_shortanswer.getShortpiclist().get(i);
	    		  Paper_shortanswer_pic newPic=new Paper_shortanswer_pic();
	    		  newPic.setPicture(bank_shortanswer_pic.getPicture());
	    		  newPic.setqId(qId);
	    		  paper_shortanswer_picService.addPaper_shortanswer_pic(newPic);
	    		  
	    	  }
	    	  }
	    	  
	    	 
	    	  
	    	
	     }
	      res.getWriter().print("1");
	    
	    
	  
	  
  }

}
