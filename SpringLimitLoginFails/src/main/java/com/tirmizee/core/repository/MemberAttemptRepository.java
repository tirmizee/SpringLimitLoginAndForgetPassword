package com.tirmizee.core.repository;

import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface MemberAttemptRepository extends JdbcRepository<MemberAttempt, Long>{

	public static final String TABLE_MEMBERATTEMPT = "MemberAttempt";
	public static final String COL_ID = "id";
	public static final String COL_USERNAME = "username";
	public static final String COL_ATTEMPTS = "attempts";
	public static final String COL_LASTMODIFIED = "lastModified";
	
	public static final String ID = "MemberAttempt.id";
	public static final String USERNAME = "MemberAttempt.username";
	public static final String ATTEMPTS = "MemberAttempt.attempts";
	public static final String LASTMODIFIED = "MemberAttempt.lastModified";
	
}