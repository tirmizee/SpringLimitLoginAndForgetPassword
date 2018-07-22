package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.api.attemp.data.MemberAttemptDTO;
import com.tirmizee.backend.api.attemp.data.SearchAttempDTO;
import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.repository.MemberAttemptRepository;

public interface MemberAttemptDao extends MemberAttemptRepository{
	
	MemberAttempt findByUsername(String username);
	
	Page<MemberAttemptDTO> findByCriteria(SearchAttempDTO search, Pageable pageable);
	
}
