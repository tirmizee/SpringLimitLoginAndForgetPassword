package com.tirmizee.backend.api.role.data;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.core.repository.RoleRepository;

public class RoleDTO implements Serializable {

	private static final long serialVersionUID = -5473376488320583586L;
	
	private Integer roleId;
	
	@SortColumn(value = RoleRepository.COL_ROLENAME)
	private String roleName;
	
	@SortColumn(value = RoleRepository.COL_ROLEDESC)
	private String roleDesc;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@SortColumn(value = RoleRepository.COL_CREATEDATE)
	private Timestamp createDate;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
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
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
