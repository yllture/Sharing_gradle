package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.ExamrecordMapper;
import com.neuedu.entity.Examrecord;
import com.neuedu.entity.ExamrecordExample;
import com.neuedu.entity.ExamrecordExample.Criteria;
import com.neuedu.service.ExamrecordService;
@Service
public class ExamrecordServiceImpl  implements ExamrecordService{
	@Autowired
	ExamrecordMapper examrecordMapper;
	ExamrecordExample examrecordExample;
	@Override
	public int updateExamrecordById(Examrecord record) {
		// TODO Auto-generated method stub
		return examrecordMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int addExamrecord(Examrecord record) {
		// TODO Auto-generated method stub
		return examrecordMapper.insert(record);
	}
	@Override
	public Examrecord selectRelTime(int paperid) {
		// TODO Auto-generated method stub
		ExamrecordExample examrecordExample=new ExamrecordExample();
		Criteria c1=examrecordExample.createCriteria();
		c1.andPaperidEqualTo(paperid);
		List<Examrecord> er=examrecordMapper.selectByExample(examrecordExample);
		return er.get(0);
	}
	@Override
	public List<Examrecord> selectRecordByPaperId(int paperid) {
		// TODO Auto-generated method stub
		 examrecordExample=new  ExamrecordExample();
		 Criteria c=examrecordExample.createCriteria();
		 c.andPaperidEqualTo(paperid);
		 List<Examrecord> selectByExample = examrecordMapper.selectByExample(examrecordExample);
		 Collections.sort(selectByExample, new Comparator<Examrecord>(){
	            public int compare(Examrecord o1, Examrecord o2) {
	                //排序属性
	                if(o1.getBegintime().compareTo(o2.getBegintime()) <0 ){
	                    return 1;
	                }
	                if(o1.getBegintime() == o2.getBegintime()){
	                    return 0;
	                }
	                return -1;
	            }
	        });  
		 
		 return selectByExample;
		
     }
	@Override
	public List<Examrecord> selectRecordByDoingAndPaperId(int paperid, String dothing) {
		// TODO Auto-generated method stub
		List<Examrecord> selectRecordByPaperId = selectRecordByPaperId(paperid);
		List<Examrecord> newList=new ArrayList<Examrecord>();
		for(Examrecord e:selectRecordByPaperId) {
			if(e.getDothing().equals(dothing)) {
				newList.add(e);
			}
		}
		
		return newList;
	}
		
	

}
