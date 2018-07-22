package com.tirmizee.core.exception;

import org.springframework.security.core.AuthenticationException;

public class IBadCredentialsException extends AuthenticationException{

	private static final long serialVersionUID = 1136342392953942239L;
	
	private String username;

	public IBadCredentialsException(String msg) {
		super(msg);
	}
	
	public IBadCredentialsException(String username,String msg) {
		super(msg);
		this.username = username;
	}
	
	public IBadCredentialsException(String msg, Throwable t) {
		super(msg, t);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
