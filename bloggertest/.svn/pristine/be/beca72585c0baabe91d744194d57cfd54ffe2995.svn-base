package com.neuedu.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.neuedu.entity.*;
import com.neuedu.service.BankService;
import com.neuedu.service.Bank_fillService;
import com.neuedu.service.Bank_multipleService;
import com.neuedu.service.*;

@Controller
public class BankController {
	

	@Autowired
	BankfolderService bankfolderService;
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
	Garbage_bankfolderService garbage_bankfolderService;
	//题库首页
	@RequestMapping("/tobankTeacher")
	public String toBankTeacher(HttpServletRequest request,Model m) {

		User currentUser = (User) request.getSession().getAttribute("currentUser");
		Bank b = new Bank();
		b.setUserid(currentUser.getUserid());
		User u = new User();
		u.setUserid(currentUser.getUserid());
		
		//找到所有首页文件夹
		List<Bankfolder> selectAllBankfolder =  bankfolderService.getAllbyUserid(u);
		//找到所有的未在文件夹中的题库
		List<Bank> selectAllBank = bankService.selectAllBank(b);
		List<Bank> uploadedBank = new ArrayList<Bank>();
		List<Bank> unuploadedBank = new ArrayList<Bank>();
		//将题库分为已上传和未上传
		for(Bank bank:selectAllBank) {
			Shop_bank sb= new Shop_bank();
			sb.setBankid(bank.getBankid());
			sb= shop_bankService.selectbyBankid(sb);
			if(sb==null||sb.getCheckflag()==3) {
				unuploadedBank.add(bank);
			}else {
				uploadedBank.add(bank);
			}
		} 

		m.addAttribute("uploadedBanklist", uploadedBank);
		m.addAttribute("unuploadedBanklist", unuploadedBank);
		m.addAttribute("allbankfolder",selectAllBankfolder);
		return "teacherBank/bankTeacher";
	}
	
	//题库次级文件夹
	@RequestMapping("/tobankTeacher2")
	public  String toBankTeacher2(
			@RequestParam(value="folderid",required=false,defaultValue="0") String folderid,
			Model m) {
		//获得本层文件夹的id
		int folderid2 = Integer.parseInt(folderid);
		Bankfolder bf = new Bankfolder();
		bf.setFolderid(folderid2);
		//找到本层文件夹
		bf= bankfolderService.selectByfolderid(bf);
		List<Bankfolder> pathlist = new ArrayList<Bankfolder>();
		pathlist.add(bf);
		Bankfolder current = new Bankfolder();
		current = bf;
		//获得所有的父层文件夹
		while(current.getC4()!=null) {
			Bankfolder bf2 = new Bankfolder();
			bf2.setFolderid(current.getC4());
			bf2= bankfolderService.selectByfolderid(bf2);
			pathlist.add(bf2);
			current = bf2;
		}
		List<Bankfolder> pathlist1 = new ArrayList<Bankfolder>();
		for(int i=pathlist.size()-1;i>=0;i--) {
			pathlist1.add(pathlist.get(i));
		}
		

		//找到所有的子文件夹
		List<Bankfolder> selectAllBankfolder =bankfolderService.getAllbyFolderid(bf);
		
		//找到所有的题库并进行分类
		List<Bank> banklist =  bankService.getAllByFolderid(bf);
		List<Bank> uploadedBank = new ArrayList<Bank>();
		List<Bank> unuploadedBank = new ArrayList<Bank>();
		for(Bank bank:banklist) {
			Shop_bank sb= new Shop_bank();
			sb.setBankid(bank.getBankid());
			sb= shop_bankService.selectbyBankid(sb);
			if(sb==null) {
				unuploadedBank.add(bank);
			}else {
				uploadedBank.add(bank);
			} 
		} 
		m.addAttribute("currentfolderid",bf.getFolderid());
		m.addAttribute("pathlist",pathlist1);
		m.addAttribute("uploadedBanklist", uploadedBank);
		m.addAttribute("unuploadedBanklist", unuploadedBank);
		m.addAttribute("allbankfolder",selectAllBankfolder);
		
		return "teacherBank/bankTeacher";
	}
	
	
	@RequestMapping("/addbankfolder")
	public @ResponseBody String addBankfolder(@RequestBody Bankfolder bf,HttpServletRequest request) {
	
		bf.setC3(0);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		bf.setUserid(currentUser.getUserid());
		bankfolderService.addBankfolder(bf);
		
		return "";
	}
	
