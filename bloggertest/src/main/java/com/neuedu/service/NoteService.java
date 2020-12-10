
package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Note;
import com.neuedu.entity.User;

public interface NoteService {

	
	List<Note> selectByUser(User user);
}
