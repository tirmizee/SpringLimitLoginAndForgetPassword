package com.tirmizee.backend.service;

import java.sql.Timestamp;

import com.tirmizee.backend.api.password.data.ChangePasswordDTO;

public interface EnforceChangePasswordService {
	
	void changePasswordFirstLogin(ChangePasswordDTO changePasswordDTO);
	
	void changePasswordExpired(ChangePasswordDTO changePasswordDTO);
	
	void updatePasswordExpired(String username);
	
	boolean isPasswordExpired(Timestamp ExpiryDate);

}


