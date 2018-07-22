package com.tirmizee.backend.api.member.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberUpdateDTO implements Serializable {
	
	private static final long serialVersionUID = 3958063264395392758L;
	
	private String username;
	private Integer fkRoleId;
	private String roleName;
	private String email;
	private Timestamp credentialsExpiredDate;
	
	public Timestamp getCredentialsExpiredDate() {
		return credentialsExpiredDate;
	}
	public void setCredentialsExpiredDate(Timestamp credentialsExpiredDate) {
		this.credentialsExpiredDate = credentialsExpiredDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getFkRoleId() {
		return fkRoleId;
	}
	public void setFkRoleId(Integer fkRoleId) {
		this.fkRoleId = fkRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
