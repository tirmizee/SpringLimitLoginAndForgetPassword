package com.tirmizee.backend.service;

import com.tirmizee.backend.api.password.data.ResetPasswordDTO;

public interface ForgetPasswordService {
	
	Boolean forgetPassword(String email);
	
	Boolean isTokenExpired(String token);
	
	void resetPassword(ResetPasswordDTO passwordDTO);

}
