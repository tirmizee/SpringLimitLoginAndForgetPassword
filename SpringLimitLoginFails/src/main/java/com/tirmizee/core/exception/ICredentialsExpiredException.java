package com.tirmizee.core.exception;

import java.sql.Date;

import org.springframework.security.authentication.AccountStatusException;

public class ICredentialsExpiredException extends AccountStatusException{

	private static final long serialVersionUID = 1370154016872385051L;
	
	private String username;
	private Date lastModified;

	public ICredentialsExpiredException(String msg) {
		super(msg);
	}
	
	public ICredentialsExpiredException(String username, String msg) {
		super(msg);
		this.username = username;
	}
	
	public ICredentialsExpiredException(String username, Date lastModified, String msg) {
		super(msg);
		this.username = username;
		this.lastModified = lastModified;
	}
	
	public ICredentialsExpiredException(String msg, Throwable t) {
		super(msg, t);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
