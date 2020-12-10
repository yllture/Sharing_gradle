package com.neuedu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.*;

public interface PaperService {
	@Cacheable(value="PaperByid",key="'Paper_'+#i")
	Paper selectPaperbyId(Integer i);
	
	//数据库获得paper母本的方法（通过winder得到）
	
	@Cacheable(value="AllPaperByTeacher",key="'Paperlist_'+#u.userid")
	List<Paper> selectAllPaperByTeacher(User u);
	
	@Cacheable(value="AllPaperPublicByTeacher",key="'Paperlist_'+#user.userid")
	List<Paper> selectPaperPublic(User usesr);
	
	@Cacheable(value="AllPaperunPublicByTeacher",key="'Paperlist_'+#user.userid")
	List<Paper> selectPaperunPublic(User user);

	@Cacheable(value="AllPaperKnowledge",key="'Knowledgelist_'+#paper.paperid")
	List<String> getKnowledge(Paper paper);
	//添加试卷
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher",key="'Paperlist_'+#p.winder"),
			@CacheEvict(value="AllPaperunPublicByTeacher",key="'Paperlist_'+#p.winder"),
			@CacheEvict(value="PaperByid", allEntries=true,beforeInvocation=true)})
	int addPaper(Paper p);
	//更新试卷
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid", allEntries=true,beforeInvocation=true)})
	int updateByPaperId(Paper paper);
	//删除试卷
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher",key="'Paperlist_'+#p.winder"),
			@CacheEvict(value="AllPaperunPublicByTeacher",key="'Paperlist_'+#p.winder"),
			@CacheEvict(value="AllPaperKnowledge",key="'Knowledgelist_'+#p.paperid"),
			@CacheEvict(value="PaperByid", allEntries=true,beforeInvocation=true)})	
	int deletePaper(Paper p);
	//发布试卷
	@Caching(evict={@CacheEvict(value="AllPaperunPublicByTeacher",key="'Paperlist_'+#p.winder"),
			@CacheEvict(value="AllPaperPublicByTeacher",key="'Paperlist_'+#p.winder"),
			@CacheEvict(value="PaperByid", allEntries=true,beforeInvocation=true)})	
	int publishPaper(Paper p);	
	
	
	
	@Caching(evict={@CacheEvict(value="AllPaperByStudent",key="'Paperlist_'+#p.examinee"),
			@CacheEvict(value="PaperByid", allEntries=true,beforeInvocation=true)})
	int addPaperExamniee(Paper p);
	@CacheEvict(value="AllPaperByStudent",key="'Paperlist_'+#userid")
	int Buypaper(Paper paper,int userid);
	
	@Caching(evict={@CacheEvict(value="AllPaperByStudent", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid", allEntries=true,beforeInvocation=true)})
	List<Integer> addPaper(Paper p,Groups g);
	//学生获得试卷
	@Cacheable(value="AllPaperByStudent",key="'Paperlist_'+#user.userid")
	List<Paper> selectAllPaper(User user);
	List<Paper> selectAllPaperWaitingToFinish(User user);
	List<Paper> selectAllPaperFinished(User user);
	List<Paper> selectAllPaperWaitingToStart(User user);
	List<Paper> selectAllPaperOutOfDate(User user);
	List<Paper> selectAllPaperInitial(User user);
	//学生获得测试试卷
	List<Paper> selectAllPaperWaitingToTest(User user);
	List<Paper> selectAllPaperTestFinished(User user);
	
	
	//教师获得试卷
	
	List<Paper> selectAllPaperWaitingToFinishTeacher(User user);
	List<Paper> selectAllPaperFinishedTeacher(User user);
	List<Paper> selectAllPaperWaitingToStartTeacher(User user);
	List<Paper> selectAllPaperOutOfDateTeacher(User user);
	List<Paper> selectAllPaperInitialTeacher(User user);
	List<Paper> selectAllPaperDone(int paperid);
	List<Paper> selectAllPaperUndo(int paperid);
	List<User> selectAllUserDone(int paperid);
	List<User> selectAllUserUndo(int paperid);
	//智能组卷得到知识点及对应题目数
	HashMap<String, Integer> getSingleKnowledgeAndNumber(List<Bank> banks);
	HashMap<String, Integer> getMutipleKnowledgeAndNumber(List<Bank> banks);
	HashMap<String, Integer> getJudgeKnowledgeAndNumber(List<Bank> banks);
	HashMap<String, Integer> getFillKnowledgeAndNumber(List<Bank> banks);
	HashMap<String, Integer> getShortanswerKnowledgeAndNumber(List<Bank> banks);
	//智能组卷创建试卷
	Paper intelligentFillPaper(HashMap<String, Integer> hashmap1,int score,List<Bank> banks,Paper paper);
	//智能组卷创建试卷
	Paper intelligentSinglePaper(HashMap<String, Integer> hashmap1,int score,List<Bank> banks,Paper paper);
	//智能组卷创建试卷
	Paper intelligentMultiplePaper(HashMap<String, Integer> hashmap1,int score,List<Bank> banks,Paper paper);
	//智能组卷创建试卷
	Paper intelligentJudgePaper(HashMap<String, Integer> hashmap1,int score,List<Bank> banks,Paper paper);
	//智能组卷创建试卷
	Paper intelligentShortanswerPaper(HashMap<String, Integer> hashmap1,int score,List<Bank> banks,Paper paper);
	
	
	
	
	//获得根据邀请码以及考生的id获得试卷
	List<Paper> selectPaperByInvitationcode(String s,Integer userid);
	//获得某个试卷所有学生的分数(根据母本试卷的id获得)
	List<Integer> AllStudentScore(int paperId);

	//通过知识点获得题目数
	int getFillnumByknowledge(Paper_fill pf);
	int getSinglenumByknowledge(Paper_single ps);
	int getMultiplenumByknowledge(Paper_multiple pm);
	int getJudgenumByknowledge(Paper_judge pj);
	int getShortanswernumByknowledge(Paper_shortanswer ps);
	
	
	
	 
	//按知识点删题
	@Caching(evict={@CacheEvict(value="AllPaperKnowledge",key="'Knowledgelist_'+#pf.paperid"),
			@CacheEvict(value="PaperByid",key="'Paper_'+#pf.paperid")})
	int deleteFillByknowledge(Paper_fill pf);
	@Caching(evict={@CacheEvict(value="AllPaperKnowledge",key="'Knowledgelist_'+#ps.paperid"),
			@CacheEvict(value="PaperByid",key="'Paper_'+#ps.paperid")})
	int deleteSingleByknowledge(Paper_single ps);
	@Caching(evict={@CacheEvict(value="AllPaperKnowledge",key="'Knowledgelist_'+#pm.paperid"),
			@CacheEvict(value="PaperByid",key="'Paper_'+#pm.paperid")})
	int deleteMultipleByknowledge(Paper_multiple pm);
	@Caching(evict={@CacheEvict(value="AllPaperKnowledge",key="'Knowledgelist_'+#pj.paperid"),
			@CacheEvict(value="PaperByid",key="'Paper_'+#pj.paperid")})
	int deleteJudgeByknowledge(Paper_judge pj);
	@Caching(evict={@CacheEvict(value="AllPaperKnowledge",key="'Knowledgelist_'+#ps.paperid"),
			@CacheEvict(value="PaperByid",key="'Paper_'+#ps.paperid")})
	int deleteShortanswerByknowledge(Paper_shortanswer ps);

	List<Paper> selectByExample(PaperExample paperexample);
	Paper selectByUser(int paperid,int userid);
	
	

}
