package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeadController {
	
	@RequestMapping("/toStudentHead")
	public String toStudentHead() {
		return "studentHead.html";
	}
	
	@RequestMapping("/toTeacherHead")
	public String toTeacherHead() {
		return "teacherHead.html";
	}
	

}