	@RequestMapping("/bankmove")
	public @ResponseBody String  Bsnkmove(@RequestBody Bank b) {

		Bank b2 =  bankService.selectBankByID(b);
		b2.setFolderid(b.getFolderid());
		bankService.updateBank(b2);
		Bankfolder bf = new Bankfolder();
		bf.setFolderid(b.getFolderid());
		bf=bankfolderService.selectByfolderid(bf);
		int count = bf.getC3();
		bf.setC3(count+1);
		bankfolderService.updateBankfolder(bf);
		
		return ""; 
	}
	
	@RequestMapping("/renamebankfolder")
	public @ResponseBody String Renamebankfolder(@RequestBody Bankfolder bf) {
		bankfolderService.updateBankfolder(bf);
		
		return "";
	}
	
	
	@RequestMapping("/deletebankfolder")
	public @ResponseBody String Deletebankfolder(@RequestBody Bankfolder bf) {
		bf = bankfolderService.selectByfolderid(bf);
		Garbage_bankfolder gbf = new Garbage_bankfolder();
		gbf.setFolderid(bf.getFolderid());
		gbf.setFoldername(bf.getFoldername());
		gbf.setUserid(bf.getUserid());
		gbf.setBanknum(bf.getC3());
		gbf.setFoldermapping(bf.getC4());
		
		garbage_bankfolderService.addGarbage_bankfolder(gbf);
		bankfolderService.deleteBankfolder(bf);
		return "";
	}
	
	@RequestMapping("/addbank")
	public @ResponseBody String Addbank(@RequestBody Bank b,HttpServletRequest request) {
		//从session中获取userid
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		b.setUserid(currentUser.getUserid());
		b.setUpdatetime(new Date());
		bankService.addBank(b);
		//更新文件中的题库数
		Bankfolder bf = new Bankfolder();
		bf.setFolderid(b.getFolderid());
		bf = bankfolderService.selectByfolderid(bf);
		if(bf==null) {
			return "";
		}
		int count = bf.getC3();
		bf.setC3(count+1);
		bankfolderService.updateBankfolder(bf);
		//一直查到没有父文件夹为止
		while(bf.getC4()!=null) {
			Bankfolder current = new Bankfolder();
			current.setFolderid(bf.getC4());
			current = bankfolderService.selectByfolderid(current);
			int i = current.getC3();
			current.setC3(i+1);
			bankfolderService.updateBankfolder(current);
			bf = current;

		}

		
		return "";
	}
	
	@RequestMapping("/editbank")
	public @ResponseBody String Editbank(@RequestBody Bank b ,HttpServletRequest request) {

		User currentUser = (User) request.getSession().getAttribute("currentUser");
		b.setUserid(currentUser.getUserid());
		bankService.updateBank(b);
		return "";
	}
	
