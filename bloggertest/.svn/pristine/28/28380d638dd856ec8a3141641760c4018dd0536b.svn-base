package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.*;

public interface Paper_singleService {
	
	List<Paper_single> getAllbyPaperid(Paper paper);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int addPaper_single(Paper_single ps);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int deletePaper_single(Paper_single ps);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int updatePaper_single(Paper_single ps);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int addPaper_single(Bank_single ps,Integer score,Paper paper);
	Paper_single selectPaper_single(Paper_single ps);

}
