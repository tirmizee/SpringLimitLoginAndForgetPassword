package com.tirmizee.backend.dao;

import com.tirmizee.core.domain.Member;
import com.tirmizee.core.repository.MemberRepository;

public interface MemberDao extends MemberRepository{
	
	Member findByUsername(String username);
	
	Member findByEmail(String email);
	
	Member findByToken(String token);
}
