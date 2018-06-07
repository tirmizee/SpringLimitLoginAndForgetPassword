package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Member;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface MemberRepository extends JdbcRepository<Member, String>{

	public static final String TABLE_MEMBER = "Member";
	public static final String COL_USERNAME = "username";
	public static final String COL_PASSWORD = "password";
	public static final String COL_FKROLEID = "fkRoleId";
	public static final String COL_EMAIL = "email";
	public static final String COL_ENABLED = "enabled";
	public static final String COL_ACCOUNTNONLOCKED = "accountNonLocked";
	public static final String COL_ACCOUNTNONEXPIRED = "accountNonExpired";
	public static final String COL_CREDENTIALSNONEXPIRED = "credentialsNonExpired";
	public static final String COL_INITIALLOGIN = "initialLogin";
	public static final String COL_INITIALLOGINTOKEN = "initialLoginToken";
	public static final String COL_CREATEDATE = "createDate";
	public static final String COL_UPDATEDATE = "updateDate";
	
	public static final String USERNAME = "Member.username";
	public static final String PASSWORD = "Member.password";
	public static final String FKROLEID = "Member.fkRoleId";
	public static final String ENABLED = "Member.enabled";
	public static final String ACCOUNTNONLOCKED = "Member.accountNonLocked";
	public static final String ACCOUNTNONEXPIRED = "Member.accountNonExpired";
	public static final String CREDENTIALSNONEXPIRED = "Member.credentialsNonExpired";
	public static final String INITIALLOGIN = "Member.initialLogin";
	public static final String INITIALLOGINTOKEN = "Member.initialLoginToken";
	public static final String CREATEDATE = "Member.createDate";
	public static final String UPDATEDATE = "Member.updateDate";
	
}