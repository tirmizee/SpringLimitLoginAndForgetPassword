package com.tirmizee.backend.api.role.data;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class CreateRoleDTO implements Serializable{

	private static final long serialVersionUID = -869423964805284998L;
	
	@NotBlank
	private String roleName;
	
	private String roleDesc;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
