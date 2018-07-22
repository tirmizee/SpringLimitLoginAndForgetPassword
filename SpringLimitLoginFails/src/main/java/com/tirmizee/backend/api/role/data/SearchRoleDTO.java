package com.tirmizee.backend.api.role.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class SearchRoleDTO implements Serializable{

	private static final long serialVersionUID = 4773537281485599268L;
	
	private String roleName;
	private String roleDesc;
	
	public String getRoleName() {
		return StringUtils.trimToNull(roleName);
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return StringUtils.trimToNull(roleDesc);
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
