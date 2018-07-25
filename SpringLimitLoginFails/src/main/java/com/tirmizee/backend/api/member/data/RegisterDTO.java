package com.tirmizee.backend.api.member.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class RegisterDTO implements Serializable{

	private static final long serialVersionUID = -3247340123940969166L;
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	
}
