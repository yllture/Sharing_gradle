package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.entity.Note;
import com.neuedu.entity.User;
import com.neuedu.service.NoteService;

@Controller
public class InformController {
	
	@Autowired
	NoteService noteservice;
	
	 
	
	@RequestMapping("/inform")
	public String Inform(HttpServletRequest request,Model model) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		User user=new User();
		user.setUserid(currentUser.getUserid());
		List<Note> notes=noteservice.selectByUser(user);
		List<Note> checknotes=new ArrayList<Note>();
		List<Note> papernotes=new ArrayList<Note>();
		List<Note> scorenotes=new ArrayList<Note>();
		for(int i=0;i<notes.size();i++)
		{
			Note note=notes.get(i);
			if(note.getType()==1)
			{
				papernotes.add(note);
			}
			else if(note.getType()==2)
			{
				scorenotes.add(note);
			}
			else if(note.getType()==0)
			{
				if(note.getC1()==0)
				{
					note.setC3("已经通过审核");
				}
				else
				{
					note.setC3("没有通过审核");
				}
				checknotes.add(note);
			}
		}
	    model.addAttribute("currentUser",currentUser);	
		model.addAttribute("notes",notes);
//		model.addAttribute("checknotes",checknotes);
//		model.addAttribute("papernotes",papernotes);
//		model.addAttribute("scorenotes",scorenotes);
//	
		return "userInfor/inform";
	}
}
