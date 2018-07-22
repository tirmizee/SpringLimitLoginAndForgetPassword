package com.tirmizee.backend.api.member.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class MemberAccountNonExpiredDTO implements Serializable {

	private static final long serialVersionUID = -2257298060644222988L;
	
	@NotNull
	private String username;
	
	@NotNull
	private Boolean accountNonExpired;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
}
