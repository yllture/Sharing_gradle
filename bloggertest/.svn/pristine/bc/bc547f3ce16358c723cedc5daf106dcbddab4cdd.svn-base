package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Paper_fillchoice;

public interface Paper_fillchoiceService {
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int addPaper_fillchoice(Paper_fillchoice choice);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int deletePaper_fillchoice(Paper_fillchoice choice);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int updatePaper_fillchoice(Paper_fillchoice choice);
	List<Paper_fillchoice> selectByqid(Paper_fillchoice choice);

}
