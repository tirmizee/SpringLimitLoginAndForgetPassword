package com.tirmizee.backend.dao;

import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.repository.MemberAttemptRepository;

public interface MemberAttemptDao extends MemberAttemptRepository{
	
	MemberAttempt findByUsername(String username);
	
}
