package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Garbage_bank;

public interface Garbage_bankService {
	
	/**
	 * 通过bankid查找Garbage_bank
	 * @param gb
	 * @return
	 */
	Garbage_bank selectGarbage_bank(Garbage_bank gb);
	
	/**
	 * 通过userid找到所有未在文件夹中的bank
	 * @param gb
	 * @return
	 */
	List<Garbage_bank> getAllByuserid(Garbage_bank gb);
	
	/**
	 * 通过folderid找到所有在文件中的bank
	 * @param gb
	 * @return
	 */
	List<Garbage_bank> getAllFolderid(Garbage_bank gb);
	
	int addGarbage_bank(Garbage_bank gb);
	int updateGarbage_bank(Garbage_bank gb);
	int deleteGarbage_bank(Garbage_bank gb);
	
	
	

}
