package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

import java.sql.Timestamp;
import java.lang.String;
import java.lang.Integer;

public class Role implements Persistable<Integer>{

	private static final long serialVersionUID = 1L;
	private transient boolean persisted;
	
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	@Override
	public Integer getId() {
		return roleId;
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

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Role withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}
	
}
