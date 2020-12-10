package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Examrecord;

public interface ExamrecordService {
	int updateExamrecordById(Examrecord record);
	int addExamrecord(Examrecord record);
	Examrecord selectRelTime(int paperid);
	List<Examrecord> selectRecordByPaperId(int paperid);
	List<Examrecord> selectRecordByDoingAndPaperId(int paperid,String dothing);
}
