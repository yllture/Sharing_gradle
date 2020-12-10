package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.*;
public interface Paper_multipleService {
	
	List<Paper_multiple> getAllbyPaperid(Paper paper);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int addPaper_multiple(Paper_multiple pf);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int deletePaper_multiple(Paper_multiple pf);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int updatePaper_multiple(Paper_multiple pf);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int addPaper_multiple2(Bank_multiple pf,Integer score,Paper paper);
	Paper_multiple selectPaper_multiple(Paper_multiple pm);
}
