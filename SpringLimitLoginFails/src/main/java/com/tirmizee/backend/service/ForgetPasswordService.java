package com.tirmizee.backend.service;

import com.tirmizee.backend.api.password.data.ResetPasswordDTO;

public interface ForgetPasswordService {
	
	Boolean forgetPassword(String email);
	
	void resetPassword(ResetPasswordDTO passwordDTO);
	
	Boolean isTokenExpired(String token);

}
