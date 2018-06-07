package com.tirmizee.backend.api.password.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ResetPasswordDTO implements PasswordConfirmation,Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String token;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public boolean isPasswordsEqualConstraint() {
		return password.equals(confirmPassword);
	}
	
}
