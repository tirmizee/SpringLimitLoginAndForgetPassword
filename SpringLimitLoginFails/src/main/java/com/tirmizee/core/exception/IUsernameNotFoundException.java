package com.tirmizee.core.exception;

import org.springframework.security.core.AuthenticationException;

public class IUsernameNotFoundException  extends AuthenticationException{

	private static final long serialVersionUID = -511054654903112476L;
	
	private String username;

	public IUsernameNotFoundException(String msg) {
		super(msg);
	}
	
	public IUsernameNotFoundException(String username, String msg) {
		super(msg);
		this.username = username;
	}
	
	public IUsernameNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
