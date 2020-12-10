package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.dao.PapermappingMapper;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_fillchoice;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_multiplechoice;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_shortanswer_mov;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.Paper_singlechoice;
import com.neuedu.entity.Papermapping;
import com.neuedu.entity.PapermappingExample;
import com.neuedu.entity.PapermappingExample.Criteria;
import com.neuedu.entity.User;
import com.neuedu.service.ExamService;
import com.neuedu.service.PaperService;
import com.neuedu.service.Paper_fillService;
import com.neuedu.service.Paper_fillchoiceService;
import com.neuedu.service.Paper_judgeService;
import com.neuedu.service.Paper_multipleService;
import com.neuedu.service.Paper_shortanswerService;
import com.neuedu.service.Paper_singleService;
import com.neuedu.service.UserService;

@Controller
public class ExamController {
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
	ExamService examService;
	@Autowired
	UserService userService;
	@Autowired
	PapermappingMapper papermappingMapper;
	
//	@RequestMapping("/getExamingPaper")
//	public String getExamingPaper(HttpServletRequest request ) {
//		
//		User currentUser = (User) request.getSession().getAttribute("currentUser");
//		User user=new User();
//		user.setUserid(currentUser.getUserid());
//		List<Paper> papers=examService.getExamingPaper(user);
////		System.out.println(papers.size());
////		for(Paper paper:papers) {
////			System.out.println(paper.getPapername());
////		}
//		return "teacherPaper/test";
//	}
//	@RequestMapping("/getExamdonePaper")
//	public String getExamdonePaper( HttpServletRequest request) {
//		User currentUser = (User) request.getSession().getAttribute("currentUser");
//		User user=new User();
//		user.setUserid(currentUser.getUserid());
//		List<Paper> papers=examService.getExamdonePaper(user);
////		System.out.println(papers.size());
////		for(Paper paper:papers) {
////			System.out.println(paper.getPapername());
////		}
//		return "teacherPaper/test";
//	}
//	@RequestMapping("/getundonePaper")
//	public String getundoneExam() {
//		User user=new User();
//		user.setUserid(1);
//		List<Paper> papers=examService.getExamdonePaper(user);
////		System.out.println(papers.size());
////		for(Paper paper:papers) {
////			System.out.println(paper.getPapername());
////		}
//		return "teacherPaper/test";
//	}
//	//得到参与考试的考生试卷
//	@RequestMapping("/getExamresults")
//	public String getExamresults() {
//		Paper paper=new Paper();
//		paper.setPaperid(6001);
//		List<Paper> papers=examService.getExamineePapers(paper);
//		for(Paper p:papers) {
//			System.out.println(p.getPaperid());
//		}
//		return "teacherPaper/test";
//	}
//	//自动判单选题 paper为教师试卷paper
//	@RequestMapping("/singleAutocheck")
//	public String singleAutocheck() {
//		Paper paper=new Paper();
//		paper.setPaperid(6001);
//		List<Paper> papers=examService.getExamineePapers(paper);
//		for(Paper p:papers) {
//			examService.autoCheckSingle(p);
//		}
//		return "teacherPaper/test";
//	}
//	//自动判多选题 paper为教师试卷paper
//	@RequestMapping("/mutipleAutocheck")
//	public String mutipleAutocheck() {
//		Paper paper=new Paper();
//		paper.setPaperid(6001);
//		List<Paper> papers=examService.getExamineePapers(paper);
//		for(Paper p:papers) {
//			examService.autoCheckMutiple(p);
//		}
//		return "teacherPaper/test";
//	}
//	//自动判判断题 paper为教师试卷paper
//	@RequestMapping("/judgeAutocheck")
//	public String judgeAutocheck() {
//		Paper paper=new Paper();
//		paper.setPaperid(6001);
//		List<Paper> papers=examService.getExamineePapers(paper);
//		for(Paper p:papers) {
//			examService.autoCheckJudge(p);
//		}
//		return "teacherPaper/test";
//	}
//	//判填空题 paper为教师试卷paper(根据前端的传值 待完成）
//	@RequestMapping("/fillAutocheck")
//	public String fillAutocheck() {
//		Paper paper=new Paper();
//		paper.setPaperid(6001);
//		List<Paper> papers=examService.getExamineePapers(paper);
//		for(Paper p:papers) {
//			paper_fillService.getAllbyPaperid(p);
//		}
//		return "teacherPaper/test";
//	}
//	//判简答题 paper为教师试卷paper（根据前端的传值 待完成）
//	@RequestMapping("/shortanswerAutocheck")
//	public String shortanswerAutocheck() {
//		Paper paper=new Paper();
//		paper.setPaperid(6001);
//		List<Paper> papers=examService.getExamineePapers(paper);
//		for(Paper p:papers) {
////			paper_shortans
//		}
//		return "teacherPaper/test";
//	}
//	//合分
	@RequestMapping("/getsumscore")
	public void getsumscore(@RequestParam(value="paperid",required=false) Integer paperid,HttpServletResponse response) throws IOException {
		Paper paper=new Paper();
		paper.setPaperid(paperid);
		int p=examService.getExamScore(paper);
		Papermapping pm=new Papermapping(); 
		Papermapping rpm = papermappingMapper.selectByPrimaryKey(paperid);
		Integer fatherpaperid = rpm.getPaperid();
		response.getWriter().print(fatherpaperid);
		//System.out.println(p);
		
	}
//	@RequestMapping("/toStudentupload")
//	public String toStudentupload() {
//		return "teacherPaper/upload";
//	}
//	@RequestMapping("/toStudentdownload")
//	public String toStudentdownload() {
//		Paper p=new Paper();
//		p.setPaperid(6001);
//		HashMap<String, Integer> result=examService.getExamResult(p);
////		for(String key:result.keySet()) {
////			System.out.println("key"+key+"value"+result.get(key));
////		}
//		return "teacherPaper/test";
//	}
//	@RequestMapping("/tofillresult")
//	public String tofillresult() {
//		Paper p=new Paper();
//		p.setPaperid(6001);
//		HashMap<Paper_fill, Integer> result=examService.getfillResult(p);
//		for(Paper_fill key:result.keySet()) {
//			System.out.println("key"+key.getqTitle()+"value"+result.get(key));
//		}
//		return "teacherPaper/test";
//	}
//	@RequestMapping("/tosingleresult")
//	public String tosingleresult() {
//		Paper p=new Paper();
//		p.setPaperid(6001);
//		HashMap<Paper_single, List<Integer>> result=examService.getsingleResult(p);
//		for(Paper_single key:result.keySet()) {
//			System.out.println("key"+key.getqTitle()+"value"+result.get(key));
//		}
//		return "teacherPaper/test";
//	}
	
