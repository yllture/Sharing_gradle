package com.neuedu.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_single;
import com.neuedu.entity.User;

public interface ExamService {
	List<Paper> getExamingPaper(User user);
	List<Paper> getExamdonePaper(User user);
	List<Paper> getunExamPaper(User user);
	//得到考试试卷
	List<Paper> getExamineePapers(Paper paper);
	
	//自动判卷（单选题）
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int autoCheckSingle(Paper paper);
	//自动判卷（多选题）
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int autoCheckMutiple(Paper paper);
	//自动判卷（判断题）
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int autoCheckJudge(Paper paper);
	//考生合分
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int getExamScore(Paper paper);
	//根据母本在paper中生成相应试卷记录
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int creatExampaper(Paper paper,User user);
	//导出成绩
	HashMap<String, Integer> getExamResult(Paper paper);
	//得到考生填空题的回答信息
	HashMap<Paper_fill,Integer> getfillResult(Paper paper);
	//得到考生单选题的回答信息
	HashMap<Paper_single, List<Integer>> getsingleResult(Paper paper);
	//得到考生的判断题回答信息
	HashMap<Paper_judge,Integer> getjudgeResult(Paper paper);
	//得到考生的简答题回答信息
	HashMap<Paper_shortanswer,Integer> getshortanswerResult(Paper paper);
	//得到考生的多选题回答信息= 
	HashMap<Paper_multiple,List<Integer>> getmultipleResult(Paper paper);
	
	
	//得到考试学生的成绩
	List<Integer> getStudentScores(Paper paper);
	//获得单选题正确的人数
	HashMap<Paper_single,Integer> getsingleRightNum(Paper paper);
	//获得多选题正确的人数
	HashMap<Paper_multiple,Integer> getmultipleRightNum(Paper paper);
	//更新教师母本试卷的donenum
	int updateTeacherPaperDonenum(Paper paper);
	//复制试卷
	int copyPaper(Paper paper);
	
}
