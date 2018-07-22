package com.tirmizee.backend.api.attemp.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class SearchAttempDTO implements Serializable {

	private static final long serialVersionUID = 7159828524673959116L;
	
	private String username;
	private Integer attempts;
	
	public String getUsername() {
		return StringUtils.trimToNull(username);
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAttempts() {
		return attempts;
	}
	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}
	
}
