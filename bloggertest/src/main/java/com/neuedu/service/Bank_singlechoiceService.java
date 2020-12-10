package com.neuedu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import com.neuedu.entity.Bank_multiplechoice;
import com.neuedu.entity.Bank_singlechoice;

public interface Bank_singlechoiceService {
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int updateBank_singlechoice(Bank_singlechoice bsc);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int deleteBank_singlechoice(Bank_singlechoice bsc);
	@Caching(evict={@CacheEvict(value="AllBankByuser", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankByfolder", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="AllBankKnowledge", allEntries=true,beforeInvocation=true),
			@CacheEvict(value="BankByid",allEntries=true,beforeInvocation=true)
			})
	int addBank_singlechoice(Bank_singlechoice choice);
	List<Bank_singlechoice> selectByqid(Bank_singlechoice choice);


}
