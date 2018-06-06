package com.tirmizee.backend.dao;

import com.tirmizee.core.domain.ForgetPassword;
import com.tirmizee.core.repository.ForgetPasswordRepository;

public interface ForgetPasswordDao extends ForgetPasswordRepository{
	
	ForgetPassword findByToken(String token);
	
	ForgetPassword findByUsername(String username);

}