	@RequestMapping("/tocorrectPage")
	public String tocorrentPage(@RequestParam(value="paperid",required=false) Integer paperid,Model model) {
		Paper paper=new Paper();
		paper.setPaperid(paperid);
        Paper repaper = paperService.selectPaperbyId(paperid);
        User u=new User();
        u.setUserid(repaper.getExaminee());
        User examinee=userService.selectUserByPrimaryKey(u);
        repaper.setExamineer(examinee);
        List<Paper_fill> Paperfills = paper_fillService.getAllbyPaperid(paper);
        List<Paper_shortanswer> Papershortanswers = paper_shortanswerService.getAllbyPaperid(paper);
       
        model.addAttribute("paper", repaper);
        model.addAttribute("fills", Paperfills);
        model.addAttribute("shortanswers", Papershortanswers);
		return "teacherPaper/correctPage";
	}
	
	
	@RequestMapping("/touncorrectPaper")
	public String touncorrectPaper(@RequestParam(value="paperid",required=false) Integer paperid,Model model) {
		//User currentUser = (User) request.getSession().getAttribute("currentUser");


        PapermappingExample papermappingexample=new PapermappingExample();
        Criteria c1 = papermappingexample.createCriteria();
        c1.andPaperidEqualTo(paperid);
        List<Papermapping> papermappings=papermappingMapper.selectByExample(papermappingexample);
        List<Paper> papers=new ArrayList<Paper>();
        for(int i=0;i<papermappings.size();i++)
        {
    		
        	Papermapping pm=papermappings.get(i);
        	Paper rp = paperService.selectPaperbyId(pm.getUserpaperid());
        	User examinee=new User();
        	examinee.setUserid(rp.getExaminee());
            User examineer = userService.selectUserByPrimaryKey(examinee);
            rp.setExamineer(examineer);
        	papers.add(rp);
        }
        model.addAttribute("uncorrectpapers",papers);
        
      //  model.addAttribute("shortanswers", Papershortanswers);
		return "teacherPaper/uncorrectPaper";
	}
	
