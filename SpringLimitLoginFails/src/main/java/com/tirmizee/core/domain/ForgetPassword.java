package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class ForgetPassword implements Persistable<Long>{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String token;
	private String accessIP;
	private java.sql.Timestamp expiryDate;
	private java.sql.Timestamp createDate;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean isNew() {
		return id == null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccessIP() {
		return accessIP;
	}

	public void setAccessIP(String accessIP) {
		this.accessIP = accessIP;
	}

	public java.sql.Timestamp getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(java.sql.Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}
	
}
