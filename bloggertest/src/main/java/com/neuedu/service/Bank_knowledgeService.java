package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_knowledge;

public interface Bank_knowledgeService {
	
	@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true)
	int addBank_knowlede(Bank_knowledge bk);
	
	List<Bank_knowledge> selectAllbyBankid(Bank b);
	

}