	@RequestMapping("/setQscore")
	public void tocorrentPage(@RequestParam(value="questionid",required=false) Integer questionid,@RequestParam(value="type",required=false) Integer type,@RequestParam(value="score",required=false,defaultValue="0") Integer score,HttpServletResponse res) throws IOException {
		if(type==0)
		{
			Paper_fill fill=new Paper_fill();
			fill.setqId(questionid);
			fill.setExamineescore(score);
			paper_fillService.updatePaper_fill(fill);
		}
		if(type==1)
		{
			Paper_shortanswer shortanswer=new Paper_shortanswer();
			shortanswer.setqId(questionid);
			shortanswer.setExamineescore(score);
			paper_shortanswerService.updatePaper_shortanswer(shortanswer);
		}
        res.getWriter().print(score);
		return;
	}
	
	
	@RequestMapping("/tounpublishpaperinfo")
	public String topaperinfo(@RequestParam Integer paperid, Model m) {
		
		Paper paper=paperService.selectPaperbyId(paperid);
		m.addAttribute("paper", paper);
		List<Paper_single> singles=paper_singleService.getAllbyPaperid(paper);
		List<Paper_multiple> multiples=paper_multipleService.getAllbyPaperid(paper);
		List<Paper_fill> fills=paper_fillService.getAllbyPaperid(paper);
		List<Paper_judge> judges=paper_judgeService.getAllbyPaperid(paper);
		List<Paper_shortanswer> shortanswers=paper_shortanswerService.getAllbyPaperid(paper);
		Date date=paper.getBegintime();
		Date date2=paper.getEndtime();
		String datetime1="";
		String datetime2="";
		String datetime="";
		if(date==null) {
			datetime1="";
		}else {
			datetime1=String.valueOf(date);
		}
		if(date2==null) {
			datetime2="";
		}else {
			datetime2=String.valueOf(date2);
		}
		if(datetime1=="" && datetime2=="") {
			datetime="还未设定考试时间";
//			System.out.println("111");
		}else {
			datetime=datetime1+"至"+datetime2;
		}
		String type="";
		if(paper.getType1()==null) {
			
		}else {
			if(paper.getType1()==1) {
				type="公有";
			}else {
				type="私有";
			}
		}
		
		m.addAttribute("type", type);
		m.addAttribute("datetime", datetime);
		m.addAttribute("singles", singles);
		m.addAttribute("multiples", multiples);
		m.addAttribute("fills", fills);
		m.addAttribute("judges", judges);
		m.addAttribute("shortanswers", shortanswers);
		return "teacherPaper/unpublishpaperinfo";
	} 
	@RequestMapping("/topublishpaperinfo")
	public String topublishpaperinfo(@RequestParam Integer paperid, Model m) {
	
		Paper paper=paperService.selectPaperbyId(paperid);
		m.addAttribute("paper", paper);
		List<Paper_single> singles=paper_singleService.getAllbyPaperid(paper);
		List<Paper_multiple> multiples=paper_multipleService.getAllbyPaperid(paper);
		List<Paper_fill> fills=paper_fillService.getAllbyPaperid(paper);
		List<Paper_judge> judges=paper_judgeService.getAllbyPaperid(paper);
		List<Paper_shortanswer> shortanswers=paper_shortanswerService.getAllbyPaperid(paper);
		Date date=paper.getBegintime();
		Date date2=paper.getEndtime();
		String datetime1="";
		String datetime2="";
		String datetime="";
		if(date==null) {
			datetime1="";
		}else {
			datetime1=String.valueOf(date);
		}
		if(date2==null) {
			datetime2="";
		}else {
			datetime2=String.valueOf(date2);
		}
		if(datetime1=="" && datetime2=="") {
			datetime="还未设定考试时间";
//			System.out.println("111");
		}else {
			datetime=datetime1+"至"+datetime2;
		}
		String type="";
		if(paper.getType1()==null) {
			
		}else {
			if(paper.getType1()==1) {
				type="公有";
			}else {
				type="私有";
			}
		}
		

		//回答率
		HashMap<Paper_single, List<Integer> > singleschoosenum=examService.getsingleResult(paper);
		HashMap<Paper_multiple, List<Integer> > multiplesschoosenum=examService.getmultipleResult(paper);
		HashMap<Paper_judge, Integer > judgeschoosenum=examService.getjudgeResult(paper);
		HashMap<Paper_fill, Integer > fillschoosenum=examService.getfillResult(paper);
		HashMap<Paper_shortanswer, Integer > shortanswerschoosenum=examService.getshortanswerResult(paper);
		m.addAttribute("singleschoosenum", singleschoosenum);
		if(singleschoosenum!=null) {
			for(Paper_single s:singleschoosenum.keySet()) {
				List<Integer> x=singleschoosenum.get(s);
				int i=1;
				for(Paper_single sing:singles) {
					sing.setC1("正确人数"+x.get(0));
					if(s.getqId()==sing.getqId()) {
						//得到数值 singleschoosenum的选项
						for(Paper_singlechoice psc:sing.getSinglelist()) {
							psc.setC2(x.get(i));
//							psc.setC1();
							i++;
						}
					}
				}
			}
		}
		
		if(multiplesschoosenum!=null) {
			for(Paper_multiple s:multiplesschoosenum.keySet()) {
				List<Integer> x=multiplesschoosenum.get(s);
				int i=1;
				for(Paper_multiple sing:multiples) {
					sing.setC1("正确人数"+x.get(0));
					if(s.getqId()==sing.getqId()) {
						//得到数值 singleschoosenum的选项
						for(Paper_multiplechoice psc:sing.getMultiplelist()) {
							psc.setC2(x.get(i));
//							psc.setC1();
							i++;
						}
					}
				}
			}
		}
		if(judgeschoosenum!=null) {
			for(Paper_judge s:judgeschoosenum.keySet()) {
				int i=1;
				for(Paper_judge sing:judges) {
					if(s.getqId()==sing.getqId()) {
						sing.setC1("正确人数"+judgeschoosenum.get(s));
					}
				}
			}
		}
		if(fillschoosenum!=null) {
			for(Paper_fill s:fillschoosenum.keySet()) {
				int i=1;
				for(Paper_fill sing:fills) {
					if(s.getqId()==sing.getqId()) {
						sing.setC1("正确人数"+fillschoosenum.get(s));
					}
				}
			}
		}
		if(shortanswerschoosenum!=null) {
			for(Paper_shortanswer s:shortanswerschoosenum.keySet()) {
				int i=1;
				for(Paper_shortanswer sing:shortanswers) {
					if(s.getqId()==sing.getqId()) {
						sing.setC1("正确人数"+shortanswerschoosenum.get(s));
					}
				}
			}
		}
		
		m.addAttribute("type", type);
		m.addAttribute("datetime", datetime);
		m.addAttribute("singles", singles);
		m.addAttribute("multiples", multiples);
		m.addAttribute("fills", fills);
		m.addAttribute("judges", judges);
		m.addAttribute("shortanswers", shortanswers);
		m.addAttribute("multiplesschoosenum", multiplesschoosenum);
		m.addAttribute("judgeschoosenum", judgeschoosenum);
		m.addAttribute("fillschoosenum", fillschoosenum);
		m.addAttribute("shortanswerschoosenum", shortanswerschoosenum);
		return "teacherPaper/publishpaperinfo";
	}

}