	@RequestMapping("/uploadbank")
	public @ResponseBody String Uploadbank(@RequestBody Shop_bank shopb ) {

		Bank b = new Bank();
		b.setBankid(shopb.getBankid());
		b = bankService.selectBankByID(b);
		shopb.setBankname(b.getBankname());
		shopb.setBankdescription(b.getBankdescription());
		shopb.setUserid(b.getUserid());
		shopb.setQuestionnum(b.getQuestionnum());
		shopb.setSignlenum(b.getSinglenum());
		shopb.setJudgenum(b.getJudgenum());
		shopb.setMultiplenum(b.getMultiplenum());
		shopb.setShortanswernum(b.getShortanswernum());
		shopb.setFillnum(b.getFillnum());
		shopb.setTime(new Date());
		shopb.setPaynum(0);
		shopb.setAvgevaluate(0);
		shopb.setCheckflag(0);
		Shop_bank s = shop_bankService.selectbyBankid(shopb);
		if(s==null) {
			shop_bankService.addShop_bank(shopb);
		}else {
			shop_bankService.updateShop_bank(shopb);
		}
		
		return "";
	}
	
	@RequestMapping("/deletebank")
	public @ResponseBody String Deletebank(@RequestBody Bank b ) {
		
		b=bankService.selectBankByID(b);
		Garbage_bank gb = new Garbage_bank();
		gb.setBankid(b.getBankid());
		gb.setBankname(b.getBankname());
		gb.setBankdescription(b.getBankdescription());
		gb.setBanklabel(b.getBanklabel());
		gb.setUserid(b.getUserid());
		gb.setQuestionnum(b.getQuestionnum());
		gb.setSinglenum(b.getSinglenum());
		gb.setJudgenum(b.getJudgenum());
		gb.setMultiplenum(b.getMultiplenum());
		gb.setShortanswernum(b.getShortanswernum());
		gb.setFillnum(b.getFillnum());
		gb.setBankicon(b.getBankicon());
		gb.setFolderid(b.getFolderid());
		gb.setUpdatetime(b.getUpdatetime());
		
		
		if(b.getFolderid()!=null) {
		Bankfolder bf = new Bankfolder();
		bf.setFolderid(b.getFolderid());
		bf = bankfolderService.selectByfolderid(bf);
		int count = bf.getC3();
		bf.setC3(count-1);
		bankfolderService.updateBankfolder(bf);
		
		//一直查到没有父文件夹为止
		while(bf.getC4()!=null) {
			Bankfolder current = new Bankfolder();
			current.setFolderid(bf.getC4());
			current = bankfolderService.selectByfolderid(current);
			int i = current.getC3();
			current.setC3(i-1);
			bankfolderService.updateBankfolder(current);
			bf = current;

		}
		}
		garbage_bankService.addGarbage_bank(gb);
		bankService.deleteBank(b);
		 
		return "";
		
		
	}
	
	@RequestMapping("/toeditbankinfo")
	public String TobankTrashTeacher(@RequestParam String bankid,Model m,HttpServletResponse res) {

		res.setContentType("text/html;charset=utf-8");

		int currentbankid = Integer.parseInt(bankid);
		Bank b = new Bank();
		b.setBankid(currentbankid);
		b = bankService.selectBankByID(b);
		List<Bank_fill> bankfilllist =  bank_fillService.getAllbyBankid(b);
		List<Bank_judge> judgelist = bank_judgeService.getAllbyBankid(b);
		List<Bank_multiple> multiplelist = bank_multipleService.getAllbyBankid(b);
		List<Bank_shortanswer> shortanswerlist = bank_shortanswerService.getAllbyBankid(b);
		List<Bank_single> singlelist = bank_singleService.getAllbyBankid(b);
		
		m.addAttribute("bank",b);
		m.addAttribute("allfill",bankfilllist);
		m.addAttribute("alljudge",judgelist);
		m.addAttribute("allmultiple",multiplelist);
		m.addAttribute("allshortanswer",shortanswerlist);
		m.addAttribute("allsingle",singlelist);
		return "teacherBank/editbankinfo";
	}
	
