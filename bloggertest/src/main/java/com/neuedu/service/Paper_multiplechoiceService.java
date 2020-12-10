package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Paper_multiplechoice;

public interface Paper_multiplechoiceService {
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int addPaper_multiplechoice(Paper_multiplechoice choice);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int deletePaper_multiplechoice(Paper_multiplechoice choice);
	@Caching(evict={@CacheEvict(value="AllPaperByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperunPublicByTeacher", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllPaperKnowledge",allEntries=true,beforeInvocation=true),
			@CacheEvict(value="PaperByid",allEntries=true,beforeInvocation=true)})
	int updatePaper_multiplechoice(Paper_multiplechoice choice);
	List<Paper_multiplechoice> selectByqid(Paper_multiplechoice choice);
}
