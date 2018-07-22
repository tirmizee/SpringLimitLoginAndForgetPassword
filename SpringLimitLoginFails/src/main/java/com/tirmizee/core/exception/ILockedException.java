package com.tirmizee.core.exception;

import org.springframework.security.authentication.AccountStatusException;

public class ILockedException extends AccountStatusException {
	
	private static final long serialVersionUID = -5354319840087579899L;
	
	private String username;
	
	public ILockedException(String msg) {
		super(msg);
	}
	
	public ILockedException(String username, String msg) {
		super(msg);
		this.username = username;
	}

	public ILockedException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
