package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

import java.lang.Long;
import java.sql.Timestamp;
import java.lang.Integer;

public class RoleMapPermission implements Persistable<Long>{

	private static final long serialVersionUID = 1L;
	private transient boolean persisted;
	
	private Long id;
	private Integer fkRoleId;
	private Long fkPerId;
	private Timestamp createDate;
	
	@Override
	public Long getId() {
		return id;
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

	public Integer getFkRoleId() {
		return fkRoleId;
	}

	public void setFkRoleId(Integer fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public Long getFkPerId() {
		return fkPerId;
	}

	public void setFkPerId(Long fkPerId) {
		this.fkPerId = fkPerId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleMapPermission withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}
	
}
