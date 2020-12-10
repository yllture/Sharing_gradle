package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_judge;

public interface Bank_judgeService {
	
	List<Bank_judge> getAllbyBankid(Bank b);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)})
	int addBank_judge(Bank_judge bj);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)})
	int updateBank_judge(Bank_judge bj);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)})
	int deleteBank_judge(Bank_judge bj);
	
	Bank_judge selectBank_judge(Bank_judge bf);
	

}
