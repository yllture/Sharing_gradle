package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Garbage_bankfolder;

public interface Garbage_bankfolderService {
	int addGarbage_bankfolder(Garbage_bankfolder gb);
	int updateGarbage_bankfolder(Garbage_bankfolder gb);
	int deleteGarbage_bankfolder(Garbage_bankfolder gb);
	
	Garbage_bankfolder seleteByfolderid(Garbage_bankfolder gb);
	/**
	 * 通过userid获得所有的文件夹
	 * @param gb
	 * @return
	 */
	List<Garbage_bankfolder> getAllByuserid(Garbage_bankfolder gb);
	
	/**
	 * 通过foldermapping获得所有此文件夹中的文件夹
	 * @param gb
	 * @return
	 */
	List<Garbage_bankfolder> getAllByfoldermapping(Garbage_bankfolder gb);
}
