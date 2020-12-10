package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Bank_fillchoice;
import com.neuedu.entity.Bank_multiplechoice;

public interface Bank_multiplechoiceService {
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int updateBank_multiplechoice(Bank_multiplechoice bmc);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int deleteBank_multiplechoice(Bank_multiplechoice bmc);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int addBank_multiplechoice(Bank_multiplechoice choice);
	List<Bank_multiplechoice> selectByqid(Bank_multiplechoice choice);

}
