package com.tirmizee.backend.api.password.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ChangePasswordDTO implements PasswordConfirmation, Serializable{

	private static final long serialVersionUID = 5474147949569465008L;
	
	@NotNull
	private String username;

	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
