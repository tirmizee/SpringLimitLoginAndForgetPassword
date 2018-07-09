package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

import java.sql.Timestamp;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Integer;

public class Member implements Persistable<String>{

	private static final long serialVersionUID = 1L;
	private transient boolean persisted;
	
	private String username;
	private String password;
	private Integer fkRoleId;
	private String email;
	private Boolean enabled;
	private Boolean accountNonLocked;
	private Boolean accountNonExpired;
	private Boolean credentialsNonExpired;
	private Boolean initialLogin;
	private Timestamp credentialsExpiredDate;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	@Override
	public String getId() {
		return username;
	}

	@Override
	public boolean isNew() {
		return !persisted;
	}
	
	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFkRoleId() {
		return fkRoleId;
	}

	public void setFkRoleId(Integer fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	public Boolean getInitialLogin() {
		return initialLogin;
	}

	public void setInitialLogin(Boolean initialLogin) {
		this.initialLogin = initialLogin;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getCredentialsExpiredDate() {
		return credentialsExpiredDate;
	}

	public void setCredentialsExpiredDate(Timestamp credentialsExpiredDate) {
		this.credentialsExpiredDate = credentialsExpiredDate;
	}

	public Member withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}

	@Override
	public String toString() {
		return "Member [username=" + username + ", password=" + password + ", fkRoleId=" + fkRoleId + ", email=" + email
				+ ", enabled=" + enabled + ", accountNonLocked=" + accountNonLocked + ", accountNonExpired="
				+ accountNonExpired + ", credentialsNonExpired=" + credentialsNonExpired + ", initialLogin="
				+ initialLogin + ", credentialsExpiredDate=" + credentialsExpiredDate + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