	@RequestMapping("/tobankTrashTeacher")
	public String toBankTrashTeacher(Model m,HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		int userid=currentUser.getUserid();//通过currentuser获得
		Garbage_bank gb = new Garbage_bank(); 
		gb.setUserid(userid); 
		
		Garbage_bankfolder gbf = new Garbage_bankfolder();
		gbf.setUserid(userid);
		List<Garbage_bank> allbank = garbage_bankService.getAllByuserid(gb);
		
		List<Garbage_bankfolder> allbankfolder = garbage_bankfolderService.getAllByuserid(gbf);
	
		m.addAttribute("allbank",allbank);
		m.addAttribute("allbankfolder",allbankfolder);
		
		return "teacherBank/bankTrashTeacher";
	}
	
	@RequestMapping("/deletegarbagebankfolder")
	public @ResponseBody String Deletegarbagebankfolder(@RequestBody Garbage_bankfolder gb) {
		garbage_bankfolderService.deleteGarbage_bankfolder(gb);
		
		return "";
	}
		
	@RequestMapping("/deletegarbagebank")
	public @ResponseBody String Deletegarbagebank(@RequestBody Garbage_bank gb) {
		
		garbage_bankService.deleteGarbage_bank(gb);
		return "";
	
	}
	
	//获得文件夹的还原路径
	@RequestMapping("/getbackpath")
	public @ResponseBody String Getbackpath(@RequestBody Garbage_bankfolder gbf) {
		
		gbf = garbage_bankfolderService.seleteByfolderid(gbf);
		String path = "题库";
		String path1 = "";
		if(gbf.getFoldermapping()!=null) {
			Bankfolder bf = new Bankfolder();
			bf.setFolderid(gbf.getFoldermapping());
			bf = bankfolderService.selectByfolderid(bf);
			if(bf==null) {
				return "error";
			}
			
			path1 = bf.getFoldername();
		
			while(bf.getC4()!=null) {
				Bankfolder current = new Bankfolder();
				current.setFolderid(bf.getC4());
				current = bankfolderService.selectByfolderid(current);
				if(current==null) {
					return "error";
				}
				path1 = current.getFoldername()+">"+path1;
				bf = current;

			}
			path = path +">"+path1;
			return path;
			
		}else {
			return path;
		}

	}
		
	@RequestMapping("/rebackfolder")
	public @ResponseBody String Rebackfolder(@RequestBody Garbage_bankfolder gbf) {
		gbf = garbage_bankfolderService.seleteByfolderid(gbf);
		Bankfolder bf = new Bankfolder();
		bf.setFolderid(gbf.getFolderid());
		bf.setFoldername(gbf.getFoldername());
		bf.setUserid(gbf.getUserid());
		bf.setC3(gbf.getBanknum());
		bf.setC4(gbf.getFoldermapping());
		bankfolderService.addBankfolder(bf);
		garbage_bankfolderService.deleteGarbage_bankfolder(gbf);
		
		
		return"";
	}
	//获得题库的还原路径
	@RequestMapping("/getbankbackpath")
	public @ResponseBody String Getbankbackpath(@RequestBody Garbage_bank gb) {
		
		gb = garbage_bankService.selectGarbage_bank(gb);
		String path = "题库";
		String path1 = "";
		if(gb.getFolderid()!=null) {
			Bankfolder bf = new Bankfolder();
			bf.setFolderid(gb.getFolderid());
			bf = bankfolderService.selectByfolderid(bf);
			if(bf==null) {
				return "error";
			}
			path1 = bf.getFoldername();
		
			while(bf.getC4()!=null) {
				Bankfolder current = new Bankfolder();
				current.setFolderid(bf.getC4());
				current = bankfolderService.selectByfolderid(current);
				if(current==null) {
					return "error";
				}
				path1 = current.getFoldername()+">"+path1;
				bf = current;

			}
			path = path +">"+path1;
			return path;
			
		}else {
			return path;
		}

	}
	
