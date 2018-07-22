package com.tirmizee.backend.api.permission.data;

import java.io.Serializable;

public class RoleMapPermissonDTO implements Serializable {

	private static final long serialVersionUID = 5310623022226855845L;
	
	private Integer roleId;
	private Long perId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
	}

}
