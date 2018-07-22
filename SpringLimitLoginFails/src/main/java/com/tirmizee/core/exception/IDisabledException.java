package com.tirmizee.core.exception;

import org.springframework.security.authentication.AccountStatusException;

public class IDisabledException extends AccountStatusException {
	
	private static final long serialVersionUID = -1948451099752695948L;
	
	private String username;

	public IDisabledException(String msg) {
		super(msg);
	}
	
	public IDisabledException(String username,String msg) {
		super(msg);
		this.username = username;
	}

	public IDisabledException(String msg, Throwable t) {
		super(msg, t);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