	@RequestMapping("/rebackbank")
	public @ResponseBody String Rebackbank(@RequestBody Garbage_bank gb) {
		
		gb=garbage_bankService.selectGarbage_bank(gb);
		Bank b = new Bank();
		b.setBankid(gb.getBankid());
		b.setBankname(gb.getBankname());
		b.setBankdescription(gb.getBankdescription());
		b.setBanklabel(gb.getBanklabel());
		b.setUserid(gb.getUserid());
		b.setQuestionnum(gb.getQuestionnum());
		b.setSinglenum(gb.getSinglenum());
		b.setJudgenum(gb.getJudgenum());
		b.setMultiplenum(gb.getMultiplenum());
		b.setShortanswernum(gb.getShortanswernum());
		b.setFillnum(gb.getFillnum());
		b.setBankicon(gb.getBankicon());
		b.setFolderid(gb.getFolderid());
		b.setUpdatetime(gb.getUpdatetime());
		bankService.addBank(b);
		garbage_bankService.deleteGarbage_bank(gb);
		//更新文件夹中的题库数
		if(b.getFolderid()!=null) {
			
			Bankfolder bf = new Bankfolder();
			bf.setFolderid(b.getFolderid());
			bf = bankfolderService.selectByfolderid(bf);
			if(bf==null) {
				return "error";
			}
			int count = bf.getC3();
			bf.setC3(count+1);
			bankfolderService.updateBankfolder(bf);
			//一直查到没有父文件夹为止
			while(bf.getC4()!=null) {
				Bankfolder current = new Bankfolder();
				current.setFolderid(bf.getC4());
				current = bankfolderService.selectByfolderid(current);
				if(current==null) {
					return "error";
				}
				int i = current.getC3();
				current.setC3(i+1);
				bankfolderService.updateBankfolder(current);
				bf = current;

			}	
		}
		return "";
	}
	
	@RequestMapping("/getKnowledge")
	public String getKnowledge() {
		Bank bank=new Bank();
		bank.setBankid(1);
		List<String> knowledge=bankService.getKnowledge(bank);
		for(String key:knowledge) {
			System.out.println(key);
		}
		return "teacherbank/upload";
	}
		

//	//excel导入题库
//	@RequestMapping("/addBankByExcel")
//	public String AddExcelMember(MultipartHttpServletRequest request){
//		
//		
//		
//		//获得bankid
//		int bankid = 1;
//		
//		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
//		try {
//            //得到上传的文件
//            MultipartFile fileFile = request.getFile("file");
//            
//            //转换成输入流
//            InputStream in = fileFile.getInputStream();
//    		HSSFWorkbook readWb = new HSSFWorkbook(in);
////    		HashMap<String,HashMap<String,ArrayList<String>>> totalmap = new  HashMap<String,HashMap<String,ArrayList<String>>>();
////    		HashMap<String,ArrayList<String>> bankmap = new HashMap<String,ArrayList<String>>();
//    		
//            /*HSSFWorkbook readWb = new HSSFWorkbook(in);*/
//            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
//            for (int i = 0; i < readWb.getNumberOfSheets(); i++) {
//                HSSFSheet sheet = readWb.getSheetAt(i);
//                // 循环行Row
//                for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//                    HSSFRow hssfRow = sheet.getRow(rowNum);
//                  //问题列表
//                    List<String> questionlist=new ArrayList<String>();
//                    if (hssfRow != null) {
//                        for (int colNum = 0; colNum < hssfRow.getPhysicalNumberOfCells(); colNum++) {
//                        	Cell cell=hssfRow.getCell(colNum);
//                        	questionlist.add((String)cell.getStringCellValue());
//                        	System.out.println(cell.getStringCellValue());
//                        }
//                        //赋值实例对象 做插入数据库操作
//                    }
//                    
//                    map.put("question"+rowNum,questionlist);
//                    
//                }
//            }
// 
//        } catch (Exception e) {
//           
//            e.printStackTrace();
//        }
//		
//		
//		bankService.addQuestionByExcel(map,bankid);
//		
//		
//		return "teacherBank/bankitem";
//	}
//	
	
	
	
	


}
