package com.neuedu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.excel.ExcelUtil;
import com.neuedu.excel.FillDTO;
import com.neuedu.excel.MemberDTO;
import com.neuedu.excel.StudentDTO;
import com.neuedu.service.BankService;
import com.neuedu.service.ExamService;
import com.neuedu.service.GroupsService;
import com.neuedu.service.PaperService;
import com.neuedu.service.UserService;
import com.neuedu.dao.PapermappingMapper;
import com.neuedu.entity.*;

import com.neuedu.excel.ChoiceDTO;
import com.neuedu.excel.ExamResult;

@Controller
public class ExcelController {
	
	@Autowired
	BankService bankService;
	@Autowired
	UserService userService;
	
	@Autowired
	GroupsService groupsService;
	@Autowired
	ExamService examService;
	@Autowired
	PaperService paperService;
	@Autowired
	PapermappingMapper papermappingMapper;
	
	@RequestMapping("/toexceltest")
	public String test1(){
		return "teacherBank/upload";
	}
	
	@RequestMapping("/setcurrent")
	public @ResponseBody String setcurrent(@RequestBody Bank b,HttpServletRequest request) {
//		System.out.println(b.getBankid()+"************");
		request.getSession().setAttribute("currentBankid", b.getBankid());
		
		return "";
	}
	
	
	
	//excel导入题库选择、判断
		@RequestMapping("/addChoiceByExcel")
		@ResponseBody
		public Object addChoiceByExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
			
			//从前台获得currentBankid
			int bankid = (int) request.getSession().getAttribute("currentBankid");
			
			
			List<Object> list = ExcelUtil.readExcel(file, new ChoiceDTO());
			
//			for (Object o : list) {
//				System.out.println(((ChoiceDTO) o).getOptionE());
//			}
			
			bankService.addChoiceByExcel(list,bankid);
			
			return  "exceltest-import-success";
		}
	
	//excel导入题库填空
	@RequestMapping("/addFillByExcel")
	@ResponseBody
	public Object addFillByExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		
		 
		//从前台获得
		int bankid = (int) request.getSession().getAttribute("currentBankid");
	
		
		List<Object> list = ExcelUtil.readExcel(file, new FillDTO());

		bankService.addFillByExcel(list,bankid);
		return  "exceltest-import-success";
	}
	
	
	//excel导入考生名单
	@RequestMapping("/addStudentByExcel")
//	@ResponseBody
	public Object addStudentByExcel(@RequestParam("file") MultipartFile file,@RequestParam("paperid") Integer paperid,HttpServletRequest request,Model m) {
		List<Object> list = ExcelUtil.readExcel(file, new StudentDTO());
		for (Object o : list) {
			//System.out.println(((StudentDTO) o).getTel());
			User user=new User();
			user.setTel(((StudentDTO) o).getTel());
			user.setUsername(((StudentDTO) o).getName());
			user= userService.selectUserByTel(user);
			if(user ==null) {
				break;
			}
			if(user.getUsername().equals(((StudentDTO) o).getName())) {
				PapermappingExample pme = new PapermappingExample();
				com.neuedu.entity.PapermappingExample.Criteria c1 = pme.createCriteria();
				c1.andPaperidEqualTo(paperid);
				c1.andExamineeEqualTo(user.getUserid());
				List<Papermapping> mappinglist =  papermappingMapper.selectByExample(pme);
				if(mappinglist!=null) {
					break;
				}
				
				Paper paper=paperService.selectPaperbyId(paperid);
				//System.out.println(paper.getPapername());
				examService.creatExampaper(paper, user);
			}
				
			
		
		}
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		int userid= currentUser.getUserid();
		User u = new User();
		u.setUserid(userid);
		List<Paper> listp = paperService.selectPaperPublic(u);
		m.addAttribute("list", listp);
		return "teacherPaper/publishpaperTeacher";
	}
	
	//excel导入群组
		@RequestMapping("/addMemberlByExcel")
//		@ResponseBody
		public Object addMemberByExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
			Groups group = (Groups) request.getSession().getAttribute("group");
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			if(currentUser.getUsertype()==1) {
				//前端获得groupid
				int groupid = group.getGroupid();
				
				List<Object> list = ExcelUtil.readExcel(file, new MemberDTO());
				
	//			for (Object o : list) {
	//				System.out.println(((MemberDTO) o).getAccount());
	//			}
				if(group.getGroupid()!=null) {
					groupsService.addMemberByExcel(list,groupid);
				}
				return  "exceltest-import-success";
			}else {
				return "没有权限";
			}
			
		}
		
		//excel导出学生成绩
		@RequestMapping("/exportScores")
		public  void exportScores(@RequestParam Integer paperid,HttpServletRequest request,HttpServletResponse response) {
			Paper p = new Paper();
			p.setPaperid(paperid);
	        HashMap<String, Integer> hashmap = examService.getExamResult(p);
	        List<ExamResult> list=new ArrayList<>();
	        for(String key:hashmap.keySet()) {
	        	ExamResult es=new ExamResult(key, hashmap.get(key));
	        	list.add(es);
	        }
	        String fileName = "学生成绩";
	        String sheetName = "sheet01";
	   
	        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ExamResult());
	
		
		}

	       
}
