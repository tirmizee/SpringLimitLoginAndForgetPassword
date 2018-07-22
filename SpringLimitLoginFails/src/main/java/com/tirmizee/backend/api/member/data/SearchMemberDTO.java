package com.tirmizee.backend.api.member.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class SearchMemberDTO implements Serializable {

	private static final long serialVersionUID = -2163093759953608403L;
	
	private String username;
	private String email;
	private String enabled;
	private String accountNonLocked;
	private String accountNonExpired;
	private String credentialsNonExpired;
	private Integer roleId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return StringUtils.trimToNull(username);
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return StringUtils.trimToNull(email);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnabled() {
		return StringUtils.trimToNull(enabled);
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getAccountNonLocked() {
		return StringUtils.trimToNull(accountNonLocked);
	}
	public void setAccountNonLocked(String accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public String getAccountNonExpired() {
		return StringUtils.trimToNull(accountNonExpired);
	}
	public void setAccountNonExpired(String accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public String getCredentialsNonExpired() {
		return StringUtils.trimToNull(credentialsNonExpired);
	}
	public void setCredentialsNonExpired(String credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
}
