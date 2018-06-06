package com.tirmizee.backend.service;

public interface MemberAttemptService {
	
	void updateMemberAttempt(String username);
	
	void resetMemberAttempt(String username);
	
}
