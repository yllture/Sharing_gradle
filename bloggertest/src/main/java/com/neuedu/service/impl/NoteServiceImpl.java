
package com.neuedu.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.NoteMapper;
import com.neuedu.entity.Note;
import com.neuedu.entity.User;
import com.neuedu.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteMapper noteMapper;

	@Override
	public List<Note> selectByUser(User user) {
		List<Note> notes=noteMapper.selectByUser(user);
		return notes;
	}
	





}





