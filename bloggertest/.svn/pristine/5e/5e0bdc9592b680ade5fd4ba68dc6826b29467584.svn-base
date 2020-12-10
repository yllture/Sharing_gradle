package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Paper_fill;
import com.neuedu.entity.Paper_judge;
import com.neuedu.entity.Paper_multiple;
import com.neuedu.entity.Paper_shortanswer;
import com.neuedu.entity.Paper_single;
import com.neuedu.service.ExamService;
import com.neuedu.service.PaperService;

@Controller
public class PaperStatisticController {
	@Autowired 
	ExamService examService;
	@Autowired 
	PaperService paperService;
	
	@RequestMapping("/toPaperstatistic")
	public  String topaperstatistic(@RequestParam Integer paperid,HttpServletRequest req,HttpServletResponse res)  {
		JSONObject object=new JSONObject();
		Paper paper = paperService.selectPaperbyId(paperid);
		//找到该试卷所有分数的学生
		List<Integer> examScore = examService.getStudentScores(paper);
		//
		List<Paper> examineePapers = examService.getExamineePapers(paper);
		int num=0;
		if(examineePapers!=null&&examineePapers.size()!=0) {
			num=examineePapers.size();
		}
		if(examScore!=null&&examScore.size()!=0) {
		object.put("scores", examScore);
		}
		//得到单选题的数量
		HashMap<Paper_single, Integer> getsingleRightNum = examService.getsingleRightNum(paper);
		List<Double> singleright=new ArrayList<Double>();
		for(Entry<Paper_single, Integer> entry:getsingleRightNum.entrySet()) {
			if(examineePapers!=null&&examineePapers.size()!=0) {
			singleright.add(entry.getValue()/(double)num);
			}else {
				singleright.add(0.0);
				
			}
			
		}
		
		//得到多选题正确的数量
		HashMap<Paper_multiple, Integer> getmultipleRightNum = examService.getmultipleRightNum(paper);
		List<Double> multipleright=new ArrayList<Double>();
		for(Entry<Paper_multiple, Integer> entry:getmultipleRightNum.entrySet()) {
			
			if(examineePapers!=null&&examineePapers.size()!=0) {
				multipleright.add(entry.getValue()/(double)num);
				}else {
					multipleright.add(0.0);
					
				}
			
		}
		//得到判断题正确的数量
		HashMap<Paper_judge, Integer> getjudgeResult = examService.getjudgeResult(paper);
		List<Double> judgeright=new ArrayList<Double>();
		for(Entry<Paper_judge, Integer> entry: getjudgeResult.entrySet()) {
			if(examineePapers!=null&&examineePapers.size()!=0) {
			 judgeright.add(entry.getValue()/(double)num);
			}else {
				judgeright.add(0.0);
			}
		}
		//得到填空题正确的数量
		HashMap<Paper_fill, Integer> getfillResult = examService.getfillResult(paper);
		List<Double> fillright=new ArrayList<Double>();
		for(Entry<Paper_fill, Integer> entry:getfillResult.entrySet()) {
			if(examineePapers!=null&&examineePapers.size()!=0) {
			fillright.add(entry.getValue()/(double)num);
			}
			else {
				fillright.add(0.0);
				
			}
			
		}
		//得到简答题正确的数量
		HashMap<Paper_shortanswer, Integer> getshortanswerResult = examService.getshortanswerResult(paper);
		List<Double> shortanswerright=new ArrayList<Double>();
		for(Entry<Paper_shortanswer, Integer> entry:getshortanswerResult.entrySet()) {
			if(examineePapers!=null&&examineePapers.size()!=0) {
			fillright.add(entry.getValue()/(double)num);
			}else {
				fillright.add(0.0);
			}
			
		}
		object.put("singleData", singleright);
		object.put("multipleData", multipleright);
		object.put("judgeData", judgeright);
		object.put("fillData", fillright);
		object.put("shortanswerData", shortanswerright);
		req.setAttribute("datas", JSON.toJSONString(object));
		return "teacherPaper/paperStatistic";
	}

}
