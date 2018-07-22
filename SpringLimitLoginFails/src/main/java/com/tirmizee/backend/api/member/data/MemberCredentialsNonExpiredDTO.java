package com.tirmizee.backend.api.member.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class MemberCredentialsNonExpiredDTO implements Serializable {

	private static final long serialVersionUID = 2244122730403007693L;
	
	@NotNull
	private String username;
	
	@NotNull
	private Boolean credentialsNonExpired;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
}
