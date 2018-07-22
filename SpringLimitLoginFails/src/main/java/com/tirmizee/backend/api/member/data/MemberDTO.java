package com.tirmizee.backend.api.member.data;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.core.repository.MemberRepository;
import com.tirmizee.core.repository.RoleRepository;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = -8463120997306392029L;
	
	@SortColumn(value = MemberRepository.COL_USERNAME)
	private String username;
	
	private Integer fkRoleId;
	
	@SortColumn(value = RoleRepository.COL_ROLENAME)
	private String roleName;
	
	@SortColumn(value = MemberRepository.COL_EMAIL)
	private String email;
	private Boolean enabled;
	private Boolean accountNonLocked;
	private Boolean accountNonExpired;
	private Boolean credentialsNonExpired;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@SortColumn(value = MemberRepository.COL_CREDENTIALSEXPIREDDATE)
	private Timestamp credentialsExpiredDate;
	
	private Timestamp createDate;
	
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
	public Timestamp getCredentialsExpiredDate() {
		return credentialsExpiredDate;
	}
	public void setCredentialsExpiredDate(Timestamp credentialsExpiredDate) {
		this.credentialsExpiredDate = credentialsExpiredDate;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
}
