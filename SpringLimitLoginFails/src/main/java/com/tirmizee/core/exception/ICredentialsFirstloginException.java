package com.tirmizee.core.exception;

import org.springframework.security.core.AuthenticationException;

public class ICredentialsFirstloginException extends AuthenticationException{
	
	private String username;
	
	private static final long serialVersionUID = -8656133918396104440L;

	public ICredentialsFirstloginException(String msg) {
		super(msg);
	}

	public ICredentialsFirstloginException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public ICredentialsFirstloginException(String username ,String msg) {
		super(msg);
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
