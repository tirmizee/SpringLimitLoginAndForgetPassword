 package com.tirmizee.core.exception;

import org.springframework.security.authentication.AccountStatusException;

public class IAccountExpiredException extends AccountStatusException {
	
	private static final long serialVersionUID = 3669477514411097680L;
	
	private String username;
	
	public IAccountExpiredException(String msg) {
		super(msg);
	}
	
	public IAccountExpiredException(String username,String msg) {
		super(msg);
		this.username = username;
	}

	public IAccountExpiredException(String msg, Throwable t) {
		super(msg, t);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
