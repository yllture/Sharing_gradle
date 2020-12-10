package com.neuedu.service.impl;
 
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.dao.*;
import com.neuedu.entity.Bank;
import com.neuedu.entity.BankExample;
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
import com.neuedu.entity.Bankfolder;
import com.neuedu.entity.Groupmember;
import com.neuedu.entity.User;
import com.neuedu.excel.ChoiceDTO;
import com.neuedu.excel.FillDTO;
import com.neuedu.service.*;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankMapper bankMapper;
	
	@Autowired
	Bank_singleMapper bank_singleMapper;
	
	@Autowired
	Bank_singlechoiceMapper bank_singlechoiceMapper;
	
	@Autowired
	Bank_multipleMapper bank_multipleMapper;
	
	@Autowired
	Bank_multiplechoiceMapper bank_multiplechoiceMapper;
	
	@Autowired
	Bank_judgeMapper bank_judgeMapper;
	
	@Autowired
	Bank_fillMapper bank_fillMapper;
	
	@Autowired
	Bank_fillchoiceMapper bank_fillchoiceMapper;
	
	@Autowired
	Bank_shortanswerMapper bank_shortanswerMapper;
	
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
	Bank_shortanswer_movService bank_shortanswer_movService;
	@Autowired
	Bank_shortanswer_picService bank_shortanswer_picService;
	
	@Override
	public Bank selectBankByID(Bank b) {
		// TODO Auto-generated method stub
		Bank bank =  bankMapper.selectByPrimaryKey(b.getBankid());
		
		return bank;
	}

	@Override
	public List<Bank> selectAllBank(Bank b) {
		// TODO Auto-generated method stub
		List<Bank> selectAllBank = bankMapper.selectAllBank(b.getUserid());
		return selectAllBank;
	}

	@Override 
	public int addBank(Bank b) {
		// TODO Auto-generated method stub
		int i =bankMapper.insertSelective(b);
		System.out.println(i);
		return i;
	}

	@Override
	public int updateBank(Bank b) {
		// TODO Auto-generated method stub
		int i = bankMapper.updateByPrimaryKeySelective(b);
		return i;
	}

	@Override
	public int deleteBank(Bank b) {
		// TODO Auto-generated method stub
		int i = bankMapper.deleteByPrimaryKey(b.getBankid());
		return i;
	}

	@Override
	public int addQuestionByExcel(HashMap<String,List<String>> map,int bankid) {
		// TODO Auto-generated method stub
		 for (String key : map.keySet()) { 
			//单选题
			if(map.get(key).get(0).equals("单选")){
				List<String> list = map.get(key);
//				System.out.println(list.get(1));
				Bank_single bs = new Bank_single();
				bs.setqTitle(list.get(1));
				bs.setqKnowledge(list.get(8));
				if(list.get(9).equals("易")) {
					bs.setqDifficulty(0);
				}else if(list.get(9).equals("中")) {
					bs.setqDifficulty(1);
				}else if(list.get(9).equals("难")) {
					bs.setqDifficulty(2);
				}
				
				bs.setqAnalysis(list.get(10));
				bs.setBankid(bankid);
				bank_singleMapper.insert(bs);
				
				//添加单选选项
				for(int x=2;x<7;x++) {
					Bank_singlechoice bsc = new Bank_singlechoice();
					if(!list.get(x).equals("")) {
						bsc.setContent(list.get(x));
						bsc.setSequence(x-1);
						bsc.setqId(bs.getqId());
						bsc.setType(0);
						if(list.get(7).equals("A")&&x==2) {
							bsc.setType(1);
						}else if(list.get(7).equals("B")&&x==3) {
							bsc.setType(1);
						}else if(list.get(7).equals("C")&&x==4) {
							bsc.setType(1);
						}else if(list.get(7).equals("D")&&x==5) {
							bsc.setType(1);
						}
						bank_singlechoiceMapper.insert(bsc);
					}
					
				}
				
				
			}else if(map.get(key).get(0).equals("多选")) {
				List<String> list = map.get(key);
				
				Bank_multiple bs = new Bank_multiple();
				bs.setqTitle(list.get(1));
				bs.setqKnowledge(list.get(8));
				if(list.get(9).equals("易")) {
					bs.setqDifficulty(0);
				}else if(list.get(9).equals("中")) {
					bs.setqDifficulty(1);
				}else if(list.get(9).equals("难")) {
					bs.setqDifficulty(2);
				}
				
				
				bs.setqAnalysis(list.get(10));
				bs.setBankid(bankid);
				bank_multipleMapper.insert(bs);
				
				//添加多选选项
				for(int x=2;x<7;x++) {
					Bank_multiplechoice bsc = new Bank_multiplechoice();
					if(!list.get(x).equals("")) {
						bsc.setContent(list.get(x));
						bsc.setSequence(x-1);
						bsc.setqId(bs.getqId());
						bsc.setType(0);
						
						
						if(list.get(7).contains("A")&&x==2) {
							bsc.setType(1);
						}else if(list.get(7).contains("B")&&x==3) {
							bsc.setType(1);
						}else if(list.get(7).contains("C")&&x==4) {
							bsc.setType(1);
						}else if(list.get(7).contains("D")&&x==5) {
							bsc.setType(1);
						}
						bank_multiplechoiceMapper.insert(bsc);
					}
					
				}
				
				
				
//				System.out.println(list.get(1));
			}else if(map.get(key).get(0).equals("判断")) {
				List<String> list = map.get(key);
//				System.out.println(list.get(1));
				
				Bank_judge bs = new Bank_judge();
				bs.setqTitle(list.get(1));
				bs.setqKnowledge(list.get(8));
				if(list.get(9).equals("易")) {
					bs.setqDifficulty(0);
				}else if(list.get(9).equals("中")) {
					bs.setqDifficulty(1);
				}else if(list.get(9).equals("难")) {
					bs.setqDifficulty(2);
				}
				if(list.get(7).equals("A")) {
					bs.setIsture(1);
				}else if(list.get(7).equals("B")) {
					bs.setIsture(0);;
				}
				
				bs.setqAnalysis(list.get(10));
				
				bs.setBankid(bankid);
				
			
				bank_judgeMapper.insert(bs);
				
			
			}else if(map.get(key).get(0).equals("填空")){
				List<String> list = map.get(key);
				
				Bank_fill bf = new Bank_fill();
				bf.setqTitle(list.get(1));
				bf.setqKnowledge(list.get(5));
				bf.setqAnalysis(list.get(7));
				bf.setBankid(bankid);
				if(list.get(6).equals("易")) {
					bf.setqDifficulty(0);
				}else if(list.get(6).equals("中")) {
					bf.setqDifficulty(1);
				}else if(list.get(6).equals("难")) {
					bf.setqDifficulty(2);
				}
				bank_fillMapper.insert(bf);
				
				for(int x=2;x<5;x++) {
					Bank_fillchoice bfc = new Bank_fillchoice();
					if(!list.get(x).equals("")) {
						bfc.setContent(list.get(x));
						bfc.setSequence(x-1);
						bfc.setqId(bf.getqId());
						bank_fillchoiceMapper.insert(bfc);
					}
					
					
				}
				
				
			}
			
			
			
		}
		
		return 0;
	}

	@Override
	public int addChoiceByExcel(List<Object> list, int bankid) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<list.size();i++) {
			Object o = list.get(i);
			
			if(((ChoiceDTO) o).getType().equals("单选")) {
				ChoiceDTO choice =(ChoiceDTO)o;
				Bank_single bs = new Bank_single();
				bs.setqTitle(choice.getTitle());
				bs.setqKnowledge(choice.getKnowledge());
//				System.out.println(choice.getKnowledge()+"22");
//				System.out.println(bs.getqKnowledge()+"11");
				if(choice.getDifficulity().equals("易")) {
					bs.setqDifficulty(0);
				}else if(choice.getDifficulity().equals("中")) {
					bs.setqDifficulty(1);
				}else if(choice.getDifficulity().equals("难")) {
					bs.setqDifficulty(2);
				}
				
				bs.setqAnalysis(choice.getAnalysis());
				bs.setBankid(bankid);
				bank_singleMapper.insert(bs);
				
				//添加单选选项
				List<String> str = new ArrayList<String>();
				str.add(choice.getOptionA());
				str.add(choice.getOptionB());
				str.add(choice.getOptionC());
				str.add(choice.getOptionD());
				str.add(choice.getOptionE());
				
				for(int x=0;x<str.size();x++) {
					Bank_singlechoice bsc = new Bank_singlechoice();
					String s = str.get(x);
					if(s !=null&& !"".equals(s)) {
						bsc.setContent(str.get(x));
						bsc.setSequence(x+1);
						bsc.setqId(bs.getqId());
						bsc.setType(0);
						if(choice.getOptionture().equals("A")&&x==0) {
							bsc.setType(1);
						}else if(choice.getOptionture().equals("B")&&x==1) {
							bsc.setType(1);
						}else if(choice.getOptionture().equals("C")&&x==2) {
							bsc.setType(1);
						}else if(choice.getOptionture().equals("D")&&x==3) {
							bsc.setType(1);
						}else if(choice.getOptionture().equals("E")&&x==4) {
							bsc.setType(1);
						}
						bank_singlechoiceMapper.insert(bsc);
					}
					
				}
				
				
			}else if(((ChoiceDTO) o).getType().equals("多选")) {
				ChoiceDTO choice =(ChoiceDTO)o;
				Bank_multiple bs = new Bank_multiple();
				bs.setqTitle(choice.getTitle());
				bs.setqKnowledge(choice.getKnowledge());
//				System.out.println(choice.getKnowledge()+"22");
//				System.out.println(bs.getqKnowledge()+"11");
				if(choice.getDifficulity().equals("易")) {
					bs.setqDifficulty(0);
				}else if(choice.getDifficulity().equals("中")) {
					bs.setqDifficulty(1);
				}else if(choice.getDifficulity().equals("难")) {
					bs.setqDifficulty(2);
				}
				
				bs.setqAnalysis(choice.getAnalysis());
				bs.setBankid(bankid);
				bank_multipleMapper.insert(bs);
				
				//添加单选选项
				List<String> str = new ArrayList<String>();
				str.add(choice.getOptionA());
				str.add(choice.getOptionB());
				str.add(choice.getOptionC());
				str.add(choice.getOptionD());
				str.add(choice.getOptionE());
				
				for(int x=0;x<str.size();x++) {
					Bank_multiplechoice bsc = new Bank_multiplechoice();
					String s = str.get(x);
					if(s !=null&& !"".equals(s)) {
						bsc.setContent(str.get(x));
						bsc.setSequence(x+1);
						bsc.setqId(bs.getqId());
						bsc.setType(0);
						if(choice.getOptionture().contains("A")&&x==0) {
							bsc.setType(1);
						}else if(choice.getOptionture().contains("B")&&x==1) {
							bsc.setType(1);
						}else if(choice.getOptionture().contains("C")&&x==2) {
							bsc.setType(1);
						}else if(choice.getOptionture().contains("D")&&x==3) {
							bsc.setType(1);
						}else if(choice.getOptionture().contains("E")&&x==4) {
							bsc.setType(1);
						}
						bank_multiplechoiceMapper.insert(bsc);
					}
					
				}
				
				
			}else if(((ChoiceDTO) o).getType().equals("判断")) {
				
				ChoiceDTO choice =(ChoiceDTO)o;
				
				Bank_judge bs = new Bank_judge();
				bs.setqTitle(choice.getTitle());
				bs.setqKnowledge(choice.getKnowledge());
				if(choice.getDifficulity().equals("易")) {
					bs.setqDifficulty(0);
				}else if(choice.getDifficulity().equals("中")) {
					bs.setqDifficulty(1);
				}else if(choice.getDifficulity().equals("难")) {
					bs.setqDifficulty(2);
				}
				if(choice.getOptionture().equals("A")) {
					bs.setIsture(1);
				}else if(choice.getOptionture().equals("B")) {
					bs.setIsture(0);;
				}
				
				bs.setqAnalysis(choice.getAnalysis());
				
				bs.setBankid(bankid);
				
			
				bank_judgeMapper.insert(bs);
				
			}
		
		
		
		
	}
		return 1;
	}

	@Override
	public int addFillByExcel(List<Object> list, int bankid) {
		// TODO Auto-generated method stub
		for(int i =0 ;i<list.size();i++) {
			Object o = list.get(i);
			if(((FillDTO) o).getType().equals("填空")) {
				FillDTO fill = (FillDTO) o;
				
				Bank_fill bf = new Bank_fill();
				bf.setqTitle(fill.getTitle());
				bf.setqKnowledge(fill.getKnowledge());
				bf.setqAnalysis(fill.getAnalysis());
				bf.setBankid(bankid);
				if(fill.getDifficulty().equals("易")) {
					bf.setqDifficulty(0);
				}else if(fill.getDifficulty().equals("中")) {
					bf.setqDifficulty(1);
				}else if(fill.getDifficulty().equals("难")) {
					bf.setqDifficulty(2);
				}
				bank_fillMapper.insert(bf);
				List<String> str = new ArrayList<String>();
				str.add(fill.getAnswer1());
				str.add(fill.getAnswer2());
				str.add(fill.getAnswer3());
				for(int x=0;x<str.size();x++) {
					Bank_fillchoice bfc = new Bank_fillchoice();
					String s= str.get(x);
					if(s !=null&& !"".equals(s)) {
						bfc.setContent(str.get(x));
						bfc.setSequence(x+1);
						bfc.setqId(bf.getqId());
						bank_fillchoiceMapper.insert(bfc);
					}
					
					
				}
			
			
			
			
			
		}
			
			
		}
		
		 
		return 0;
	}

	@Override
	public List<Bank> getAllByFolderid(Bankfolder bf) {
		// TODO Auto-generated method stub
			List<Bank> banklist = bankMapper.getAllByFolderid(bf.getFolderid());
			return banklist;

	}

	@Override
	public List<String> getKnowledge(Bank bank) {
		List<String> knowledge=new ArrayList<>();
		HashMap<String, Integer> hashmap=new HashMap<>();
		List<Bank_fill> fills=bank_fillMapper.getAllbyBankid(bank.getBankid());
		for(Bank_fill fill:fills) {
			hashmap.put(fill.getqKnowledge(), 1);
		}
		List<Bank_single> singles=bank_singleMapper.getAllbyBankid(bank.getBankid());
		for(Bank_single single:singles) {
			hashmap.put(single.getqKnowledge(), 1);
		}
		List<Bank_multiple> multiples=bank_multipleMapper.getAllbyBankid(bank.getBankid());
		for(Bank_multiple multiple:multiples) {
			hashmap.put(multiple.getqKnowledge(), 1);
		}
		List<Bank_shortanswer> shortanswers=bank_shortanswerMapper.getAllbyBankid(bank.getBankid());
		for(Bank_shortanswer shortanswer:shortanswers) {
			hashmap.put(shortanswer.getqKnowledge(), 1);
		}
		List<Bank_judge> judges=bank_judgeMapper.getAllbyBankid(bank.getBankid());
		for(Bank_judge judge:judges) {
			hashmap.put(judge.getqKnowledge(), 1);
		}
		for(String key:hashmap.keySet()) {
			knowledge.add(key);
		}
		return knowledge;
	}

	@Override
	public int BuyBank(Bank b,int userid) {
		// TODO Auto-generated method stub
		Bank bank = selectBankByID(b);
		Bank newbank=new Bank();
		newbank.setBankname(bank.getBankname());
		newbank.setBanklabel(bank.getBanklabel());
		newbank.setBankdescription(bank.getBankdescription());
		newbank.setBankicon(bank.getBankicon());
		newbank.setUserid(userid);
		addBank(newbank);
		if(bank.getQuestionnum()!=0)
		{
			if(bank.getSinglenum()!=0)
			{
				List<Bank_single> singles = bank_singleService.getAllbyBankid(bank);
				for(int i=0;i<singles.size();i++) {
					Bank_single single=singles.get(i);
					single.setBankid(newbank.getBankid());
					single.setqId(null);
					bank_singleService.addBank_single(single);
					for(int j=0;j<single.getSinglelist().size();j++) 
					{
						Bank_singlechoice choice=single.getSinglelist().get(j);
						choice.setqId(single.getqId());
						choice.setChoiceid(null);
						bank_singlechoiceService.addBank_singlechoice(choice);
					}				
				}
			}
			
			
			if(bank.getJudgenum()!=0)
			{
				List<Bank_judge> judges = bank_judgeService.getAllbyBankid(bank);
				for(int i=0;i<judges.size();i++) {
					Bank_judge judge=judges.get(i);
					judge.setBankid(newbank.getBankid());
					judge.setqId(null);
					bank_judgeService.addBank_judge(judge);			
				}
			}
			
			if(bank.getFillnum()!=0)
			{
				List<Bank_fill> fills = bank_fillService.getAllbyBankid(bank);
				for(int i=0;i<fills.size();i++) {
					Bank_fill fill=fills.get(i);
					fill.setBankid(newbank.getBankid());
					fill.setqId(null);
					bank_fillService.addBank_fill(fill);
					for(int j=0;j<fill.getFilllsit().size();j++) 
					{
						Bank_fillchoice choice=fill.getFilllsit().get(j);
						choice.setqId(fill.getqId());
						choice.setChoiceid(null);
						bank_fillchoiceService.addBank_fillchoice(choice);
					}				
				}
			}
			
			
			if(bank.getMultiplenum()!=0)
			{
				List<Bank_multiple> multiples = bank_multipleService.getAllbyBankid(bank);
				for(int i=0;i<multiples.size();i++) {
					Bank_multiple multiple=multiples.get(i);
					multiple.setBankid(newbank.getBankid());
					multiple.setqId(null);
					bank_multipleService.addBank_multiple(multiple);
					for(int j=0;j<multiple.getMultiplelist().size();j++) 
					{
						Bank_multiplechoice choice=multiple.getMultiplelist().get(j);
						choice.setqId(multiple.getqId());
						choice.setChoiceid(null);
						bank_multiplechoiceService.addBank_multiplechoice(choice);
					}				
				}
			}
			

			if(bank.getShortanswernum()!=0)
			{
				List<Bank_shortanswer> shortanswers = bank_shortanswerService.getAllbyBankid(bank);
				for(int i=0;i<shortanswers.size();i++) {
					Bank_shortanswer shortanswer=shortanswers.get(i);
					shortanswer.setBankid(newbank.getBankid());
					shortanswer.setqId(null);
					bank_shortanswerService.addBank_shortanswer(shortanswer);
					for(int j=0;j<shortanswer.getShortmovlist().size();j++) 
					{
						Bank_shortanswer_mov mov = shortanswer.getShortmovlist().get(j);
						mov.setqId(shortanswer.getqId());
						bank_shortanswer_movService.addBank_shortanswer_mov(mov);
					}		
					for(int j=0;j<shortanswer.getShortpiclist().size();j++) 
					{
						Bank_shortanswer_pic pic=shortanswer.getShortpiclist().get(j);
						pic.setqId(shortanswer.getqId());
//						choice.setChoiceid(null);
						bank_shortanswer_picService.addBank_shortanswer_pic(pic);
					}		
				}
			}	
		}
		return newbank.getBankid();
	}

	@Override
	public int getFillnumByknowledge(Bank_fill bf) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		b.setBankid(bf.getBankid());
		List<Bank_fill> allbyBankid = bank_fillService.getAllbyBankid(b);
		if(allbyBankid==null) {
			return 0;
		}
		for(int i=0;i<allbyBankid.size();i++) {
			if(!allbyBankid.get(i).getqKnowledge().equals(bf.getqKnowledge())) {
				allbyBankid.remove(i);
			}	
		}
		if(allbyBankid==null) {
			return 0;
		}
		int i = allbyBankid.size();
		return i;
	}

	@Override
	public int getSinglenumByknowledge(Bank_single bs) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		b.setBankid(bs.getBankid());
		List<Bank_single> allbyBankid = bank_singleService.getAllbyBankid(b);
		if(allbyBankid==null) {
			return 0;
		}
		for(int i=0;i<allbyBankid.size();i++) {
			if(!allbyBankid.get(i).getqKnowledge().equals(bs.getqKnowledge())) {
				allbyBankid.remove(i);
			}	
		}
		if(allbyBankid==null) {
			return 0;
		}
		int i = allbyBankid.size();
		return i;
	}

	@Override
	public int getMultiplenumByknowledge(Bank_multiple bm) {
		
		Bank b = new Bank();
		b.setBankid(bm.getBankid());
		List<Bank_multiple> allbyBankid = bank_multipleService.getAllbyBankid(b);
		if(allbyBankid==null) {
			return 0;
		}
		for(int i=0;i<allbyBankid.size();i++) {
			if(!allbyBankid.get(i).getqKnowledge().equals(bm.getqKnowledge())) {
				allbyBankid.remove(i);
			}	
		}
		if(allbyBankid==null) {
			return 0;
		}
		int i = allbyBankid.size();
		return i;
	}

	@Override
	public int getJudgenumByknowledge(Bank_judge bj) {

		Bank b = new Bank();
		b.setBankid(bj.getBankid());
		List<Bank_judge> allbyBankid = bank_judgeService.getAllbyBankid(b);
		if(allbyBankid==null) {
			return 0;
		}
		for(int i=0;i<allbyBankid.size();i++) {
			if(!allbyBankid.get(i).getqKnowledge().equals(bj.getqKnowledge())) {
				allbyBankid.remove(i);
			}	
		}
		if(allbyBankid==null) {
			return 0;
		}
		int i = allbyBankid.size();
		return i;
	}

	@Override
	public int getShortanswernumByknowledge(Bank_shortanswer bs) {

		Bank b = new Bank();
		b.setBankid(bs.getBankid());
		List<Bank_shortanswer> allbyBankid = bank_shortanswerService.getAllbyBankid(b);
		if(allbyBankid==null) {
			return 0;
		}
		for(int i=0;i<allbyBankid.size();i++) {
			if(!allbyBankid.get(i).getqKnowledge().equals(bs.getqKnowledge())) {
				allbyBankid.remove(i);
			}	
		}
		if(allbyBankid==null) {
			return 0;
		}
		int i = allbyBankid.size();
		return i;
	}

	@Override
	public int deleteFillByknowledge(Bank_fill bf) {
		// TODO Auto-generated method stub
		int i = bankMapper.deleteFillByknowledge(bf);
		return i;
	}

	@Override
	public int deleteSingleByknowledge(Bank_single bs) {
		// TODO Auto-generated method stub
		int i = bankMapper.deleteSingleByknowledge(bs);
		return i;
	}

	@Override
	public int deleteMultipleByknowledge(Bank_multiple bm) {
		// TODO Auto-generated method stub
		int i = bankMapper.deleteMultipleByknowledge(bm);
		return i;
	}

	@Override
	public int deleteJudgeByknowledge(Bank_judge bj) {
		// TODO Auto-generated method stub
		int i = bankMapper.deleteJudgeByknowledge(bj);
		return i;
	}

	@Override
	public int deleteShortanswerByknowledge(Bank_shortanswer bs) {
		// TODO Auto-generated method stub
		int i = bankMapper.deleteShortanswerByknowledge(bs);
		return i;
	}
	
}
