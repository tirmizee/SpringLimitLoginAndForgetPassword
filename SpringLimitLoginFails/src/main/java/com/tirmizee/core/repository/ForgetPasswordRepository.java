package com.tirmizee.core.repository;

import com.tirmizee.core.domain.ForgetPassword;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface ForgetPasswordRepository extends JdbcRepository<ForgetPassword, Long>{

	public static final String TABLE_FORGETPASSWORD = "ForgetPassword";
	
	public static final String COL_ID = "id";
	public static final String COL_USERNAME = "username";
	public static final String COL_TOKEN = "token";
	public static final String COL_ACCESSIP = "accessIP";
	public static final String COL_EXPIRYDATE = "expiryDate";
	public static final String COL_CREATEDATE = "createDate";

	public static final String ID = "ForgetPassword.id";
	public static final String USERNAME = "ForgetPassword.username";
	public static final String TOKEN = "ForgetPassword.token";
	public static final String ACCESSIP = "ForgetPassword.accessIP";
	public static final String EXPIRYDATE = "ForgetPassword.expiryDate";
	public static final String CREATEDATE = "ForgetPassword.createDate";
	
}
