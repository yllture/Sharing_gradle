package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.entity.Bank_singlechoice;

public interface Bank_fillchoiceService {
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int updateBankfillchoice(Bank_fillchoice bfc);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int deleteBankfillchoice(Bank_fillchoice bfc);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int addBank_fillchoice(Bank_fillchoice choice);
	List<Bank_fillchoice> selectByqid(Bank_fillchoice choice);

}
