package com.tirmizee.backend.api.permission.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class SearchPermissionDTO implements Serializable {
	
	private static final long serialVersionUID = -5642043477777855908L;
	
	private Integer roleId;
	private String perCode;
	private String perName;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getPerCode() {
		return StringUtils.trimToNull(perCode);
	}
	public void setPerCode(String perCode) {
		this.perCode = perCode;
	}
	public String getPerName() {
		return StringUtils.trimToNull(perName);
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	
}
