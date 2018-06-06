package com.tirmizee.backend.api.password;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.password.data.ForgetPasswordDTO;
import com.tirmizee.backend.api.password.data.ResetPasswordDTO;
import com.tirmizee.backend.service.ForgetPasswordService;

@RestController
@RequestMapping(path="api/password")
public class RestForgetPassword {
	
	@Autowired
	private ForgetPasswordService forgetPasswordService; 
	
	@PostMapping(path="/forget")
	public Boolean forgetPassword(@RequestBody ForgetPasswordDTO requestDTO){
		return forgetPasswordService.forgetPassword(requestDTO.getEmail());
	}
	
	@PostMapping(path="/reset")
	public Boolean resetPassword(@RequestBody @Valid ResetPasswordDTO passwordDTO){
		forgetPasswordService.resetPassword(passwordDTO);
		return true;
	}
	
}
