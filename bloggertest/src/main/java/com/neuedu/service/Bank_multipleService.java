package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Bank;
import com.neuedu.entity.Bank_multiple;

public interface Bank_multipleService {
	
	List<Bank_multiple> getAllbyBankid(Bank b);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)})
	int addBank_multiple(Bank_multiple bm);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)})
	int updateBank_multiple(Bank_multiple bm);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)})
	int deleteBank_multiple(Bank_multiple bm);
	Bank_multiple selectBank_multiple(Bank_multiple bf);
}
